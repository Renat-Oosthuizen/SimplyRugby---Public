import javax.swing.JOptionPane;

/**
 * This is the Controller class for the View class JuniorScreen. 
 * It executes the majority of the logic behind JuniorScreen.
 *@author Renat Oosthuizen
 *@since 12/05/2021
 */
public class JuniorController {

	/**JuniorScreen variable used to store an instance of the JuniorScreen class.*/
	private JuniorScreen js;
	
	/**
	 * Default constructor for the JuniorController. 
	 * It will create an instance of the JuniorScreen, populate it with data from a junior player (from the database), and then make it visible.
	 */
	public JuniorController() {
		
		js = new JuniorScreen(this); //js is a new instance of class JuniorScreen that accepts JuniorController class as a parameter.
		
		populateByJuniorPlayer(); //Populate JuniorScreen with data for the selected profile.
		
		js.setVisible(true); //Make LoginScreen visible.
	}
	
	/**
	 * Function used to populate text field with data.
	 */
	private void populateByJuniorPlayer() {
		
		js.setTextFieldG1Relationship( MainClass.getDataManager().getJPlayer().getKinRelationship());
		js.setTextFieldG1Address( MainClass.getDataManager().getJPlayer().getKinAddress());
		js.setTextFieldG2Name( MainClass.getDataManager().getJPlayer().getKin2Name());
		js.setTextFieldG2Relationship( MainClass.getDataManager().getJPlayer().getKin2Relationship());
		js.setTextFieldG2TelNumber( MainClass.getDataManager().getJPlayer().getKin2TelNumber());
		js.setTextFieldDocAddress( MainClass.getDataManager().getJPlayer().getDoctorAddress());
		js.setTextFieldG2Address( MainClass.getDataManager().getJPlayer().getKin2Address());
		
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
		
		MainClass.setNewAccount(false); //Set newAccount to false.
		MainClass.setTargetType("loggedUser"); //Set targetType to loggedUser.
		ProfileController pc = new ProfileController(); //Create and display a profile screen.
	}
	
	/**
	 * Function for opening the View that lists all the players in the system.
	 * This function can only be called by coaches.
	 */
	@SuppressWarnings("unused")
	public void showViewPlayers() {
		
		CoachMenuController cmc = new CoachMenuController(); //Create and display a new coach menu screen.
	}
	
	/**
	 * Function for opening the View that lists all the squads in the system that the logged in coach is a member of.
	 * This function can only be called by coaches.
	 */
	@SuppressWarnings("unused")
	public void showViewSquads() {
		
		ViewSquadsController vsc = new ViewSquadsController(); //Create and display a view squads screen.
	}
	
	/**
	 * Function for opening the View that displays and allows the editing of the skills of the currently selected player.
	 * This function can only be called by coaches.
	 */
	@SuppressWarnings("unused")
	public void showPlayerSkills() {
		
		EditSkillsController esc = new EditSkillsController(); //Create and display an edit skills screen.
	}
	
	/**
	 * Function for opening the View that lists all the profiles in the system except for the currently logged secretary.
	 * This function can only be called by secretaries.
	 */
	@SuppressWarnings("unused")
	public void showViewAccounts() {
		
		MainClass.setNewAccount(false); //Set newAccount to false.
		SecretaryMenuController smc = new SecretaryMenuController(); //Create and display the secretary menu screen.
	}
	
	/**
	 * Function for opening a profile screen for the purposes of creating a brand new profile.
	 * JuniorScreen is responsible for asking the user what kind of profile they wish to create.
	 * This function can only be called by secretaries.
	 */
	@SuppressWarnings("unused")
	public void showNewAccount() {
		
		MainClass.setNewAccount(true); //Set targetType to newAccount
		ProfileController pc = new ProfileController(); //Create and display the profile screen of a brand new account.
	}
	
	/**
	 * Function to take a coach back to the profile page for the currently selected junior player.
	 * This function can only be called by coaches.
	 */
	@SuppressWarnings("unused")
	public void goBackCoach() {
		
		ProfileController pc = new ProfileController(); //Display the profile page for the junior player.
	}
	
	/**
	 * Function to take a secretary back to the profile page for the currently selected junior player. Current edits are temporarily saved.
	 * This function can only be called by secretaries.
	 */
	@SuppressWarnings("unused")
	public void goBackSecretary() {
		
		saveToObject(); //Save current data.
		JOptionPane.showMessageDialog(js,"Changes on this page have been remembered but not saved.", "Notification", JOptionPane.INFORMATION_MESSAGE); //Notify user that changes from this page will be remembered.
		ProfileController pc = new ProfileController(); //Display the profile page for the junior player.
	}
	
	/**
	 * Function that saves the Junior Player data to jPlayer object (but not to database).
	 * It is called when a secretary uses the Go Back button to return to the profile screen of a junior player.
	 * It is also called during the process of permanently saving the junior player data to the database.
	 * This function can only be called by secretaries.
	 */
	private void saveToObject() {
		
		//Save data from JuniorScreen to the jPlayer object.
		MainClass.getDataManager().getJPlayer().setKinRelationship(js.getTextFieldG1Relationship());
		MainClass.getDataManager().getJPlayer().setKinAddress(js.getTextFieldG1Address());
		MainClass.getDataManager().getJPlayer().setKin2Name(js.getTextFieldG2Name());
		MainClass.getDataManager().getJPlayer().setKin2Relationship(js.getTextFieldG2Relationship());
		MainClass.getDataManager().getJPlayer().setKin2TelNumber(js.getTextFieldG2TelNumber());
		MainClass.getDataManager().getJPlayer().setDoctorAddress(js.getTextFieldDocAddress());
		MainClass.getDataManager().getJPlayer().setKin2Address(js.getTextFieldG2Address());
	}
	
	
	/**
	 * Function used to create a new Junior Player and then return the secretary back to secretary menu.
	 * Saves new data to jPlayer object. Then inserts data from jPlayer into the database and informs the user if the operation succeeded.
	 * Note: Queries 2, 3 and 4 do not require user data and should always be executed successfully as long as the query 1 succeeds. Loss of internet connection mid-execution could cause problems.
	 * This function can only be called by secretaries.
	 */
	@SuppressWarnings("unused")
	public void saveNewJuniorPlayer() {  
		
		saveToObject(); //Save contents to object.

		//Queries to insert object into database and create additional necessary tables with default data (secretary cannot edit these tables).
		String query1 = "INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) VALUES ('" + MainClass.getDataManager().getJPlayer().getFullName() + "', '" + MainClass.getDataManager().getJPlayer().getAddress() + "', '" + MainClass.getDataManager().getJPlayer().getPostCode() + "', '" + MainClass.getDataManager().getJPlayer().getSRUNumber() + "', '" + MainClass.getDataManager().getJPlayer().getDOB() + "', '" + MainClass.getDataManager().getJPlayer().getTelNumber() + "', '" + MainClass.getDataManager().getJPlayer().getMobNumber() + "', '" + MainClass.getDataManager().getJPlayer().getEmail() + "', '" + MainClass.getDataManager().getJPlayer().getKinName() + "', '" + MainClass.getDataManager().getJPlayer().getKinTelNumber() + "', '" + MainClass.getDataManager().getJPlayer().getDoctorName() + "', '" + MainClass.getDataManager().getJPlayer().getDoctorTelNumber() + "')";
		String query2 = "INSERT INTO PlayerTable(PlayerID, PlayerType) VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = '" + MainClass.getDataManager().getJPlayer().getEmail() + "'), 'JuniorPlayer')";
		String query3 = "INSERT INTO JuniorPlayerTable(JPlayerID, KinRelationship, KinAddress, Kin2Name, Kin2Relationship, Kin2Address, Kin2TelNumber, DoctorAddress) VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = '" + MainClass.getDataManager().getJPlayer().getEmail() + "'), '" + MainClass.getDataManager().getJPlayer().getKinRelationship() + "', '" + MainClass.getDataManager().getJPlayer().getKinAddress() + "', '" + MainClass.getDataManager().getJPlayer().getKin2Name() + "', '" + MainClass.getDataManager().getJPlayer().getKin2Relationship() + "', '" + MainClass.getDataManager().getJPlayer().getKin2Address() + "', '" + MainClass.getDataManager().getJPlayer().getKin2TelNumber() + "', '" + MainClass.getDataManager().getJPlayer().getDoctorAddress() + "')";
		String query4 = "INSERT INTO SkillTable (SkillSetID, PreferredPosition, HealthComment, PassingComment, TacklingComment, KickingComment, StandardSkill, SpinSkill, PopSkill, FrontSkill, RearSkill, SideSkill, ScrabbleSkill, DropSkill, PuntSkill, GrubberSkill, GoalSkill) VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = '" + MainClass.getDataManager().getJPlayer().getEmail() + "'), 'Centre', '', '', '', '', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3')";
		
		//Send queries and if all execute successfully...
		if (MainClass.getDataManager().sendUpdate(query1) == 1 && MainClass.getDataManager().sendUpdate(query2) == 1 && MainClass.getDataManager().sendUpdate(query3) == 1 && MainClass.getDataManager().sendUpdate(query4) == 1) {
			
			//Inform the user that the profile has been created using a dialogue box.
			JOptionPane.showMessageDialog(js,"Profile created successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
			
			MainClass.setNewAccount(false); //Set newAccount to false.
			SecretaryMenuController smc = new SecretaryMenuController(); //Create and display the secretary menu.
		}
		else {
			
			//Inform the user that the profile was not created using a dialogue box.
			JOptionPane.showMessageDialog(js,"Profile creation failed.\n" + "Please ensure that the number of characters in each text field is not excessive.\n" + "Fields with an asterisk cannot be empty. SRU cannot contain more than 10 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/**
	 * Function used to edit the details of an existing Junior Player that are found on the JuniorScreen.
	 * This function can only be called by secretaries.
	 */
	public void editJuniorPlayer() {
		
		saveToObject(); //Save contents to object.
		
		//Query to update the JuniorPlayerTable with details from the JuniorScreen.
		String query1 = "UPDATE ProfileTable SET FullName = '" + MainClass.getDataManager().getJPlayer().getFullName() + "', Address = '" + MainClass.getDataManager().getJPlayer().getAddress() + "', PostCode = '" + MainClass.getDataManager().getJPlayer().getPostCode() + "', SRUNumber = '" + MainClass.getDataManager().getJPlayer().getSRUNumber() + "', DOB = '" + MainClass.getDataManager().getJPlayer().getDOB() + "', TelNumber = '" + MainClass.getDataManager().getJPlayer().getTelNumber() + "', MobNumber = '" + MainClass.getDataManager().getJPlayer().getMobNumber() + "', Email = '" + MainClass.getDataManager().getJPlayer().getEmail() + "', KinName = '" + MainClass.getDataManager().getJPlayer().getKinName() + "', KinTelNumber = '" + MainClass.getDataManager().getJPlayer().getKinTelNumber() + "', DoctorName = '" + MainClass.getDataManager().getJPlayer().getDoctorName() + "', DoctorTelNumber = '" + MainClass.getDataManager().getJPlayer().getDoctorTelNumber() + "' WHERE ProfileID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ";
		String query2 = "UPDATE JuniorPlayerTable SET KinRelationship = '" + MainClass.getDataManager().getJPlayer().getKinRelationship() + "', KinAddress = '" + MainClass.getDataManager().getJPlayer().getKinAddress() + "', Kin2Name = '" + MainClass.getDataManager().getJPlayer().getKin2Name() + "', Kin2Relationship = '" + MainClass.getDataManager().getJPlayer().getKin2Relationship()  + "', Kin2Address = '" + MainClass.getDataManager().getJPlayer().getKin2Address() + "', Kin2TelNumber = '" + MainClass.getDataManager().getJPlayer().getKin2TelNumber() + "', DoctorAddress = '" + MainClass.getDataManager().getJPlayer().getDoctorAddress() + "' WHERE JPlayerID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ";
		
		
		if (updateJuniorPlayer(query1) == 1 && updateJuniorPlayer(query2) == 1) {
			
			//Inform the user that profile details have been updated using a dialogue box.
			JOptionPane.showMessageDialog(js,"Profile details from both pages have been updated successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			
			//Inform the user that profile details were not updated using a dialogue box.
			JOptionPane.showMessageDialog(js,"Profile details were not updated.\n" + "Please ensure that the number of characters in each text field is not excessive. Email must be unique.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Function called by editJuniorPlayer to update details in the ProfileTable and JuniorPlayerTable of the database with details from the ProfileScreen and JuniorScreen.
	 * @return '1' if query was executed successfully and '0' if the query failed to execute.
	 */
	private int updateJuniorPlayer(String query) {
		
		return MainClass.getDataManager().sendUpdate(query); //Send query and return 1 if it was executed successfully.
	}
	
	/**
	 * Function used to delete an existing Junior Player.
	 * Note: Can't delete from squad, but this should hopefully not be a problem. Deleted IDs should not display names in a squad and will be deleted over time.
	 */
	@SuppressWarnings("unused")
	public void deleteJuniorPlayer() {
		
		//Queries to delete data for the currently viewed junior player from all tables of the database except for the squad table.
		String query1 = "DELETE FROM JuniorPlayerTable WHERE JPlayerID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ";
		String query2 = "DELETE FROM SkillTable WHERE SkillSetID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ";
		String query3 = "DELETE FROM PlayerTable WHERE PlayerID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ";
		String query4 = "DELETE FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ";
		
		//Send the queries to the database.
		MainClass.getDataManager().sendUpdate(query1);
		MainClass.getDataManager().sendUpdate(query2);
		MainClass.getDataManager().sendUpdate(query3);
		MainClass.getDataManager().sendUpdate(query4);
		
		//Inform the user that the profile has been deleted using a dialogue box.
		JOptionPane.showMessageDialog(js,"Profile has been deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
		
		SecretaryMenuController smc = new SecretaryMenuController();
		
	}
}
