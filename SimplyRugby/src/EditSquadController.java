import javax.swing.JOptionPane;

/**
 * This is the Controller class for the View class EditSquadScreen. 
 * It executes the majority of the logic behind EditSquadScreen.
 *@author Renat Oosthuizen
 *@since 12/05/2021
 */
public class EditSquadController {

	/**EditSquadScreen variable used to store an instance of the EditSquadScreen class.*/
	private EditSquadScreen ess;
	
	/**
	 * Default constructor for the EditSquadController. 
	 * It will create an instance of the EditSquadScreen, populate it with name of squad and names of members (from the database) where able, and then make it visible.
	 */
	public EditSquadController() {
		
		ess = new EditSquadScreen(this); //ess is a new instance of class EditSquadScreen that accepts EditSquadController class as a parameter.
		
		getNames(); //Populate the page with names of players and coaches as well as the squad name.
		
		ess.setVisible(true); //Make EditSquadScreen visible.	
	
	}
	
	/**
	 * Function for logging out the user.
	 */
	public void logout() {
		
		MainClass.getDataManager().setLoggedUser(null); //Forget logged user.
		LoginController.reappear(); //Make the login screen visible.
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
	 * Populates Squad positions with player names (instead of Profile IDs) and squad name.
	 * By default empty slot IDs contain 0. If statements are used to prevent updating squad positions where IDs are 0 to reduce load on database.
	 */
	private void getNames() {
		
		ess.setTextFieldSquadName((String) MainClass.getDataManager().sendQuery("SELECT SquadName FROM SquadTable WHERE SquadID = '" + MainClass.getDataManager().getSquad().getSquadID() + "' ")); //Get squad name from database.
		
		//For each position get the player/coach name from database if the ID is not 0 (default empty).
		if (MainClass.getDataManager().getSquad().getCoach1() != 0) {ess.setTextFieldCoach1((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getCoach1() + "' "));}
		if (MainClass.getDataManager().getSquad().getCoach2() != 0) {ess.setTextFieldCoach2((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getCoach2() + "' "));}
		if (MainClass.getDataManager().getSquad().getCoach3() != 0) {ess.setTextFieldCoach3((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getCoach3() + "' "));}
		if (MainClass.getDataManager().getSquad().getHookerID() != 0) {ess.setTextFieldHooker((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getHookerID() + "' "));}
		if (MainClass.getDataManager().getSquad().getLeftPropID() != 0) {ess.setTextFieldLeftProp((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getLeftPropID() + "' "));}
		if (MainClass.getDataManager().getSquad().getRightPropID() != 0) {ess.setTextFieldRightProp((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getRightPropID() + "' "));}
		if (MainClass.getDataManager().getSquad().getLeftLockID() != 0) {ess.setTextFieldLeftLock((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getLeftLockID() + "' "));}
		if (MainClass.getDataManager().getSquad().getRightLockID() != 0) {ess.setTextFieldRightLock((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getRightLockID() + "' "));}
		if (MainClass.getDataManager().getSquad().getLeftFlankerID() != 0) {ess.setTextFieldLeftFlanker((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getLeftFlankerID() + "' "));}
		if (MainClass.getDataManager().getSquad().getRightFlankerID() != 0) {ess.setTextFieldRightFlanker((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getRightFlankerID() + "' "));}
		if (MainClass.getDataManager().getSquad().getNumberEightID() != 0) {ess.setTextFieldNumberEight((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getNumberEightID() + "' "));}
		if (MainClass.getDataManager().getSquad().getScrumHalfID() != 0) {ess.setTextFieldScrumHalf((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getScrumHalfID() + "' "));}
		if (MainClass.getDataManager().getSquad().getFlyHalfID() != 0) {ess.setTextFieldFlyHalf((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getFlyHalfID() + "' "));}
		if (MainClass.getDataManager().getSquad().getInnerCentreID() != 0) {ess.setTextFieldInnerCentre((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getInnerCentreID() + "' "));}
		if (MainClass.getDataManager().getSquad().getOuterCentreID() != 0) {ess.setTextFieldOuterCentre((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getOuterCentreID() + "' "));}
		if (MainClass.getDataManager().getSquad().getLeftWingID() != 0) {ess.setTextFieldLeftWing((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getLeftWingID() + "' "));}
		if (MainClass.getDataManager().getSquad().getRightWingID() != 0) {ess.setTextFieldRightWing((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getRightWingID() + "' "));}
		if (MainClass.getDataManager().getSquad().getFullBackID() != 0) {ess.setTextFieldFullBack((String) MainClass.getDataManager().sendQuery("SELECT FullName FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSquad().getFullBackID() + "' "));}

	}
	
	/**
	 * Saves IDs to the squad object and then saves the squad object in the database.
	 */
	@SuppressWarnings("unused")
	public void saveSquad() {
		
		boolean goodID = false; //Stays false if any of the ID boxes contains non-number (for some reason contents of the try fail silently so this is a way to generate an error message).
		
		//Write data to the Squad object (for text boxes that are not empty).
		try {
			if (!ess.getTextFieldSquadName().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setSquadName(ess.getTextFieldSquadName().getText()); } //Replace squadName of squad object.
			
			if (!ess.getTextFieldCoach1ID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setCoach1(Integer.parseInt(ess.getTextFieldCoach1ID().getText().trim())); } //Replace coach1 of squad object.
			if (!ess.getTextFieldCoach2ID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setCoach2(Integer.parseInt(ess.getTextFieldCoach2ID().getText().trim())); } //Replace coach2 of squad object.
			if (!ess.getTextFieldCoach3ID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setCoach3(Integer.parseInt(ess.getTextFieldCoach3ID().getText().trim())); } //Replace coach3 of squad object.
			if (!ess.getTextFieldHookerID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setHookerID(Integer.parseInt(ess.getTextFieldHookerID().getText().trim())); } //Replace hookerID of squad object.
			if (!ess.getTextFieldLeftPropID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setLeftPropID(Integer.parseInt(ess.getTextFieldLeftPropID().getText().trim())); } //Replace leftPropID of squad object.
			if (!ess.getTextFieldRightPropID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setRightPropID(Integer.parseInt(ess.getTextFieldRightPropID().getText().trim())); } //Replace rightPropID of squad object.
			if (!ess.getTextFieldLeftLockID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setLeftLockID(Integer.parseInt(ess.getTextFieldLeftLockID().getText().trim())); } //Replace leftLockID of squad object.
			if (!ess.getTextFieldRightLockID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setRightLockID(Integer.parseInt(ess.getTextFieldRightLockID().getText().trim())); } //Replace rightLockID of squad object. 
			if (!ess.getTextFieldLeftFlankerID().getText().trim().equals("")) {	MainClass.getDataManager().getSquad().setLeftFlankerID(Integer.parseInt(ess.getTextFieldLeftFlankerID().getText().trim())); } //Replace leftFlankerID of squad object.
			if (!ess.getTextFieldRightFlankerID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setRightFlankerID(Integer.parseInt(ess.getTextFieldRightFlankerID().getText().trim())); } //Replace rightFlankerID of squad object.
			if (!ess.getTextFieldNumberEightID().getText().trim().equals("")) {	MainClass.getDataManager().getSquad().setNumberEightID(Integer.parseInt(ess.getTextFieldNumberEightID().getText().trim())); } //Replace numberEightID of squad object.
			if (!ess.getTextFieldScrumHalfID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setScrumHalfID(Integer.parseInt(ess.getTextFieldScrumHalfID().getText().trim())); } //Replace scrumHalfID of squad object.
			if (!ess.getTextFieldFlyHalfID().getText().trim().equals("")) {	MainClass.getDataManager().getSquad().setFlyHalfID(Integer.parseInt(ess.getTextFieldFlyHalfID().getText().trim())); } //Replace flyHalfID of squad object.
			if (!ess.getTextFieldInnerCentreID().getText().trim().equals("")) {	MainClass.getDataManager().getSquad().setInnerCentreID(Integer.parseInt(ess.getTextFieldInnerCentreID().getText().trim())); } //Replace innerCentreID of squad object.
			if (!ess.getTextFieldOuterCentreID().getText().trim().equals("")) {	MainClass.getDataManager().getSquad().setOuterCentreID(Integer.parseInt(ess.getTextFieldOuterCentreID().getText().trim())); } //Replace outerCentreID of squad object.
			if (!ess.getTextFieldLeftWingID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setLeftWingID(Integer.parseInt(ess.getTextFieldLeftWingID().getText().trim())); } //Replace leftWingID of squad object.
			if (!ess.getTextFieldRightWingID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setRightWingID(Integer.parseInt(ess.getTextFieldRightWingID().getText().trim())); } //Replace rightWingID of squad object.
			if (!ess.getTextFieldFullBackID().getText().trim().equals("")) { MainClass.getDataManager().getSquad().setFullBackID(Integer.parseInt(ess.getTextFieldFullBackID().getText().trim())); } //Replace fullBackID of squad object.
			
			goodID = true; //Non of the above code failed so IDs are all of the correct format.
			
		} catch (Exception e){}
		
		//If ID is not good then...
		if (!goodID) {
			
			//Inform the user that the squad was not saved using a dialogue box.
			JOptionPane.showMessageDialog(ess,"Squad was not saved.\n" + "IDs cannot contain non-numbers.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		else {
			
			//Send data of squad object to database. 
			if (updateSquad() == 1) {
				
				//Inform the user that squad has been saved using a dialogue box.
				JOptionPane.showMessageDialog(ess,"Squad data updated successfully!\n" + "Note: IDs not matching existing profiles will not be displayed.\n", "Success!", JOptionPane.INFORMATION_MESSAGE);
				
				//Reload the page
				EditSquadController esc = new EditSquadController(); //Create a new Edit Squad page to display the player names.
				
				ess.dispose(); //Get rid of the old page.
				
			}
			else {
				
				//Inform the user that squad was not saved using a dialogue box.
				JOptionPane.showMessageDialog(ess,"Squad was not saved.\n" + "Squad name might be too long or not unique.", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	
	/**
	 * Delete the currently selected squad and takes user back to the View Squads page.
	 */
	@SuppressWarnings("unused")
	public void deleteSquad() {
		
		String query = "DELETE FROM SquadTable WHERE SquadID = '" + MainClass.getDataManager().getSquad().getSquadID() + "' "; //Query to delete the currently displayed squad from database.
			
		MainClass.getDataManager().sendUpdate(query); //Send query to database.
		
		//Inform the user that the profile has been deleted using a dialogue box.
		JOptionPane.showMessageDialog(ess,"Squad has been deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
	
		ViewSquadsController vsc = new ViewSquadsController(); //Exit this page and display the View Squads page.
		
	}
	
	/**
	 * Update data in database for the selected squad.
	 * @return '1' if query was executed successfully and '0' if the query failed to execute.
	 */
	private int updateSquad() {
		
		//Query for the database to update the squad currently being viewed with data in the local squad object.
		String query = "UPDATE SquadTable SET SquadName = '" + MainClass.getDataManager().getSquad().getSquadName() + "', Coach1 = '" + MainClass.getDataManager().getSquad().getCoach1() + "', Coach2 = '" + MainClass.getDataManager().getSquad().getCoach2() + "', Coach3 = '" + MainClass.getDataManager().getSquad().getCoach3() + "', HookerID = '" + MainClass.getDataManager().getSquad().getHookerID() + "', LeftPropID = '" + MainClass.getDataManager().getSquad().getLeftPropID() + "', RightPropID = '" + MainClass.getDataManager().getSquad().getRightPropID() + "', LeftLockID = '" + MainClass.getDataManager().getSquad().getLeftLockID() + "', RightLockID = '" + MainClass.getDataManager().getSquad().getRightLockID() + "', LeftFlankerID = '" + MainClass.getDataManager().getSquad().getLeftFlankerID() + "', RightFlankerID = '" + MainClass.getDataManager().getSquad().getRightFlankerID() + "', NumberEightID = '" + MainClass.getDataManager().getSquad().getNumberEightID() + "', ScrumHalfID = '" + MainClass.getDataManager().getSquad().getScrumHalfID() + "', FlyHalfID = '" + MainClass.getDataManager().getSquad().getFlyHalfID() + "', InnerCentreID = '" + MainClass.getDataManager().getSquad().getInnerCentreID() + "', OuterCentreID = '" + MainClass.getDataManager().getSquad().getOuterCentreID() + "', LeftWingID = '" + MainClass.getDataManager().getSquad().getLeftWingID() + "', RightWingID = '" + MainClass.getDataManager().getSquad().getRightWingID() + "', FullBackID = '" + MainClass.getDataManager().getSquad().getFullBackID() + "' WHERE SquadID = '" + MainClass.getDataManager().getSquad().getSquadID() + "' ";
		
		return MainClass.getDataManager().sendUpdate(query); //Execute the query and return result.
	}

}
