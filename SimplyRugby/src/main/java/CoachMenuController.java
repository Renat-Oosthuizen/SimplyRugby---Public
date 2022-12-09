import java.util.LinkedList;

/**
 * This is the Controller class for the View class CoachMenuScreen. 
 * It executes the majority of the logic behind CoachMenuScreen.
 *@author Renat Oosthuizen
 *@since 10/05/2021
 */
public class CoachMenuController {

	/**CoachMenuScreen variable used to store in instance of the CoachMenuScreen class.*/
	private CoachMenuScreen cms;
	
	/**LinkedList variable that contains objects. It will hold the ID, Full Name and Player Type of every Junior and Senior Player.*/
	private LinkedList<Object> playerData = new LinkedList<Object>();
	
	/**
	 * Default constructor for the CoachMenuController.
	 * This will fetch IDs, names and player types for all player from the database. Create an instance of the CoachMenuScreen and then make it visible.
	 * CoachMenuScreen will populate itself with the IDs, names and player types.
	 */
	public CoachMenuController() {
		
		//Send query to the database to fetch PlayerID, FullName, PlayerType from Junior and Senior Players only.
		playerData = MainClass.getDataManager().sendMultiQuery("SELECT PlayerID, FullName, PlayerType FROM PlayerTable INNER JOIN ProfileTable ON PlayerTable.PlayerID = ProfileTable.ProfileID WHERE PlayerType = 'JuniorPlayer' OR PlayerType = 'SeniorPlayer'");
		
		cms = new CoachMenuScreen(this); //cms is a new instance of class CoachMenuScreen that accepts CoachMenuController class as a parameter.
		
		//Make CoachMenuScreen visible.
		cms.setVisible(true);
	}
	
	/**
	 * Function for logging out the user.
	 */
	public void logout() {
		
		MainClass.getDataManager().setLoggedUser(null); //Forget the logged user.
		LoginController.reappear(); //Make login screen visible.
	}
	
	/**
	 * Function for opening the View that displays the details of the logged user.
	 */
	@SuppressWarnings("unused")
	public void showMyDetails() {
		
		MainClass.setTargetType("loggedUser"); //Set targetType to loggedUser
		ProfileController pc = new ProfileController(); //Create and display a profile screen.
	}
	
	/**
	 * Function for opening the View that lists all the players in the system
	 */
	@SuppressWarnings("unused")
	public void showViewPlayers() {
		
		CoachMenuController cmc = new CoachMenuController(); //Create and display a new coach menu screen.
	}
	
	/**
	 * Function for opening the View that lists all the squads in the system that the logged in coach is a member of.
	 */
	@SuppressWarnings("unused")
	public void showViewSquads() {
		
		ViewSquadsController vsc = new ViewSquadsController(); //Create and display a view squads screen.
	}
	
	/**
	 * This function will display the profile page with data from the profile who's index has been passed into the function.
	 * @param index is the index of the profile selected in the JList of CoachMenuScreen.
	 */
	@SuppressWarnings("unused")
	public void showPlayerDetails(int index) {
		
		importProfile((int) playerData.get(index*3)); //Import data for target ProfileID into an object (multiplied by 3 as there will be 3 data elements for each profile).
		
		ProfileController pc = new ProfileController(); //Create a new profile page.
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
	 * Getter for the CoachMenuController class.
	 * @return playerData which will hold the ID, Full Name and Player Type of every Junior and Senior Player.
	 */
	public LinkedList<Object> getPlayerData() {
		return playerData;
	}

}
