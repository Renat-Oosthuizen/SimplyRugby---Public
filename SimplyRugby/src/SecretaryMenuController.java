import java.util.LinkedList;

/**
 * This is the Controller class for the View class SecretaryMenuScreen. 
 * It executes the majority of the logic behind SecretaryMenuScreen.
 *@author Renat Oosthuizen
 *@since 10/05/2021
 */
public class SecretaryMenuController {

	
	/**SecretaryhMenuScreen variable used to store in instance of the SecretaryMenuScreen class.*/
	private SecretaryMenuScreen sms;
	
	/**LinkedList variable that contains objects. It will hold the ID, Full Name and User/Player Type of every profile in the system (except that of the logged secretary).*/
	private LinkedList<Object> profileData = new LinkedList<Object>();
	
	/**
	 * Default constructor for the SecretaryMenuController.
	 * This will fetch IDs, names and player types for all profiles (excluding that of the logged secretary) from the database. Create an instance of the SecretaryMenuScreen and then make it visible.
	 * SecretaryMenuScreen will populate itself with the IDs, names and user/player types.
	 */
	public SecretaryMenuController() {
		
		//Send query to the database that will fetch ID, Full Name and User/Player Type of every profile in the system (except that of the logged secretary).
		profileData = MainClass.getDataManager().sendMultiQuery("SELECT ProfileID, FullName, UserType FROM ProfileTable INNER JOIN UserTable ON ProfileTable.ProfileID = UserTable.UserID WHERE ProfileID <> '" + MainClass.getDataManager().getLoggedUser().getID() + "' UNION SELECT ProfileID, FullName, PlayerType FROM ProfileTable INNER JOIN PlayerTable ON ProfileTable.ProfileID = PlayerTable.PlayerID ");		
		
		sms = new SecretaryMenuScreen(this); //sms is a new instance of class SecretaryMenuScreen that accepts Controller class as a parameter.
		
		//Make SecretaryMenuScreen visible.
		sms.setVisible(true);
	}
	
	/**
	 * Function for logging out the user.
	 */
	public void logout() {
		
		MainClass.getDataManager().setLoggedUser(null); //Forget logged user.
		LoginController.reappear(); //Make login screen visible.
	}
	
	/**
	 * Function for opening the View that displays the details of the logged user.
	 */
	@SuppressWarnings("unused")
	public void showMyDetails() {
		
		MainClass.setTargetType("loggedUser"); //Set targetType to loggedUser.
		ProfileController pc = new ProfileController(); //Create and display a profile screen.
	}
	
	/**
	 * Function for opening the View that lists all the profiles in the system.
	 */
	@SuppressWarnings("unused")
	public void showViewAccounts() {
		
		SecretaryMenuController smc = new SecretaryMenuController(); //Create and display a secretary menu screen.
	}
	
	/**
	 * Function for creating a brand new profile.
	 */
	@SuppressWarnings("unused")
	public void showNewAccount() {
		
		MainClass.setNewAccount(true); //Set targetType to newAccount.
		ProfileController pc = new ProfileController(); //Create and display a profile screen.
	}
	
	/**
	 * This function will display the profile page with data from the profile who's index has been passed into the function.
	 * @param index is the index of the profile selected in the JList of SecretaryMenuScreen.
	 */
	@SuppressWarnings("unused")
	public void showPlayerDetails(int index) {
		
		importProfile((int) profileData.get(index*3)); //Import data for target ProfileID into an object (multiplied by 3 as there will be 3 data elements for each profile)
		
		ProfileController pc = new ProfileController(); //Create and display a profile screen.
	}

	/**
	 * Function responsible for importing from the database and storing the details of the players in sPlayer, jPlayer or nPlayer objects.
	 * @param ID which is the ID of the player in various database tables.
	 */
	private void importProfile(int ID) {
		
		String playerType = MainClass.getDataManager().sendQuery("SELECT PlayerType FROM PlayerTable INNER JOIN ProfileTable ON PlayerTable.PlayerID = ProfileTable.ProfileID WHERE ProfileID = '" + ID + "'"); //Get player type from the database.
		
		LinkedList<Object> playerProfile = MainClass.getDataManager().sendMultiQuery("SELECT * FROM ProfileTable WHERE ProfileID = '" + ID + "'"); //Array stores the contents of the ProfileTable for target player.
		
		if (playerType.equals("NonPlayer")) {
			
			//Construct a NonPlayer object with data from the database.
			MainClass.getDataManager().setNPlayer(new NonPlayer(
					(int) playerProfile.get(0), 
					(String) playerProfile.get(1), 
					(String) playerProfile.get(2), 
					(String) playerProfile.get(3), 
					(String) playerProfile.get(4),  
					((java.sql.Date) playerProfile.get(5)).toLocalDate(), 
					(String) playerProfile.get(6), 
					(String) playerProfile.get(7), 
					(String) playerProfile.get(8), 
					(String) playerProfile.get(9), 
					(String) playerProfile.get(10), 
					(String) playerProfile.get(11), 
					(String) playerProfile.get(12)));
			
			MainClass.setTargetType("nPlayer"); //Set targetType to nPlayer.

		}
		else if (playerType.equals("SeniorPlayer")) {
			
			LinkedList<Object> playerSkill = MainClass.getDataManager().sendMultiQuery("SELECT * FROM SkillTable WHERE SkillSetID = '" + ID + "'"); //LinkedList stores the contents of the SkillTable for target player.
			
			MainClass.getDataManager().setSPlayer(new SeniorPlayer(
					(int) playerProfile.get(0), 
					(String) playerProfile.get(1), 
					(String) playerProfile.get(2), 
					(String) playerProfile.get(3), 
					(String) playerProfile.get(4),  
					((java.sql.Date) playerProfile.get(5)).toLocalDate(), 
					(String) playerProfile.get(6), 
					(String) playerProfile.get(7), 
					(String) playerProfile.get(8), 
					(String) playerProfile.get(9), 
					(String) playerProfile.get(10), 
					(String) playerProfile.get(11), 
					(String) playerProfile.get(12),
					
					(String) playerSkill.get(1),
					(String) playerSkill.get(2),
					(String) playerSkill.get(3),
					(String) playerSkill.get(4),
					(String) playerSkill.get(5),
					(int) playerSkill.get(6),
					(int) playerSkill.get(7),
					(int) playerSkill.get(8),
					(int) playerSkill.get(9),
					(int) playerSkill.get(10),
					(int) playerSkill.get(11),
					(int) playerSkill.get(12),
					(int) playerSkill.get(13),
					(int) playerSkill.get(14),
					(int) playerSkill.get(15),
					(int) playerSkill.get(16)));
			
			MainClass.setTargetType("sPlayer"); //Set targetType to sPlayer.
			
		}
		else if (playerType.equals("JuniorPlayer")){
			
			LinkedList<Object> playerSkill = MainClass.getDataManager().sendMultiQuery("SELECT * FROM SkillTable WHERE SkillSetID = '" + ID + "'"); //LinkedList stores the contents of the SkillTable for target player. 
			LinkedList<Object> juniorProfile = MainClass.getDataManager().sendMultiQuery("SELECT * FROM JuniorPlayerTable WHERE JPlayerID = '" + ID + "'"); //LinkedList stores the contents of the JuniorPlayerTable for target player.
			
			MainClass.getDataManager().setJPlayer(new JuniorPlayer(
					(String) juniorProfile.get(1),
					(String) juniorProfile.get(2),
					(String) juniorProfile.get(3),
					(String) juniorProfile.get(4),
					(String) juniorProfile.get(5),
					(String) juniorProfile.get(6),
					(String) juniorProfile.get(7),
					
					(int) playerProfile.get(0), 
					(String) playerProfile.get(1), 
					(String) playerProfile.get(2), 
					(String) playerProfile.get(3), 
					(String) playerProfile.get(4),  
					((java.sql.Date) playerProfile.get(5)).toLocalDate(), 
					(String) playerProfile.get(6), 
					(String) playerProfile.get(7), 
					(String) playerProfile.get(8), 
					(String) playerProfile.get(9), 
					(String) playerProfile.get(10), 
					(String) playerProfile.get(11), 
					(String) playerProfile.get(12),
					
					(String) playerSkill.get(1),
					(String) playerSkill.get(2),
					(String) playerSkill.get(3),
					(String) playerSkill.get(4),
					(String) playerSkill.get(5),
					(int) playerSkill.get(6),
					(int) playerSkill.get(7),
					(int) playerSkill.get(8),
					(int) playerSkill.get(9),
					(int) playerSkill.get(10),
					(int) playerSkill.get(11),
					(int) playerSkill.get(12),
					(int) playerSkill.get(13),
					(int) playerSkill.get(14),
					(int) playerSkill.get(15),
					(int) playerSkill.get(16)));
			
			MainClass.setTargetType("jPlayer"); //Set targetType to jPlayer.

		}
		else {
			
			String userType = MainClass.getDataManager().sendQuery("SELECT UserType FROM UserTable INNER JOIN ProfileTable ON UserTable.UserID = ProfileTable.ProfileID WHERE UserID = '" + ID + "'"); //Get the UserType  from the database.
			
			//Construct a user with data from database.
			MainClass.getDataManager().setUser(new User(
					(int) playerProfile.get(0), 
					userType, 
					(String) playerProfile.get(1), 
					(String) playerProfile.get(2), 
					(String) playerProfile.get(3), 
					(String) playerProfile.get(4),  
					((java.sql.Date) playerProfile.get(5)).toLocalDate(), 
					(String) playerProfile.get(6), 
					(String) playerProfile.get(7), 
					(String) playerProfile.get(8), 
					(String) playerProfile.get(9), 
					(String) playerProfile.get(10), 
					(String) playerProfile.get(11), 
					(String) playerProfile.get(12)));
			
			MainClass.setTargetType("user");  //Set targetType to user.
		}
		
	}
	/*---GETTERS---*/
	
	/**
	 * Getter for the SecretaryMenuController class.
	 * @return profileData which will hold the ID, Full Name and Player Type of every Junior and Senior Player.
	 */
	public LinkedList<Object> getProfileData() {
		return profileData;
	}
}
