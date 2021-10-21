import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.LinkedList;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * This is the Controller class for the View class LoginScreen. 
 * It executes the majority of the logic behind LoginScreen.
 *@author Renat Oosthuizen
 *@since 12/05/2021
 */
public class LoginController {
	
	/**LoginScreen variable used to store in instance of the LoginScreen class.*/
	private static LoginScreen ls;
	
	/**
	 * Default constructor for the LoginController.
	 * It will then create an instance of the LoginScreen and make it visible.
	 */
	public LoginController() {
		
		ls = new LoginScreen(this); //ls is a new instance of class LoginScreen that accepts the Controller class as a parameter.
		
		//Make LoginScreen visible.
		ls.setVisible(true);
	}
	
	/**
	 * This function responsible for validating user credential and sending them to the appropriate page.
	 * @param email is the email submitted the the user on the login screen.
	 * @param password is the password submitted by the user on the login screen.
	 * @return result which is true if the user has been authenticated and false if not.
	 */
	@SuppressWarnings("unused")
	public boolean performLogin(String email, String password) {
		
		/**String variable that stores the hash received from the database.*/
		String storedHash = ""; 
		/**boolean variable that stores true if the user has been authenticated and false if not.*/
		boolean result = false; 
		
		//Query the database for a password hash while passing an email as a search query.
		storedHash = MainClass.getDataManager().sendQuery("Select PassHash FROM UserTable INNER JOIN ProfileTable ON UserTable.UserID = ProfileTable.ProfileID WHERE Email = '" + email + "'"); 
		
		//Try to validate the email password combo. Catch is triggered if email is invalid and therefore the storedHash is "";
		try {
			
			result = validatePassword(password, storedHash); //Check if entered password produces an identical password hash. Returns true or false.
		}
		catch (Exception e) {}
		
		
		if (result == true) {
			
			importLoggedUser(email); //Store the details of the logged user.
			
			//Display a different screen to user depending on if they are a Secretary or a Coach.
			if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Secretary")) {
				
				ls.setVisible(false); //Hide the login screen.
				SecretaryMenuController smc = new SecretaryMenuController(); //Display the secretary menu to user.
			}
			else {
				
				ls.setVisible(false); //Hide the login screen.
				CoachMenuController cmc = new CoachMenuController(); //Display the coach menu to user.
				
			}
			
		}
		
		return result; //Send result back to LoginScreen.
		
	}
	
	
	/**
	 * Function that compares a password to it's hash from database.
	 * @param originalPassword is the password entered by the user on the login screen.
	 * @param storedPassword is the password hash from the database that matches the mail submitted by the user on the login screen.
	 * @return diff which will be true if the passwords match and false if the passwords do not match.
	 */
    private boolean validatePassword(String originalPassword, String storedPassword)
    {
        String[] parts = storedPassword.split(":"); //Split the password hash into the different sections.
        int iterations = Integer.parseInt(parts[0]); //First part contains the number of hashing iterations. This is the hashing difficulty and can be increased as processing power increases to make brute force attacks less viable.
        byte[] salt = fromHex(parts[1]); //This is the unique salt used in the creation of this password hash, stored as a byte array. Prevents use of rainbow tables during password cracking forcing the use of brute force attacks.
        byte[] hash = fromHex(parts[2]); //The hash for the actual password, stored as a byte array.
         
        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8); //Generate a PBEKey of variable-key-size PBE ciphers.
        SecretKeyFactory skf = null; //Will store a SecretKeyFactory object.
        
		try {
			skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); //Returns a SecretKeyFactory object that converts secret keys of the specified algorithm.
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
        byte[] testHash = null; //Will store a byte array of a SecretKey objected generated based on the specifications of the stored password hash.
        
		try {
			testHash = skf.generateSecret(spec).getEncoded(); //Generate a SecretKey object from the provided key specification and then encode it to into bytes.
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
         
        int diff = hash.length ^ testHash.length; //Stores the difference in length between the hash byte array and the test hash byte array.
        
        //Check if the two byte array have differences.
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0; //Convert the difference into a boolean and return it. Will return true if there is no difference.
    }
    
    /**
     * Function that converts a hexadecimal value into a byte value.
     * @param hex is a hexadecimal hash value. 
     * @return bytes which is an array of bytes that the hexadecimal value converts into.
     */
    private byte[] fromHex(String hex)
    {
        byte[] bytes = new byte[hex.length() / 2]; //The number of bytes in the byte array is the length of the hexadecimal string divided by two. 
        
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16); //Convert the hexadecimal value into a byte value.
        }
        return bytes; //Return the array of bytes.
    }
    
	/**
	 * Function responsible for importing from the database and storing the details of the logged user in the loggedUser object.
	 * @param email which is the email of the loggedUser.
	 */
	private void importLoggedUser(String email) {
		
		LinkedList<Object> userProfile = MainClass.getDataManager().sendMultiQuery("SELECT * FROM ProfileTable WHERE Email = '" + email + "'"); //LinkedList stores the contents of the ProfileTable for target user.
		String userType = MainClass.getDataManager().sendQuery("SELECT UserType FROM UserTable INNER JOIN ProfileTable ON UserTable.UserID = ProfileTable.ProfileID WHERE Email = '" + email + "'"); //Get the UserType from the database.
		
		//Construct loggedUser with data from database.
		MainClass.getDataManager().setLoggedUser(new User(
				(int) userProfile.get(0), 
				userType, 
				(String) userProfile.get(1), 
				(String) userProfile.get(2), 
				(String) userProfile.get(3), 
				(String) userProfile.get(4),  
				((java.sql.Date) userProfile.get(5)).toLocalDate(), 
				(String) userProfile.get(6), 
				(String) userProfile.get(7), 
				(String) userProfile.get(8), 
				(String) userProfile.get(9), 
				(String) userProfile.get(10), 
				(String) userProfile.get(11), 
				(String) userProfile.get(12)));
		
	}
	
    /**
     * Function to make the login screen visible again.
     */
    public static void reappear() {
    	
    	ls.setVisible(true); //Make the login screen visible.
    }
    
}
