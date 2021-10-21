/**
 * This class holds the public static main that launches the application. 
 * It creates contains holds instances of LoginController and DataManager classes.
 * It also tracks what type of content different view screen should be displaying.
 *@author Renat Oosthuizen
 *@since 09/05/2021
 *
 *
 */
public class MainClass {

	/**DataManager variable that holds an instance of the DataManager class*/
	private static DataManager dataManager = new DataManager();
	/**String variable that controls what variant of a View screen is displayed. Can hold "loggedUser", "user", "sPlayer", "nPlayer", "jPlayer"*/
	private static String targetType = ""; 
	/**boolean variable that tracks if the user is currently creating a new profile. User interface will be adjusted accordingly.*/
	private static boolean newAccount = false;
	
	
	/**
	 * This is the main function where the code begins to get executed. 
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		LoginController loginController = new LoginController(); //Creates an instance of the LoginController class.
		
	}
	

	/*---GETTERS---*/
	
	/**
	 * 
	 * @return dataManager which is an instance of the DataManager class.
	 */
	public static DataManager getDataManager() 
	{
		return dataManager;
	}
	
	/**
	 * 
	 * @return targetType which controls how Views should be displayed based on what kind of profile is currently being looked at.
	 */
	public static String getTargetType() {
		return targetType;
	}
	
	/**
	 * 
	 * @return newAccount which controls how Views should be displayed based on if they are currently being used to create a new account.
	 */
	public static boolean isNewAccount() {
		return newAccount;
	}

	
	/*---SETTERS---*/
	
	/**
	 * 
	 * @param targetType which controls how Views should be displayed based on what kind of profile is currently being looked at.
	 */
	public static void setTargetType(String targetType) {
		MainClass.targetType = targetType;
	}

	/**
	 * 
	 * @param newAccount which controls how Views should be displayed based on if they are currently being used to create a new account.
	 */
	public static void setNewAccount(boolean newAccount) {
		MainClass.newAccount = newAccount;
	}

}
