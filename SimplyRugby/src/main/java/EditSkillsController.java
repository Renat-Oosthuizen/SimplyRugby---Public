import javax.swing.JOptionPane;

/**
 * This is the Controller class for the View class EditSkillsScreen. 
 * It executes the majority of the logic behind EditSkillsScreen.
 *@author Renat Oosthuizen
 *@since 12/05/2021
 */
public class EditSkillsController {

	/**EditSkillsScreen variable used to store an instance of the EditSkillsScreen class.*/
	private EditSkillsScreen ess;
	
	/**
	 * Default constructor for the EditSkillsController. 
	 * It will create an instance of the EditSkillsScreen, populate it with data from a junior or a senior player (from the database), and then make it visible.
	 */
	public EditSkillsController() {
		
		ess = new EditSkillsScreen(this); //ess is a new instance of class EditSkillsScreen that accepts EditSkillsController class as a parameter.
		
		if (MainClass.getTargetType().equals("jPlayer")) { //If the selected profile is a junior player...
			
			populateByJuniorPlayer(); //Populate the text fields with data from jPlayer.
		} 
		else if (MainClass.getTargetType().equals("sPlayer")) { //If the selected profile is a senior player...
			
			populateBySeniorPlayer(); //Populate the text fields with data from sPlayer.
		} 
		
		//Make LoginScreen visible.
		ess.setVisible(true);
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
	 * Function to return to the profile page and display the player details instead of the details of the loged user.
	 */
	@SuppressWarnings("unused")
	public void goBack() {
		
		ProfileController pc = new ProfileController(); //Create and display the profile page.
	}
	
	/**
	 * Function to save all data on the EditSkillScreen to the database for the currently viewed profile.
	 */
	public void saveSkills() {
		
		if (MainClass.getTargetType().equals("jPlayer")) { //If the selected profile is a junior player...
			
			saveJuniorPlayer(); //...save the skills data for the junior player.
		} 
		else if (MainClass.getTargetType().equals("sPlayer")) { //If the selected profile is a senior player...
			
			saveSeniorPlayer(); //...save the skills data for the senior player.
		} 

		
	}
	
	/**
	 * Function saves all the data on the EditSkillScreen to the database for the currently viewed junior player and informs the user of the outcome.
	 */
	private void saveJuniorPlayer() {
		
		int result = 0; //Tracks if query was successful.
		
		//Save all the data from the EditSkillScreen to the jPlayer object.
		MainClass.getDataManager().getJPlayer().setPreferredPosition(ess.getComboBoxPreferredPosition());
		MainClass.getDataManager().getJPlayer().setHealthComment(ess.getTextFieldHealthComment());
		MainClass.getDataManager().getJPlayer().setPassingComment(ess.getTextFieldPassingComment());
		MainClass.getDataManager().getJPlayer().setTacklingComment(ess.getTextFieldTacklingComment());
		MainClass.getDataManager().getJPlayer().setKickingComment(ess.getTextFieldKickingComment());
		
		MainClass.getDataManager().getJPlayer().setGoalSkill(ess.getComboBoxGoal() + 1);
		MainClass.getDataManager().getJPlayer().setStandardSkill(ess.getComboBoxStandard() + 1);
		MainClass.getDataManager().getJPlayer().setSpinSkill(ess.getComboBoxSpin() + 1);
		MainClass.getDataManager().getJPlayer().setPopSkill(ess.getComboBoxPop() + 1);
		MainClass.getDataManager().getJPlayer().setFrontSkill(ess.getComboBoxFront() + 1);
		MainClass.getDataManager().getJPlayer().setRearSkill(ess.getComboBoxRear() + 1);
		MainClass.getDataManager().getJPlayer().setSideSkill(ess.getComboBoxSide() + 1);
		MainClass.getDataManager().getJPlayer().setScrabbleSkill(ess.getComboBoxScrabble() + 1);
		MainClass.getDataManager().getJPlayer().setDropSkill(ess.getComboBoxDrop() + 1);
		MainClass.getDataManager().getJPlayer().setPuntSkill(ess.getComboBoxPunt() + 1);
		MainClass.getDataManager().getJPlayer().setGrubberSkill(ess.getComboBoxGrubber() + 1);
		
		//Send query to the database to update the junior player with data from the jPlayer object and store the result of the query.
		result = MainClass.getDataManager().sendUpdate("UPDATE SkillTable SET HealthComment = '" + MainClass.getDataManager().getJPlayer().getHealthComment() + "', PreferredPosition = '" + MainClass.getDataManager().getJPlayer().getPreferredPosition() + "', PassingComment = '" + MainClass.getDataManager().getJPlayer().getPassingComment() + "', TacklingComment = '" + MainClass.getDataManager().getJPlayer().getTacklingComment() + "', KickingComment = '" + MainClass.getDataManager().getJPlayer().getKickingComment() + "', StandardSkill = '" + MainClass.getDataManager().getJPlayer().getStandardSkill() + "', SpinSkill = '" + MainClass.getDataManager().getJPlayer().getSpinSkill() + "', PopSkill = '" + MainClass.getDataManager().getJPlayer().getPopSkill() + "', FrontSkill = '" + MainClass.getDataManager().getJPlayer().getFrontSkill() + "', RearSkill = '" + MainClass.getDataManager().getJPlayer().getRearSkill() + "', SideSkill = '" + MainClass.getDataManager().getJPlayer().getSideSkill() + "', ScrabbleSkill = '" + MainClass.getDataManager().getJPlayer().getScrabbleSkill() + "', DropSkill = '" + MainClass.getDataManager().getJPlayer().getDropSkill() + "', PuntSkill = '" + MainClass.getDataManager().getJPlayer().getPuntSkill() + "', GrubberSkill = '" + MainClass.getDataManager().getJPlayer().getGrubberSkill() + "', GoalSkill = '" + MainClass.getDataManager().getJPlayer().getGoalSkill() + "' WHERE SkillSetID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ");
		
		if (result == 1) { //If query was successful...
			
			//Inform the user that skills have been saved using a dialogue box.
			JOptionPane.showMessageDialog(ess,"Junior Player skills updated successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
		}
		else { //If query was not successful...
			
			//Inform the user that skills were not saved using a dialogue box.
			JOptionPane.showMessageDialog(ess,"Junior Player skills were not saved.\n" + "Comments cannot be longer than 255 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Function saves all the data on the EditSkillScreen to the database for the currently viewed senior player and informs the user of the outcome.
	 */
	private void saveSeniorPlayer() {
		
		int result = 0; //Tracks if query was successful. 
		
		//Save all the data from the EditSkillScreen to the sPlayer object.
		MainClass.getDataManager().getSPlayer().setPreferredPosition(ess.getComboBoxPreferredPosition());
		MainClass.getDataManager().getSPlayer().setHealthComment(ess.getTextFieldHealthComment());
		MainClass.getDataManager().getSPlayer().setPassingComment(ess.getTextFieldPassingComment());
		MainClass.getDataManager().getSPlayer().setTacklingComment(ess.getTextFieldTacklingComment());
		MainClass.getDataManager().getSPlayer().setKickingComment(ess.getTextFieldKickingComment());
		
		MainClass.getDataManager().getSPlayer().setGoalSkill(ess.getComboBoxGoal() + 1);
		MainClass.getDataManager().getSPlayer().setStandardSkill(ess.getComboBoxStandard() + 1);
		MainClass.getDataManager().getSPlayer().setSpinSkill(ess.getComboBoxSpin() + 1);
		MainClass.getDataManager().getSPlayer().setPopSkill(ess.getComboBoxPop() + 1);
		MainClass.getDataManager().getSPlayer().setFrontSkill(ess.getComboBoxFront() + 1);
		MainClass.getDataManager().getSPlayer().setRearSkill(ess.getComboBoxRear() + 1);
		MainClass.getDataManager().getSPlayer().setSideSkill(ess.getComboBoxSide() + 1);
		MainClass.getDataManager().getSPlayer().setScrabbleSkill(ess.getComboBoxScrabble() + 1);
		MainClass.getDataManager().getSPlayer().setDropSkill(ess.getComboBoxDrop() + 1);
		MainClass.getDataManager().getSPlayer().setPuntSkill(ess.getComboBoxPunt() + 1);
		MainClass.getDataManager().getSPlayer().setGrubberSkill(ess.getComboBoxGrubber() + 1);
		
		//Send query to the database to update the junior player with data from the sPlayer object and store the result of the query.
		result = MainClass.getDataManager().sendUpdate("UPDATE SkillTable SET HealthComment = '" + MainClass.getDataManager().getSPlayer().getHealthComment() + "', PreferredPosition = '" + MainClass.getDataManager().getSPlayer().getPreferredPosition() + "', PassingComment = '" + MainClass.getDataManager().getSPlayer().getPassingComment() + "', TacklingComment = '" + MainClass.getDataManager().getSPlayer().getTacklingComment() + "', KickingComment = '" + MainClass.getDataManager().getSPlayer().getKickingComment() + "', StandardSkill = '" + MainClass.getDataManager().getSPlayer().getStandardSkill() + "', SpinSkill = '" + MainClass.getDataManager().getSPlayer().getSpinSkill() + "', PopSkill = '" + MainClass.getDataManager().getSPlayer().getPopSkill() + "', FrontSkill = '" + MainClass.getDataManager().getSPlayer().getFrontSkill() + "', RearSkill = '" + MainClass.getDataManager().getSPlayer().getRearSkill() + "', SideSkill = '" + MainClass.getDataManager().getSPlayer().getSideSkill() + "', ScrabbleSkill = '" + MainClass.getDataManager().getSPlayer().getScrabbleSkill() + "', DropSkill = '" + MainClass.getDataManager().getSPlayer().getDropSkill() + "', PuntSkill = '" + MainClass.getDataManager().getSPlayer().getPuntSkill() + "', GrubberSkill = '" + MainClass.getDataManager().getSPlayer().getGrubberSkill() + "', GoalSkill = '" + MainClass.getDataManager().getSPlayer().getGoalSkill() + "' WHERE SkillSetID = '" + MainClass.getDataManager().getSPlayer().getID() + "' ");
	
		if (result == 1) { //If query was successful...
			
			//Inform the user that skills have been saved using a dialogue box.
			JOptionPane.showMessageDialog(ess,"Senior Player skills updated successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
		}
		else { //If query was not successful...
			
			//Inform the user that skills were not saved using a dialogue box.
			JOptionPane.showMessageDialog(ess,"Senior Player skills were not saved.\n" + "Comments cannot be longer than 255 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	/**
	 * Function populates the page with data from jPlayer.
	 */
	private void populateByJuniorPlayer() {
		
		//Populate the EditSkillsScreen with data from jPlayer object.
		ess.setTextFieldPlayerName(MainClass.getDataManager().getJPlayer().getFullName());
		ess.setComboBoxPreferredPosition(MainClass.getDataManager().getJPlayer().getPreferredPosition());
		ess.setTextFieldHealthComment(MainClass.getDataManager().getJPlayer().getHealthComment());
		ess.setTextFieldPassingComment(MainClass.getDataManager().getJPlayer().getPassingComment());
		ess.setTextFieldTacklingComment(MainClass.getDataManager().getJPlayer().getTacklingComment());
		ess.setTextFieldKickingComment(MainClass.getDataManager().getJPlayer().getKickingComment());
		
		ess.setComboBoxGoal(MainClass.getDataManager().getJPlayer().getGoalSkill() - 1);
		ess.setComboBoxStandard(MainClass.getDataManager().getJPlayer().getStandardSkill() - 1);
		ess.setComboBoxSpin(MainClass.getDataManager().getJPlayer().getSpinSkill() - 1);
		ess.setComboBoxPop(MainClass.getDataManager().getJPlayer().getPopSkill() - 1);
		ess.setComboBoxFront(MainClass.getDataManager().getJPlayer().getFrontSkill() - 1);
		ess.setComboBoxRear(MainClass.getDataManager().getJPlayer().getRearSkill() - 1);
		ess.setComboBoxSide(MainClass.getDataManager().getJPlayer().getSideSkill() - 1);
		ess.setComboBoxScrabble(MainClass.getDataManager().getJPlayer().getScrabbleSkill() - 1);
		ess.setComboBoxDrop(MainClass.getDataManager().getJPlayer().getDropSkill() - 1);
		ess.setComboBoxPunt(MainClass.getDataManager().getJPlayer().getPuntSkill() - 1);
		ess.setComboBoxGrubber(MainClass.getDataManager().getJPlayer().getGrubberSkill() - 1);

	}
	

	/**
	 * Function populates the page with data from sPlayer.
	 */
	private void populateBySeniorPlayer() {
		
		//Populate the EditSkillsScreen with data from sPlayer object.
		ess.setTextFieldPlayerName(MainClass.getDataManager().getSPlayer().getFullName());
		ess.setComboBoxPreferredPosition(MainClass.getDataManager().getSPlayer().getPreferredPosition());
		ess.setTextFieldHealthComment(MainClass.getDataManager().getSPlayer().getHealthComment());
		ess.setTextFieldPassingComment(MainClass.getDataManager().getSPlayer().getPassingComment());
		ess.setTextFieldTacklingComment(MainClass.getDataManager().getSPlayer().getTacklingComment());
		ess.setTextFieldKickingComment(MainClass.getDataManager().getSPlayer().getKickingComment());
		
		ess.setComboBoxGoal(MainClass.getDataManager().getSPlayer().getGoalSkill() - 1);
		ess.setComboBoxStandard(MainClass.getDataManager().getSPlayer().getStandardSkill() - 1);
		ess.setComboBoxSpin(MainClass.getDataManager().getSPlayer().getSpinSkill() - 1);
		ess.setComboBoxPop(MainClass.getDataManager().getSPlayer().getPopSkill() - 1);
		ess.setComboBoxFront(MainClass.getDataManager().getSPlayer().getFrontSkill() - 1);
		ess.setComboBoxRear(MainClass.getDataManager().getSPlayer().getRearSkill() - 1);
		ess.setComboBoxSide(MainClass.getDataManager().getSPlayer().getSideSkill() - 1);
		ess.setComboBoxScrabble(MainClass.getDataManager().getSPlayer().getScrabbleSkill() - 1);
		ess.setComboBoxDrop(MainClass.getDataManager().getSPlayer().getDropSkill() - 1);
		ess.setComboBoxPunt(MainClass.getDataManager().getSPlayer().getPuntSkill() - 1);
		ess.setComboBoxGrubber(MainClass.getDataManager().getSPlayer().getGrubberSkill() - 1);
	}
	
}
