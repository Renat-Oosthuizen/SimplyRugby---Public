import java.util.LinkedList;

import javax.swing.JOptionPane;

/**
 * This is the Controller class for the View class ViewSquadsScreen. 
 * It executes the majority of the logic behind ViewSquadsScreen.
 *@author Renat Oosthuizen
 *@since 10/05/2021
 */
public class ViewSquadsController {

	/**ViewSquadsScreen variable used to store an instance of the ViewSquadsScreen class.*/
	private ViewSquadsScreen vss;
	
	/**LinkedList variable that contains objects. It will hold the SquadID and SquadName of every squad that the logged coach s a member of.*/
	private LinkedList<Object> squadData = new LinkedList<Object>(); 
	
	/**
	 * Default constructor for the ViewSquadsController.
	 * This will fetch SquadIDs and SquadNames of all squads that the logged coach is a member of from the database. 
	 * It will then create an instance of the ViewSquadsScreen and make it visible.
	 * ViewSquadsScreen will populate itself with the SquadIDs, SquadNames.
	 */
	public ViewSquadsController() {
		
		//Send query to the database to fetch SquadIDs and SquadNames of all squads that the logged coach is a member of.
		squadData = MainClass.getDataManager().sendMultiQuery("SELECT SquadID, SquadName FROM SquadTable WHERE Coach1 = '" + MainClass.getDataManager().getLoggedUser().getID() + "' OR Coach2 = '" + MainClass.getDataManager().getLoggedUser().getID() + "' OR Coach3 = '" + MainClass.getDataManager().getLoggedUser().getID() + "'"); 
		
		vss = new ViewSquadsScreen(this); //vss is a new instance of class ViewSquadsScreen that accepts Controller class as a parameter.
		
		//Make ViewSquadsScreen visible.
		vss.setVisible(true);
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
	 * This function will display the data for the squad who's index has been passed into the function.
	 * @param index is the index of the squad selected in the JList of ViewSquadsScreen.
	 */
	@SuppressWarnings("unused")
	public void showSquadDetails(int index) {
		
		importSquad((int) squadData.get(index*2)); //Import data for target SquadID into an object (multiplied by 2 because only every second index is a SquadName)
		
		EditSquadController esc = new EditSquadController(); //Create a new Edit Squad page.
	}
	
	/**
	 * This function will try to add a new squad to the database. It will inform the user of the outcome and reload the page to display the new squad in the JList.
	 */
	@SuppressWarnings("unused")
	public void createSquad() {
		
		//Create a new Squad
		if (createSquadDatabase(vss.getTextFieldSquadName().getText().trim(), MainClass.getDataManager().getLoggedUser().getID()) == 1) {
			
			
			//Inform the user that squad has been saved using a dialogue box.
			JOptionPane.showMessageDialog(vss,"Squad was created successfuly, it can be found below.", "Success!", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			
			//Inform the user that squad was not saved using a dialogue box.
			JOptionPane.showMessageDialog(vss,"Squad name is not unique or is over 20 characters long. Try again.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		
		ViewSquadsController vsc = new ViewSquadsController(); //Recreate the current page to display the new squad.
	}

	/**
	 * Function responsible for importing a squad from the database.
	 * @param squadID is the ID of the squad that is to be imported.
	 */
	private void importSquad(int squadID) {
		
		LinkedList<Object> squadData = MainClass.getDataManager().sendMultiQuery("SELECT * FROM SquadTable WHERE SquadID = '" + squadID + "'"); //Array stores the contents of the SquadTable for target squad. 
		
		MainClass.getDataManager().setSquad(new Squad(
				(int) squadData.get(0),
				(String) squadData.get(1),
				(int) squadData.get(2),
				(int) squadData.get(3),
				(int) squadData.get(4),
				(int) squadData.get(5),
				(int) squadData.get(6),
				(int) squadData.get(7),
				(int) squadData.get(8),
				(int) squadData.get(9),
				(int) squadData.get(10),
				(int) squadData.get(11),
				(int) squadData.get(12),
				(int) squadData.get(13),
				(int) squadData.get(14),
				(int) squadData.get(15),
				(int) squadData.get(16),
				(int) squadData.get(17),
				(int) squadData.get(18),
				(int) squadData.get(19)));

	}
	

	/**
	 * Function that creates a new Squad with the provided squad name and ID for Coach1, all other entries get 0s.
	 * @param name is the name of the squad that is to be created.
	 * @param coach1 is the ID of Coach1 in the squad.
	 * @return the number of lines changed in the database by the query.
	 */
	private int createSquadDatabase(String name, int coach1 ) {
		
		//Query that will be sent to the database.
		String query = "INSERT INTO SquadTable (SquadName, Coach1, Coach2, Coach3, HookerID, LeftPropID, RightPropID, LeftLockID, RightLockID, LeftFlankerID, RightFlankerID, NumberEightID, ScrumHalfID, FlyHalfID, InnerCentreID, OuterCentreID, LeftWingID, RightWingID, FullBackID) VALUES ('" + name + "',  '" + coach1 + "', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')";
		
		return MainClass.getDataManager().sendUpdate(query); //Send the query and return the number of lines changed in the database.
		
	}
	
	/*---GETTERS---*/
	
	/**
	 * Getter for the ViewSquadsController class.
	 * @return squadData which will hold the SquadID and SquadName of every squad that the logged coach is a member of.
	 */
	public LinkedList<Object> getSquadData() {
		return squadData;
	}
}
