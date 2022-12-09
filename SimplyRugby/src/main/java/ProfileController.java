import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JOptionPane;

/**
 * This is the Controller class for the View class ProfileScreen. 
 * It executes the majority of the logic behind ProfileScreen.
 *@author Renat Oosthuizen
 *@since 13/05/2021
 */
public class ProfileController {

	/**ProfileScreen variable used to store an instance of the ProfileScreen class.*/
	private ProfileScreen ps;
		
	/**
	 * Default constructor for the ProfileController. 
	 * It will create an instance of the ProfileScreen, populate it with data from the required profile (from the database), and then make it visible.
	 */
	public ProfileController() {
		
		ps = new ProfileScreen(this); //ps is a new instance of class ProfileScreen that accepts ProfileController class as a parameter.
		
		if (!MainClass.isNewAccount() && MainClass.getTargetType().equals("jPlayer")) { //Triggers when looking at an existing Junior Player account.
			
			populateByJuniorPlayer(); //Populate the text fields with data from jPlayer.
		} 
		else if (!MainClass.isNewAccount() && MainClass.getTargetType().equals("sPlayer")) { //Triggers when looking at an existing Senior Player account.
			
			populateBySeniorPlayer(); //Populate the text fields with data from sPlayer.
		} 
		else if (!MainClass.isNewAccount() && MainClass.getTargetType().equals("nPlayer")) { //Triggers when looking at an existing Non Player account.
			
			populateByNonPlayer(); //Populate the text fields with data from nPlayer.
		}
		else if (MainClass.isNewAccount() && MainClass.getTargetType().equals("jPlayer")) { //Triggers when creating a new Junior Player account.
			
			populateByJuniorPlayer(); //Populate the text fields with data from jPlayer.
		} 
		else if (MainClass.isNewAccount()) { //Triggers when creating a new account that is not a Junior Player.
			
			//Keep empty
		} 
		else if (MainClass.getTargetType().equals("user")) { //Triggers when creating new coach/secretary profile or looking at an existing coach/secretary profile.
			
			populateByUser(); //Populate the text fields with data from user.
		}
		else { //Triggers when looking at the account of the logged user.
			
			populateByLoggedUser(); //Populate the text fields with data from loggedUser.
		}
		
		
		ps.setVisible(true); //Make LoginScreen visible.
	}
	
	/*------------------------Navigation-------------------------------*/
	
	/**
	 * Function for logging out the user.
	 */
	public void logout() {
		
		MainClass.getDataManager().setLoggedUser(null); //Forget logged user.
		LoginController.reappear(); //Make the login screen visible.
	}
	
	/**
	 * Function for opening the View that displays the details of the logged user.
	 * Function can be called by coaches and secretaries.
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
	 * Function for opening a junior screen for the purposes of viewing an existing junior profile.
	 * This function can be called by coaches.
	 */
	@SuppressWarnings("unused")
	public void showJuniorDetails() {
		
		JuniorController jc = new JuniorController(); //Create and display the junior screen of a brand new or existing junior profile.
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
	 * ProfileScreen is responsible for asking the user what kind of profile they wish to create.
	 * This function can only be called by secretaries.
	 */
	@SuppressWarnings("unused")
	public void showNewAccount() {
		
		MainClass.setNewAccount(true); //Set targetType to newAccount
		ProfileController pc = new ProfileController(); //Create and display the profile screen of a brand new account.
	}
	
	/*------------------------Populating page with data-------------------------------*/
	
	/**
	 * Function populates the ProfileScreen text fields with data from the user object which contains details of a coach or a secretary.
	 */
	private void populateByUser() {
		
		ps.setTextFieldFullName(MainClass.getDataManager().getUser().getFullName());
		ps.setTextFieldAddress(MainClass.getDataManager().getUser().getAddress());
		ps.setTextFieldPostCode(MainClass.getDataManager().getUser().getPostCode());
		ps.setTextFieldEmail(MainClass.getDataManager().getUser().getEmail());
		ps.setTextFieldMobNumber(MainClass.getDataManager().getUser().getMobNumber());
		ps.setTextFieldKin(MainClass.getDataManager().getUser().getKinName());
		ps.setTextFieldSRUNumber(MainClass.getDataManager().getUser().getSRUNumber());
		ps.setTextFieldTelNumber(MainClass.getDataManager().getUser().getTelNumber());
		ps.setTextFieldKinTel(MainClass.getDataManager().getUser().getKinTelNumber());
		ps.setTextFieldDocTel(MainClass.getDataManager().getUser().getDoctorTelNumber());
		ps.setTextFieldDocName(MainClass.getDataManager().getUser().getDoctorName());
		ps.setTextFieldDOB(MainClass.getDataManager().getUser().getDOB().toString());
	}
	
	/**
	 * Function populates the ProfileScreen text fields with data from the loggedUser object which contains details of the logged user. 
	 */
	private void populateByLoggedUser() {
		
		ps.setTextFieldFullName(MainClass.getDataManager().getLoggedUser().getFullName());
		ps.setTextFieldAddress(MainClass.getDataManager().getLoggedUser().getAddress());
		ps.setTextFieldPostCode(MainClass.getDataManager().getLoggedUser().getPostCode());
		ps.setTextFieldEmail(MainClass.getDataManager().getLoggedUser().getEmail());
		ps.setTextFieldMobNumber(MainClass.getDataManager().getLoggedUser().getMobNumber());
		ps.setTextFieldKin(MainClass.getDataManager().getLoggedUser().getKinName());
		ps.setTextFieldSRUNumber(MainClass.getDataManager().getLoggedUser().getSRUNumber());
		ps.setTextFieldTelNumber(MainClass.getDataManager().getLoggedUser().getTelNumber());
		ps.setTextFieldKinTel(MainClass.getDataManager().getLoggedUser().getKinTelNumber());
		ps.setTextFieldDocTel(MainClass.getDataManager().getLoggedUser().getDoctorTelNumber());
		ps.setTextFieldDocName(MainClass.getDataManager().getLoggedUser().getDoctorName());
		ps.setTextFieldDOB(MainClass.getDataManager().getLoggedUser().getDOB().toString());
	}
	
	/**
	 * Function populates the ProfileScreen text fields with data from the jPlayer object which contains details of a junior player. 
	 */
	private void populateByJuniorPlayer() {
		
		ps.setTextFieldFullName(MainClass.getDataManager().getJPlayer().getFullName());
		ps.setTextFieldAddress(MainClass.getDataManager().getJPlayer().getAddress());
		ps.setTextFieldPostCode(MainClass.getDataManager().getJPlayer().getPostCode());
		ps.setTextFieldEmail(MainClass.getDataManager().getJPlayer().getEmail());
		ps.setTextFieldMobNumber(MainClass.getDataManager().getJPlayer().getMobNumber());
		ps.setTextFieldKin(MainClass.getDataManager().getJPlayer().getKinName());
		ps.setTextFieldSRUNumber(MainClass.getDataManager().getJPlayer().getSRUNumber());
		ps.setTextFieldTelNumber(MainClass.getDataManager().getJPlayer().getTelNumber());
		ps.setTextFieldKinTel(MainClass.getDataManager().getJPlayer().getKinTelNumber());
		ps.setTextFieldDocTel(MainClass.getDataManager().getJPlayer().getDoctorTelNumber());
		ps.setTextFieldDocName(MainClass.getDataManager().getJPlayer().getDoctorName());
		
		//This will fail when first loading the page during Junior Account creation as jPlayer DOB will hold a null value.
		try {
			ps.setTextFieldDOB(MainClass.getDataManager().getJPlayer().getDOB().toString());
		}
		catch (Exception e) {}
	}
	
	/**
	 * Function populates the ProfileScreen text fields with data from the sPlayer object which contains details of a senior player. 
	 */
	private void populateBySeniorPlayer() {
		
		ps.setTextFieldFullName(MainClass.getDataManager().getSPlayer().getFullName());
		ps.setTextFieldAddress(MainClass.getDataManager().getSPlayer().getAddress());
		ps.setTextFieldPostCode(MainClass.getDataManager().getSPlayer().getPostCode());
		ps.setTextFieldEmail(MainClass.getDataManager().getSPlayer().getEmail());
		ps.setTextFieldMobNumber(MainClass.getDataManager().getSPlayer().getMobNumber());
		ps.setTextFieldKin(MainClass.getDataManager().getSPlayer().getKinName());
		ps.setTextFieldSRUNumber(MainClass.getDataManager().getSPlayer().getSRUNumber());
		ps.setTextFieldTelNumber(MainClass.getDataManager().getSPlayer().getTelNumber());
		ps.setTextFieldKinTel(MainClass.getDataManager().getSPlayer().getKinTelNumber());
		ps.setTextFieldDocTel(MainClass.getDataManager().getSPlayer().getDoctorTelNumber());
		ps.setTextFieldDocName(MainClass.getDataManager().getSPlayer().getDoctorName());
		ps.setTextFieldDOB(MainClass.getDataManager().getSPlayer().getDOB().toString());
	}
	
	/**
	 * Function populates the ProfileScreen text fields with data from the nPlayer object which contains details of a non-player. 
	 */
	private void populateByNonPlayer() {
		
		ps.setTextFieldFullName(MainClass.getDataManager().getNPlayer().getFullName());
		ps.setTextFieldAddress(MainClass.getDataManager().getNPlayer().getAddress());
		ps.setTextFieldPostCode(MainClass.getDataManager().getNPlayer().getPostCode());
		ps.setTextFieldEmail(MainClass.getDataManager().getNPlayer().getEmail());
		ps.setTextFieldMobNumber(MainClass.getDataManager().getNPlayer().getMobNumber());
		ps.setTextFieldKin(MainClass.getDataManager().getNPlayer().getKinName());
		ps.setTextFieldSRUNumber(MainClass.getDataManager().getNPlayer().getSRUNumber());
		ps.setTextFieldTelNumber(MainClass.getDataManager().getNPlayer().getTelNumber());
		ps.setTextFieldKinTel(MainClass.getDataManager().getNPlayer().getKinTelNumber());
		ps.setTextFieldDocTel(MainClass.getDataManager().getNPlayer().getDoctorTelNumber());
		ps.setTextFieldDocName(MainClass.getDataManager().getNPlayer().getDoctorName());
		ps.setTextFieldDOB(MainClass.getDataManager().getNPlayer().getDOB().toString());
	}
	
	/*------------------------Saving changes to the logged user-------------------------------*/
	
	/**
	 * Function to save the changes made on the ProfileScreen to the loggedUser object which contains details of the logged user and then the database. 
	 */
	public void saveLoggedUser() {
		
		//Check that key fields are not empty strings
		if (!ps.getTextFieldFullName().getText().trim().equals("") && !ps.getTextFieldAddress().getText().trim().equals("") && !ps.getTextFieldPostCode().getText().trim().equals("") && !ps.getTextFieldEmail().getText().trim().equals("") && !ps.getTextFieldSRUNumber().getText().trim().equals("") && !ps.getTextFieldDOB().getText().trim().equals("")) 
		{
		
			//Write data to the loggedUser object.
			
			try 
			{
				MainClass.getDataManager().getLoggedUser().setDOB(LocalDate.parse(ps.getTextFieldDOB().getText())); //Try to update DOB of loggedUser object, display error if unsuccessful.
				
			} catch (Exception E) {
				
				//Display error message and exit out of function.
				JOptionPane.showMessageDialog(ps,"Date of Birth could not be saved!\n" + "Plase use the following format: YYYY-MM-DD", "Error!", JOptionPane.ERROR_MESSAGE);
				return; //Exit function.
			}
			
			MainClass.getDataManager().getLoggedUser().setFullName(ps.getTextFieldFullName().getText().trim()); //Replace FullName of loggedUser object.
			MainClass.getDataManager().getLoggedUser().setAddress(ps.getTextFieldAddress().getText().trim()); //Replace Address of loggedUser object.
			MainClass.getDataManager().getLoggedUser().setPostCode(ps.getTextFieldPostCode().getText().trim()); //Replace PostCode of loggedUser object.
			MainClass.getDataManager().getLoggedUser().setEmail(ps.getTextFieldEmail().getText().trim()); //Replace Email of loggedUser object.
			MainClass.getDataManager().getLoggedUser().setMobNumber(ps.getTextFieldMobNumber().getText().trim()); //Replace MobNumber of loggedUser object.
			MainClass.getDataManager().getLoggedUser().setKinName(ps.getTextFieldKin().getText().trim()); //Replace KinName of loggedUser object.
			MainClass.getDataManager().getLoggedUser().setSRUNumber(ps.getTextFieldSRUNumber().getText().trim()); //Replace SRUNumber of loggedUser object.
			MainClass.getDataManager().getLoggedUser().setTelNumber(ps.getTextFieldTelNumber().getText().trim()); //Replace TelNumber of loggedUser object.
			MainClass.getDataManager().getLoggedUser().setKinTelNumber(ps.getTextFieldKinTel().getText().trim()); //Replace KinTelNumber of loggedUser object.
			MainClass.getDataManager().getLoggedUser().setDoctorTelNumber(ps.getTextFieldDocTel().getText().trim()); //Replace DoctorTelNumber of loggedUser object.
			MainClass.getDataManager().getLoggedUser().setDoctorName(ps.getTextFieldDocName().getText().trim()); //Replace DoctorName of loggedUser object.
				
			//Send data of loggedUser to database and check for successful execution. 
			if (updateLoggedUser() == 1) {
				
				//Inform the user that their details have been updated using a dialogue box.
				JOptionPane.showMessageDialog(ps,"Your details were updated successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);

				//Update the name label in the Nav Bar.
				ps.setLblName(MainClass.getDataManager().getLoggedUser().getFullName()); 
			}
			else 
			{
				
				//Inform the user that their details were not updated using a dialogue box.
				JOptionPane.showMessageDialog(ps,"Your details were not updated.\n" + "Please ensure that the number of characters in each text field is not excessive.\n" + "Email must be unique. SRU cannot contain more than 10 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			
			//Hash and send the password to database
			if (! ps.getTextFieldPass().getText().equals("") || ! ps.getTextFieldRPass().getText().equals("")) //If one of the password fields is not empty...
			{ 
				
				if (ps.getTextFieldPass().getText().equals(ps.getTextFieldRPass().getText())) //If the password fields match...
				{ 
					
					
					String passHash = getPassHash(ps.getTextFieldPass().getText());
					
					if (MainClass.getDataManager().sendUpdate("UPDATE UserTable SET PassHash = '" + passHash + "' WHERE UserID = '" + MainClass.getDataManager().getLoggedUser().getID() + "' ") > 0) //Try to update the password hash in the database. If successful, inform user.
					{ 
						
						//Inform the user that their password details have been updated using a dialogue box.
						JOptionPane.showMessageDialog(ps,"Your password has been updated successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				else 
				{
					
					//Inform the user that their password details were not updated using a dialogue box.
					JOptionPane.showMessageDialog(ps,"Your password was not updated.\n" + "Please ensure that the contents of both password fields match.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		else
		{
			
			//Inform the user that key text fields are empty
			JOptionPane.showMessageDialog(ps,"Your data could not be updated.\n" + "Fields marked with an asterisk cannot be empty.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Function that will update the profile data for the logged user in the database with data from the loggedUser object.
	 * @return '1' if the query executes successfully and '0' if it did not.
	 */
	private int updateLoggedUser() {
		
		//Query that will be sent to the database.
		String query = "UPDATE ProfileTable SET FullName = '" + MainClass.getDataManager().getLoggedUser().getFullName() + "', Address = '" + MainClass.getDataManager().getLoggedUser().getAddress() + "', PostCode = '" + MainClass.getDataManager().getLoggedUser().getPostCode() + "', SRUNumber = '" + MainClass.getDataManager().getLoggedUser().getSRUNumber() + "', DOB = '" + MainClass.getDataManager().getLoggedUser().getDOB() + "', TelNumber = '" + MainClass.getDataManager().getLoggedUser().getTelNumber() + "', MobNumber = '" + MainClass.getDataManager().getLoggedUser().getMobNumber() + "', Email = '" + MainClass.getDataManager().getLoggedUser().getEmail() + "', KinName = '" + MainClass.getDataManager().getLoggedUser().getKinName() + "', KinTelNumber = '" + MainClass.getDataManager().getLoggedUser().getKinTelNumber() + "', DoctorName = '" + MainClass.getDataManager().getLoggedUser().getDoctorName() + "', DoctorTelNumber = '" + MainClass.getDataManager().getLoggedUser().getDoctorTelNumber() + "' WHERE ProfileID = '" + MainClass.getDataManager().getLoggedUser().getID() + "' ";
		
		return MainClass.getDataManager().sendUpdate(query); //Send the query and return the number of lines changed in the database.
	}
	
	/*------------------------Secretary functions for saving edits to other accounts-------------------------------*/
	
	/**
	 * Function to reset the password of another user.
	 */
	public void resetPassword() {
		
		//Send query to database to reset the selected user's password. 
		MainClass.getDataManager().sendUpdate("UPDATE UserTable SET PassHash = '" + getPassHash("root") + "' WHERE UserID = '" + MainClass.getDataManager().getUser().getID() + "' ");
		
		//Inform the user that profile details have been updated using a dialogue box.
		JOptionPane.showMessageDialog(ps,"Password for the user has been reset back to the default password!", "Success!", JOptionPane.INFORMATION_MESSAGE);
		
	}
		
	/**
	 * Function to edit the data of another coach or secretary.
	 * It will first update the user object with data from ProfileView and will then update the database with data from the user object.
	 */
	public void editUser() {
		
		//Check that key fields are not empty strings.
		if (!ps.getTextFieldFullName().getText().trim().equals("") && !ps.getTextFieldAddress().getText().trim().equals("") && !ps.getTextFieldPostCode().getText().trim().equals("") && !ps.getTextFieldEmail().getText().trim().equals("") && !ps.getTextFieldSRUNumber().getText().trim().equals("") && !ps.getTextFieldDOB().getText().trim().equals("")) {
		
			//Edit data of object.
			
			try 
			{
				MainClass.getDataManager().getUser().setDOB(LocalDate.parse(ps.getTextFieldDOB().getText())); //Try to update DOB of User object, display error if unsuccessful.
				
			} catch (Exception E) {
				
				//Display error message and exit out of function.
				JOptionPane.showMessageDialog(ps,"Date of Birth could not be saved!\n" + "Plase use the following format: YYYY-MM-DD", "Error!", JOptionPane.ERROR_MESSAGE);
				return; //Exit function.
			}
			
			MainClass.getDataManager().getUser().setFullName(ps.getTextFieldFullName().getText().trim()); //Replace FullName of user object.
			MainClass.getDataManager().getUser().setAddress(ps.getTextFieldAddress().getText().trim()); //Replace Address of user object.
			MainClass.getDataManager().getUser().setPostCode(ps.getTextFieldPostCode().getText().trim()); //Replace PostCode of user object.
			MainClass.getDataManager().getUser().setEmail(ps.getTextFieldEmail().getText().trim()); //Replace Email of user object.
			MainClass.getDataManager().getUser().setMobNumber(ps.getTextFieldMobNumber().getText().trim()); //Replace MobNumber of user object.
			MainClass.getDataManager().getUser().setKinName(ps.getTextFieldKin().getText().trim()); //Replace KinName of user object.
			MainClass.getDataManager().getUser().setSRUNumber(ps.getTextFieldSRUNumber().getText().trim()); //Replace SRUNumber of user object.
			MainClass.getDataManager().getUser().setTelNumber(ps.getTextFieldTelNumber().getText().trim()); //Replace TelNumber of user object.
			MainClass.getDataManager().getUser().setKinTelNumber(ps.getTextFieldKinTel().getText().trim()); //Replace KinTelNumber of user object.
			MainClass.getDataManager().getUser().setDoctorTelNumber(ps.getTextFieldDocTel().getText().trim()); //Replace DoctorTelNumber of user object.
			MainClass.getDataManager().getUser().setDoctorName(ps.getTextFieldDocName().getText().trim()); //Replace DoctorName of user object.
			

				
			//Send data of Coach/Secretary to database and check for successful execution. 
			if (updateUser() == 1) {
				
				//Inform the user that profile details have been updated using a dialogue box.
				JOptionPane.showMessageDialog(ps,"Profile details updated successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				//Inform the user that profile details were not updated using a dialogue box.
				JOptionPane.showMessageDialog(ps,"Profile details were not updated.\n" + "Please ensure that the number of characters in each text field is not excessive.\n" + "Email must be unique. SRU cannot contain more than 10 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else
		{
			
			//Inform the user that key text fields are empty.
			JOptionPane.showMessageDialog(ps,"Your data could not be updated.\n" + "Fields marked with an asterisk cannot be empty.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Function that will update the profile data for a coach/secretary in the database with data from the user object.
	 * @return '1' if the query executes successfully and '0' if it did not.
	 */
	private int updateUser() {
		
		//Query that will be sent to the database.
		String query = "UPDATE ProfileTable SET FullName = '" + MainClass.getDataManager().getUser().getFullName() + "', Address = '" + MainClass.getDataManager().getUser().getAddress() + "', PostCode = '" + MainClass.getDataManager().getUser().getPostCode() + "', SRUNumber = '" + MainClass.getDataManager().getUser().getSRUNumber() + "', DOB = '" + MainClass.getDataManager().getUser().getDOB() + "', TelNumber = '" + MainClass.getDataManager().getUser().getTelNumber() + "', MobNumber = '" + MainClass.getDataManager().getUser().getMobNumber() + "', Email = '" + MainClass.getDataManager().getUser().getEmail() + "', KinName = '" + MainClass.getDataManager().getUser().getKinName() + "', KinTelNumber = '" + MainClass.getDataManager().getUser().getKinTelNumber() + "', DoctorName = '" + MainClass.getDataManager().getUser().getDoctorName() + "', DoctorTelNumber = '" + MainClass.getDataManager().getUser().getDoctorTelNumber() + "' WHERE ProfileID = '" + MainClass.getDataManager().getUser().getID() + "' ";
		
		return MainClass.getDataManager().sendUpdate(query); //Send the query and return the number of lines changed in the database.
	}
	
	
	
	/**
	 * Function to edit the data of a senior player.
	 * It will first update the sPlayer object with data from ProfileView and will then update the database with data from the sPlayer object.
	 */
	public void editSeniorPlayer() {
		
		//Check that key fields are not empty strings.
		if (!ps.getTextFieldFullName().getText().trim().equals("") && !ps.getTextFieldAddress().getText().trim().equals("") && !ps.getTextFieldPostCode().getText().trim().equals("") && !ps.getTextFieldEmail().getText().trim().equals("") && !ps.getTextFieldSRUNumber().getText().trim().equals("") && !ps.getTextFieldDOB().getText().trim().equals("")) {
		
			//Edit data of object.
			
			try 
			{
				MainClass.getDataManager().getSPlayer().setDOB(LocalDate.parse(ps.getTextFieldDOB().getText())); //Try to update DOB of sPlayer object, display error if unsuccessful.
				
			} catch (Exception E) {
				
				//Display error message and exit out of function.
				JOptionPane.showMessageDialog(ps,"Date of Birth could not be saved!\n" + "Plase use the following format: YYYY-MM-DD", "Error!", JOptionPane.ERROR_MESSAGE);
				return; //Exit function.
			}
			
			MainClass.getDataManager().getSPlayer().setFullName(ps.getTextFieldFullName().getText().trim()); //Replace FullName of user object.
			MainClass.getDataManager().getSPlayer().setAddress(ps.getTextFieldAddress().getText().trim()); //Replace Address of user object.
			MainClass.getDataManager().getSPlayer().setPostCode(ps.getTextFieldPostCode().getText().trim()); //Replace PostCode of user object.
			MainClass.getDataManager().getSPlayer().setEmail(ps.getTextFieldEmail().getText().trim()); //Replace Email of user object.
			MainClass.getDataManager().getSPlayer().setMobNumber(ps.getTextFieldMobNumber().getText().trim()); //Replace MobNumber of user object.
			MainClass.getDataManager().getSPlayer().setKinName(ps.getTextFieldKin().getText().trim()); //Replace KinName of user object.
			MainClass.getDataManager().getSPlayer().setSRUNumber(ps.getTextFieldSRUNumber().getText().trim()); //Replace SRUNumber of user object.
			MainClass.getDataManager().getSPlayer().setTelNumber(ps.getTextFieldTelNumber().getText().trim()); //Replace TelNumber of user object.
			MainClass.getDataManager().getSPlayer().setKinTelNumber(ps.getTextFieldKinTel().getText().trim()); //Replace KinTelNumber of user object.
			MainClass.getDataManager().getSPlayer().setDoctorTelNumber(ps.getTextFieldDocTel().getText().trim()); //Replace DoctorTelNumber of user object.
			MainClass.getDataManager().getSPlayer().setDoctorName(ps.getTextFieldDocName().getText().trim()); //Replace DoctorName of user object.
			
				
			//Send data of the Senior Player to database and check for successful execution. 
			if (updateSeniorPlayer() == 1) {
				
				//Inform the user that profile details have been updated using a dialogue box.
				JOptionPane.showMessageDialog(ps,"Profile details updated successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				//Inform the user that profile details were not updated using a dialogue box.
				JOptionPane.showMessageDialog(ps,"Profile details were not updated.\n" + "Please ensure that the number of characters in each text field is not excessive.\n" + "Email must be unique. SRU cannot contain more than 10 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		
		}
		else
		{
			
			//Inform the user that key text fields are empty.
			JOptionPane.showMessageDialog(ps,"Your data could not be updated.\n" + "Fields marked with an asterisk cannot be empty.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Function that will update the profile data for the senior player in the database with data from the sPlayer object.
	 * @return '1' if the query executes successfully and '0' if it did not.
	 */
	private int updateSeniorPlayer() {
		
		//Query that will be sent to the database.
		String query = "UPDATE ProfileTable SET FullName = '" + MainClass.getDataManager().getSPlayer().getFullName() + "', Address = '" + MainClass.getDataManager().getSPlayer().getAddress() + "', PostCode = '" + MainClass.getDataManager().getSPlayer().getPostCode() + "', SRUNumber = '" + MainClass.getDataManager().getSPlayer().getSRUNumber() + "', DOB = '" + MainClass.getDataManager().getSPlayer().getDOB() + "', TelNumber = '" + MainClass.getDataManager().getSPlayer().getTelNumber() + "', MobNumber = '" + MainClass.getDataManager().getSPlayer().getMobNumber() + "', Email = '" + MainClass.getDataManager().getSPlayer().getEmail() + "', KinName = '" + MainClass.getDataManager().getSPlayer().getKinName() + "', KinTelNumber = '" + MainClass.getDataManager().getSPlayer().getKinTelNumber() + "', DoctorName = '" + MainClass.getDataManager().getSPlayer().getDoctorName() + "', DoctorTelNumber = '" + MainClass.getDataManager().getSPlayer().getDoctorTelNumber() + "' WHERE ProfileID = '" + MainClass.getDataManager().getSPlayer().getID() + "' ";
		
		return MainClass.getDataManager().sendUpdate(query); //Send the query and return the number of lines changed in the database.
	}
	
	/**
	 * Function to edit the data of a non-player.
	 * It will first update the nPlayer object with data from ProfileView and will then update the database with data from the nPlayer object.
	 */
	public void editNonPlayer() {
		
		//Check that key fields are not empty strings.
		if (!ps.getTextFieldFullName().getText().trim().equals("") && !ps.getTextFieldAddress().getText().trim().equals("") && !ps.getTextFieldPostCode().getText().trim().equals("") && !ps.getTextFieldEmail().getText().trim().equals("") && !ps.getTextFieldSRUNumber().getText().trim().equals("") && !ps.getTextFieldDOB().getText().trim().equals("")) {
		
			//Edit data of object.
			
			try 
			{
				MainClass.getDataManager().getNPlayer().setDOB(LocalDate.parse(ps.getTextFieldDOB().getText())); //Try to update DOB of nPlayer object, display error if unsuccessful.
				
			} catch (Exception E) {
				
				//Display error message and exit out of function.
				JOptionPane.showMessageDialog(ps,"Date of Birth could not be saved!\n" + "Plase use the following format: YYYY-MM-DD", "Error!", JOptionPane.ERROR_MESSAGE);
				return; //Exit function.
			}
			
			MainClass.getDataManager().getNPlayer().setFullName(ps.getTextFieldFullName().getText().trim()); //Replace FullName of user object.
			MainClass.getDataManager().getNPlayer().setAddress(ps.getTextFieldAddress().getText().trim()); //Replace Address of user object.
			MainClass.getDataManager().getNPlayer().setPostCode(ps.getTextFieldPostCode().getText().trim()); //Replace PostCode of user object.
			MainClass.getDataManager().getNPlayer().setEmail(ps.getTextFieldEmail().getText().trim()); //Replace Email of user object.
			MainClass.getDataManager().getNPlayer().setMobNumber(ps.getTextFieldMobNumber().getText().trim()); //Replace MobNumber of user object.
			MainClass.getDataManager().getNPlayer().setKinName(ps.getTextFieldKin().getText().trim()); //Replace KinName of user object.
			MainClass.getDataManager().getNPlayer().setSRUNumber(ps.getTextFieldSRUNumber().getText().trim()); //Replace SRUNumber of user object.
			MainClass.getDataManager().getNPlayer().setTelNumber(ps.getTextFieldTelNumber().getText().trim()); //Replace TelNumber of user object.
			MainClass.getDataManager().getNPlayer().setKinTelNumber(ps.getTextFieldKinTel().getText().trim()); //Replace KinTelNumber of user object.
			MainClass.getDataManager().getNPlayer().setDoctorTelNumber(ps.getTextFieldDocTel().getText().trim()); //Replace DoctorTelNumber of user object.
			MainClass.getDataManager().getNPlayer().setDoctorName(ps.getTextFieldDocName().getText().trim()); //Replace DoctorName of user object.
			

			//Send data of the Non-Player to database and check for successful execution. 
			if (updateNonPlayer() == 1) {
				
				//Inform the user that profile details have been updated using a dialogue box.
				JOptionPane.showMessageDialog(ps,"Profile details updated successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				//Inform the user that profile details were not updated using a dialogue box.
				JOptionPane.showMessageDialog(ps,"Profile details were not updated.\n" + "Please ensure that the number of characters in each text field is not excessive.\n" + "Email must be unique. SRU cannot contain more than 10 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
			}
		
		}
		else
		{
			
			//Inform the user that key text fields are empty.
			JOptionPane.showMessageDialog(ps,"Your data could not be updated.\n" + "Fields marked with an asterisk cannot be empty.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Function that will update the profile data for the non-player in the database with data from the nPlayer object.
	 * @return '1' if the query executes successfully and '0' if it did not.
	 */
	private int updateNonPlayer() {
		
		//Query that will be sent to the database.
		String query = "UPDATE ProfileTable SET FullName = '" + MainClass.getDataManager().getNPlayer().getFullName() + "', Address = '" + MainClass.getDataManager().getNPlayer().getAddress() + "', PostCode = '" + MainClass.getDataManager().getNPlayer().getPostCode() + "', SRUNumber = '" + MainClass.getDataManager().getNPlayer().getSRUNumber() + "', DOB = '" + MainClass.getDataManager().getNPlayer().getDOB() + "', TelNumber = '" + MainClass.getDataManager().getNPlayer().getTelNumber() + "', MobNumber = '" + MainClass.getDataManager().getNPlayer().getMobNumber() + "', Email = '" + MainClass.getDataManager().getNPlayer().getEmail() + "', KinName = '" + MainClass.getDataManager().getNPlayer().getKinName() + "', KinTelNumber = '" + MainClass.getDataManager().getNPlayer().getKinTelNumber() + "', DoctorName = '" + MainClass.getDataManager().getNPlayer().getDoctorName() + "', DoctorTelNumber = '" + MainClass.getDataManager().getNPlayer().getDoctorTelNumber() + "' WHERE ProfileID = '" + MainClass.getDataManager().getNPlayer().getID() + "' ";
		
		return MainClass.getDataManager().sendUpdate(query); //Send the query and return the number of lines changed in the database.
	}

	/**
	 * Function to save the data of a new junior player being created to the jPlayer object and then open the junior player page where the data can be submitted to database.
	 */
	@SuppressWarnings("unused")
	public void rememberJuniorShowMoreDetails() {
		
		//Check that key fields are not empty strings.
		if (!ps.getTextFieldFullName().getText().trim().equals("") && !ps.getTextFieldAddress().getText().trim().equals("") && !ps.getTextFieldPostCode().getText().trim().equals("") && !ps.getTextFieldEmail().getText().trim().equals("") && !ps.getTextFieldSRUNumber().getText().trim().equals("") && !ps.getTextFieldDOB().getText().trim().equals("")) {
		
			//Edit data of object
			
			try 
			{
				MainClass.getDataManager().getJPlayer().setDOB(LocalDate.parse(ps.getTextFieldDOB().getText())); //Try to update DOB of jPlayer object, display error if unsuccessful.
				
			} catch (Exception E) {
				
				//Display error message and exit out of function.
				JOptionPane.showMessageDialog(ps,"Date of Birth could not be saved!\n" + "Plase use the following format: YYYY-MM-DD", "Error!", JOptionPane.ERROR_MESSAGE);
				return; //Exit function.
			}
			
			MainClass.getDataManager().getJPlayer().setFullName(ps.getTextFieldFullName().getText().trim()); //Replace FullName of user object.
			MainClass.getDataManager().getJPlayer().setAddress(ps.getTextFieldAddress().getText().trim()); //Replace Address of user object.
			MainClass.getDataManager().getJPlayer().setPostCode(ps.getTextFieldPostCode().getText().trim()); //Replace PostCode of user object.
			MainClass.getDataManager().getJPlayer().setEmail(ps.getTextFieldEmail().getText().trim()); //Replace Email of user object.
			MainClass.getDataManager().getJPlayer().setMobNumber(ps.getTextFieldMobNumber().getText().trim()); //Replace MobNumber of user object.
			MainClass.getDataManager().getJPlayer().setKinName(ps.getTextFieldKin().getText().trim()); //Replace KinName of user object.
			MainClass.getDataManager().getJPlayer().setSRUNumber(ps.getTextFieldSRUNumber().getText().trim()); //Replace SRUNumber of user object.
			MainClass.getDataManager().getJPlayer().setTelNumber(ps.getTextFieldTelNumber().getText().trim()); //Replace TelNumber of user object.
			MainClass.getDataManager().getJPlayer().setKinTelNumber(ps.getTextFieldKinTel().getText().trim()); //Replace KinTelNumber of user object.
			MainClass.getDataManager().getJPlayer().setDoctorTelNumber(ps.getTextFieldDocTel().getText().trim()); //Replace DoctorTelNumber of user object.
			MainClass.getDataManager().getJPlayer().setDoctorName(ps.getTextFieldDocName().getText().trim()); //Replace DoctorName of user object.
			
			JOptionPane.showMessageDialog(ps,"Changes on this page have been remembered but not saved.", "Notification", JOptionPane.INFORMATION_MESSAGE); //Notify user that changes from this page will be remembered.
			JuniorController jc = new JuniorController(); //Create and display the junior player page.
			ps.dispose(); //Get rid of this screen.
				
		}
		else
		{
			
			//Inform the user that key text fields are empty
			JOptionPane.showMessageDialog(ps,"Fields marked with an asterisk cannot be empty.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/*------------------------Secretary functions for deleting other accounts-------------------------------*/
	

	/**
	 * Function used to delete an existing Junior Player and then return the secretary to the secretary menu.
	 * Note: Can't delete from squad, but this should hopefully not be a problem. Deleted IDs should not display names in a squad and will be deleted over time.
	 */
	@SuppressWarnings("unused")
	public void deleteJuniorPlayer() {
		
		//Delete account from database. 
		String query1 = "DELETE FROM JuniorPlayerTable WHERE JPlayerID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ";
		String query2 = "DELETE FROM SkillTable WHERE SkillSetID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ";
		String query3 = "DELETE FROM PlayerTable WHERE PlayerID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ";
		String query4 = "DELETE FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getJPlayer().getID() + "' ";
		
		//Send queries to the database.
		MainClass.getDataManager().sendUpdate(query1);
		MainClass.getDataManager().sendUpdate(query2);
		MainClass.getDataManager().sendUpdate(query3);
		MainClass.getDataManager().sendUpdate(query4);
		
		//Inform the user that the profile has been deleted using a dialogue box.
		JOptionPane.showMessageDialog(ps,"Profile has been deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
		
		SecretaryMenuController smc = new SecretaryMenuController(); //Create and display the secretary menu.
		
	}
	
	
	/**
	 * Function used to delete an existing Senior Player and then return the secretary to secretary menu.
	 * Note: Can't delete from squad, but this should hopefully not be a problem. Deleted IDs should not display names in a squad and will be deleted over time.
	 */
	@SuppressWarnings("unused")
	public void deleteSeniorPlayer() {
		
		//Delete account from database. 
		String query1 = "DELETE FROM SkillTable WHERE SkillSetID = '" + MainClass.getDataManager().getSPlayer().getID() + "' ";
		String query2 = "DELETE FROM PlayerTable WHERE PlayerID = '" + MainClass.getDataManager().getSPlayer().getID() + "' ";
		String query3 = "DELETE FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getSPlayer().getID() + "' ";
		
		//Send queries to the database.
		MainClass.getDataManager().sendUpdate(query1);
		MainClass.getDataManager().sendUpdate(query2);
		MainClass.getDataManager().sendUpdate(query3);
		
		//Inform the user that the profile has been deleted using a dialogue box.
		JOptionPane.showMessageDialog(ps,"Profile has been deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
		
		SecretaryMenuController smc = new SecretaryMenuController(); //Create and display the secretary menu.
		
	}
	

	/**
	 * Function used to delete an existing Non-Player and then return the secretary to secretary menu.
	 * Note: Can't delete from squad, but this should hopefully not be a problem. Deleted IDs should not display names in a squad and will be deleted over time.
	 */
	@SuppressWarnings("unused")
	public void deleteNonPlayer() {
		
		//Delete account from database. 
		String query1 = "DELETE FROM PlayerTable WHERE PlayerID = '" + MainClass.getDataManager().getNPlayer().getID() + "' ";
		String query2 = "DELETE FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getNPlayer().getID() + "' ";
		
		//Send queries to the database.
		MainClass.getDataManager().sendUpdate(query1);
		MainClass.getDataManager().sendUpdate(query2);
		
		//Inform the user that the profile has been deleted using a dialogue box.
		JOptionPane.showMessageDialog(ps,"Profile has been deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
		
		SecretaryMenuController smc = new SecretaryMenuController(); //Create and display the secretary menu.
		
	}
	
	/**
	 * Function used to delete an existing Coach or Secretary and then return the logged secretary to the secretary menu.
	 */
	@SuppressWarnings("unused")
	public void deleteUser() {
		
		//Delete account from database.
		String query1 = "DELETE FROM UserTable WHERE UserID = '" + MainClass.getDataManager().getUser().getID() + "' ";
		String query2 = "DELETE FROM ProfileTable WHERE ProfileID = '" + MainClass.getDataManager().getUser().getID() + "' ";
		
		//Send queries to the database.
		if (MainClass.getDataManager().sendUpdate(query1) == 1 && MainClass.getDataManager().sendUpdate(query2) == 1) 
		{
			
			//Inform the user that the profile has been deleted using a dialogue box.
			JOptionPane.showMessageDialog(ps,"Profile has been deleted!", "Success!", JOptionPane.INFORMATION_MESSAGE);
			
			SecretaryMenuController smc = new SecretaryMenuController(); //Create and display the secretary menu.
			ps.dispose(); //Get rid of this screen.
			
		}
		else
		{
			//Inform the user that the profile has been deleted using a dialogue box.
			JOptionPane.showMessageDialog(ps,"Coach cannot be deleted as it is currently an owner of a squad.", "Error!", JOptionPane.ERROR_MESSAGE);
		}


		
	}
	
	
	
	/*---------------------------------Secretary functions for creating new accounts-------------------------------------------------*/
	
	/**
	 * Function used by secretaries to create a new coach profile and then return to secretary menu.
	 * The function will first set the user object to be empty.
	 * It will then populate the object with data from ProfileScreen.
	 * Finally it will send the data from the user object to the database.
	 */
	@SuppressWarnings("unused")
	public void createCoach() {
		
		//Check that key fields are not empty strings.
		if (!ps.getTextFieldFullName().getText().trim().equals("") && !ps.getTextFieldAddress().getText().trim().equals("") && !ps.getTextFieldPostCode().getText().trim().equals("") && !ps.getTextFieldEmail().getText().trim().equals("") && !ps.getTextFieldSRUNumber().getText().trim().equals("") && !ps.getTextFieldDOB().getText().trim().equals("")) {
		
			//Create object.
			MainClass.getDataManager().setUser(new User());
			
			//Save data to object.
			MainClass.getDataManager().getUser().setFullName(ps.getTextFieldFullName().getText().trim()); //Replace FullName of user object.
			MainClass.getDataManager().getUser().setAddress(ps.getTextFieldAddress().getText().trim()); //Replace Address of user object.
			MainClass.getDataManager().getUser().setPostCode(ps.getTextFieldPostCode().getText().trim()); //Replace PostCode of user object.
			MainClass.getDataManager().getUser().setEmail(ps.getTextFieldEmail().getText().trim()); //Replace Email of user object.
			MainClass.getDataManager().getUser().setMobNumber(ps.getTextFieldMobNumber().getText().trim()); //Replace MobNumber of user object.
			MainClass.getDataManager().getUser().setKinName(ps.getTextFieldKin().getText().trim()); //Replace KinName of user object.
			MainClass.getDataManager().getUser().setSRUNumber(ps.getTextFieldSRUNumber().getText().trim()); //Replace SRUNumber of user object.
			MainClass.getDataManager().getUser().setTelNumber(ps.getTextFieldTelNumber().getText().trim()); //Replace TelNumber of user object.
			MainClass.getDataManager().getUser().setKinTelNumber(ps.getTextFieldKinTel().getText().trim()); //Replace KinTelNumber of user object.
			MainClass.getDataManager().getUser().setDoctorTelNumber(ps.getTextFieldDocTel().getText().trim()); //Replace DoctorTelNumber of user object.
			MainClass.getDataManager().getUser().setDoctorName(ps.getTextFieldDocName().getText().trim()); //Replace DoctorName of user object.
			
			try {
				
				MainClass.getDataManager().getUser().setDOB(LocalDate.parse(ps.getTextFieldDOB().getText())); //Try to DOB of user object, display error if unsuccessful.
				
				//Queries to update database.
				String query1 = "INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) VALUES ('" + MainClass.getDataManager().getUser().getFullName() + "', '" + MainClass.getDataManager().getUser().getAddress() + "', '" + MainClass.getDataManager().getUser().getPostCode() + "', '" + MainClass.getDataManager().getUser().getSRUNumber() + "', '" + MainClass.getDataManager().getUser().getDOB() + "', '" + MainClass.getDataManager().getUser().getTelNumber() + "', '" + MainClass.getDataManager().getUser().getMobNumber() + "', '" + MainClass.getDataManager().getUser().getEmail() + "', '" + MainClass.getDataManager().getUser().getKinName() + "', '" + MainClass.getDataManager().getUser().getKinTelNumber() + "', '" + MainClass.getDataManager().getUser().getDoctorName() + "', '" + MainClass.getDataManager().getUser().getDoctorTelNumber() + "')";
				String query2 = "INSERT INTO UserTable(UserID, PassHash, UserType) VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = '" + MainClass.getDataManager().getUser().getEmail() + "'), '" + getPassHash("root") + "', 'Coach')";
				
				//Send queries to database and check for successful execution.
				if (MainClass.getDataManager().sendUpdate(query1) == 1 && MainClass.getDataManager().sendUpdate(query2) == 1) {
					
					//Inform the user that the profile the profile has been created using a dialogue box.
					JOptionPane.showMessageDialog(ps,"Profile created successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					
					MainClass.setNewAccount(false); //Set newAccount to false.
					SecretaryMenuController smc = new SecretaryMenuController(); //Create and display the secretary menu.
					ps.dispose(); //Get rid of this screen.
				}
				else {
					
					//Inform the user that the profile was not created using a dialogue box.
					JOptionPane.showMessageDialog(ps,"Profile creation failed.\n" + "Please ensure that the number of characters in each text field is not excessive.\n" + "Email must be unique. SRU cannot contain more than 10 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (Exception E) {
				
				//Display error message.
				JOptionPane.showMessageDialog(ps,"Date of Birth could not be saved!\n" + "Plase use the following format: YYYY-MM-DD", "Error!", JOptionPane.ERROR_MESSAGE);
			}

		}
		else
		{
			
			//Inform the user that key text fields are empty.
			JOptionPane.showMessageDialog(ps,"Your data could not be updated.\n" + "Fields marked with an asterisk cannot be empty.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Function used by secretaries to create a new secretary profile and then return to secretary menu.
	 * The function will first set the user object to be empty.
	 * It will then populate the object with data from ProfileScreen.
	 * Finally it will send the data from the user object to the database.
	 */
	@SuppressWarnings("unused")
	public void createSecretary() {
		
		//Check that key fields are not empty strings.
		if (!ps.getTextFieldFullName().getText().trim().equals("") && !ps.getTextFieldAddress().getText().trim().equals("") && !ps.getTextFieldPostCode().getText().trim().equals("") && !ps.getTextFieldEmail().getText().trim().equals("") && !ps.getTextFieldSRUNumber().getText().trim().equals("") && !ps.getTextFieldDOB().getText().trim().equals("")) {
		
			//Create object.
			MainClass.getDataManager().setUser(new User());
			
			//Save data to object.
			MainClass.getDataManager().getUser().setFullName(ps.getTextFieldFullName().getText().trim()); //Replace FullName of user object.
			MainClass.getDataManager().getUser().setAddress(ps.getTextFieldAddress().getText().trim()); //Replace Address of user object.
			MainClass.getDataManager().getUser().setPostCode(ps.getTextFieldPostCode().getText().trim()); //Replace PostCode of user object.
			MainClass.getDataManager().getUser().setEmail(ps.getTextFieldEmail().getText().trim()); //Replace Email of user object.
			MainClass.getDataManager().getUser().setMobNumber(ps.getTextFieldMobNumber().getText().trim()); //Replace MobNumber of user object.
			MainClass.getDataManager().getUser().setKinName(ps.getTextFieldKin().getText().trim()); //Replace KinName of user object.
			MainClass.getDataManager().getUser().setSRUNumber(ps.getTextFieldSRUNumber().getText().trim()); //Replace SRUNumber of user object.
			MainClass.getDataManager().getUser().setTelNumber(ps.getTextFieldTelNumber().getText().trim()); //Replace TelNumber of user object.
			MainClass.getDataManager().getUser().setKinTelNumber(ps.getTextFieldKinTel().getText().trim()); //Replace KinTelNumber of user object.
			MainClass.getDataManager().getUser().setDoctorTelNumber(ps.getTextFieldDocTel().getText().trim()); //Replace DoctorTelNumber of user object.
			MainClass.getDataManager().getUser().setDoctorName(ps.getTextFieldDocName().getText().trim()); //Replace DoctorName of user object.
			
			try {
				
				MainClass.getDataManager().getUser().setDOB(LocalDate.parse(ps.getTextFieldDOB().getText())); //Try to DOB of user object, display error if unsuccessful.
				
				//Queries to update database.
				String query1 = "INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) VALUES ('" + MainClass.getDataManager().getUser().getFullName() + "', '" + MainClass.getDataManager().getUser().getAddress() + "', '" + MainClass.getDataManager().getUser().getPostCode() + "', '" + MainClass.getDataManager().getUser().getSRUNumber() + "', '" + MainClass.getDataManager().getUser().getDOB() + "', '" + MainClass.getDataManager().getUser().getTelNumber() + "', '" + MainClass.getDataManager().getUser().getMobNumber() + "', '" + MainClass.getDataManager().getUser().getEmail() + "', '" + MainClass.getDataManager().getUser().getKinName() + "', '" + MainClass.getDataManager().getUser().getKinTelNumber() + "', '" + MainClass.getDataManager().getUser().getDoctorName() + "', '" + MainClass.getDataManager().getUser().getDoctorTelNumber() + "')";
				String query2 = "INSERT INTO UserTable(UserID, PassHash, UserType) VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = '" + MainClass.getDataManager().getUser().getEmail() + "'), '" + getPassHash("root") + "', 'Secretary')";
				
				//Update database.
				if (MainClass.getDataManager().sendUpdate(query1) == 1 && MainClass.getDataManager().sendUpdate(query2) == 1) {
					
					//Inform the user that the profile the profile has been created using a dialogue box.
					JOptionPane.showMessageDialog(ps,"Profile created successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					
					MainClass.setNewAccount(false); //Set newAccount to false.
					SecretaryMenuController smc = new SecretaryMenuController(); //Create and display a secretary menu.
					ps.dispose(); //Get rid of this screen.
				}
				else {
					
					//Inform the user that the profile was not created using a dialogue box.
					JOptionPane.showMessageDialog(ps,"Profile creation failed.\n" + "Please ensure that the number of characters in each text field is not excessive.\n" + "Email must be unique. SRU cannot contain more than 10 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (Exception E) {
				
				//Display error message.
				JOptionPane.showMessageDialog(ps,"Date of Birth could not be saved!\n" + "Plase use the following format: YYYY-MM-DD", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else
		{
			
			//Inform the user that key text fields are empty.
			JOptionPane.showMessageDialog(ps,"Your data could not be updated.\n" + "Fields marked with an asterisk cannot be empty.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Function used by secretaries to create a new senior player profile and then return to secretary menu.
	 * The function will first set the user object to be empty.
	 * It will then populate the object with data from ProfileScreen.
	 * Finally it will send the data from the user object to the database.
	 */
	@SuppressWarnings("unused")
	public void createSeniorPlayer() {
		
		//Check that key fields are not empty strings.
		if (!ps.getTextFieldFullName().getText().trim().equals("") && !ps.getTextFieldAddress().getText().trim().equals("") && !ps.getTextFieldPostCode().getText().trim().equals("") && !ps.getTextFieldEmail().getText().trim().equals("") && !ps.getTextFieldSRUNumber().getText().trim().equals("") && !ps.getTextFieldDOB().getText().trim().equals("")) {
		
			//sPlayer is an empty sPlayer object.
			MainClass.getDataManager().setSPlayer(new SeniorPlayer());
		
			//Save data to object.
			MainClass.getDataManager().getSPlayer().setFullName(ps.getTextFieldFullName().getText().trim()); //Replace FullName of user object.
			MainClass.getDataManager().getSPlayer().setAddress(ps.getTextFieldAddress().getText().trim()); //Replace Address of user object.
			MainClass.getDataManager().getSPlayer().setPostCode(ps.getTextFieldPostCode().getText().trim()); //Replace PostCode of user object.
			MainClass.getDataManager().getSPlayer().setEmail(ps.getTextFieldEmail().getText().trim()); //Replace Email of user object.
			MainClass.getDataManager().getSPlayer().setMobNumber(ps.getTextFieldMobNumber().getText().trim()); //Replace MobNumber of user object.
			MainClass.getDataManager().getSPlayer().setKinName(ps.getTextFieldKin().getText().trim()); //Replace KinName of user object.
			MainClass.getDataManager().getSPlayer().setSRUNumber(ps.getTextFieldSRUNumber().getText().trim()); //Replace SRUNumber of user object.
			MainClass.getDataManager().getSPlayer().setTelNumber(ps.getTextFieldTelNumber().getText().trim()); //Replace TelNumber of user object.
			MainClass.getDataManager().getSPlayer().setKinTelNumber(ps.getTextFieldKinTel().getText().trim()); //Replace KinTelNumber of user object.
			MainClass.getDataManager().getSPlayer().setDoctorTelNumber(ps.getTextFieldDocTel().getText().trim()); //Replace DoctorTelNumber of user object.
			MainClass.getDataManager().getSPlayer().setDoctorName(ps.getTextFieldDocName().getText().trim()); //Replace DoctorName of user object.
			
			try {
				
				MainClass.getDataManager().getSPlayer().setDOB(LocalDate.parse(ps.getTextFieldDOB().getText())); //Try to DOB of user object, display error if unsuccessful.
				
				//Insert object into database. Additional queries needed to create tables that the secretary cannot edit.
				String query1 = "INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) VALUES ('" + MainClass.getDataManager().getSPlayer().getFullName() + "', '" + MainClass.getDataManager().getSPlayer().getAddress() + "', '" + MainClass.getDataManager().getSPlayer().getPostCode() + "', '" + MainClass.getDataManager().getSPlayer().getSRUNumber() + "', '" + MainClass.getDataManager().getSPlayer().getDOB() + "', '" + MainClass.getDataManager().getSPlayer().getTelNumber() + "', '" + MainClass.getDataManager().getSPlayer().getMobNumber() + "', '" + MainClass.getDataManager().getSPlayer().getEmail() + "', '" + MainClass.getDataManager().getSPlayer().getKinName() + "', '" + MainClass.getDataManager().getSPlayer().getKinTelNumber() + "', '" + MainClass.getDataManager().getSPlayer().getDoctorName() + "', '" + MainClass.getDataManager().getSPlayer().getDoctorTelNumber() + "')";
				String query2 = "INSERT INTO PlayerTable(PlayerID, PlayerType) VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = '" + MainClass.getDataManager().getSPlayer().getEmail() + "'), 'SeniorPlayer')";
				String query3 = "INSERT INTO SkillTable (SkillSetID, PreferredPosition, HealthComment, PassingComment, TacklingComment, KickingComment, StandardSkill, SpinSkill, PopSkill, FrontSkill, RearSkill, SideSkill, ScrabbleSkill, DropSkill, PuntSkill, GrubberSkill, GoalSkill) VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = '" + MainClass.getDataManager().getSPlayer().getEmail() + "'), 'Centre', '', '', '', '', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3')";
				
				//Send queries to the database and check for successful execution.
				if (MainClass.getDataManager().sendUpdate(query1) == 1 && MainClass.getDataManager().sendUpdate(query2) == 1 && MainClass.getDataManager().sendUpdate(query3) == 1) {
					
					//Inform the user that the profile the profile has been created using a dialogue box.
					JOptionPane.showMessageDialog(ps,"Profile created successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					
					MainClass.setNewAccount(false); //Set newAccount to false.
					SecretaryMenuController smc = new SecretaryMenuController(); //Create and display a new secretary menu.
					ps.dispose(); //Get rid of this screen.
				}
				else {
					
					//Inform the user that the profile was not created using a dialogue box.
					JOptionPane.showMessageDialog(ps,"Profile creation failed.\n" + "Please ensure that the number of characters in each text field is not excessive.\n" + "Email must be unique. SRU cannot contain more than 10 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (Exception E) {
				
				//Display error message.
				JOptionPane.showMessageDialog(ps,"Date of Birth could not be saved!\n" + "Plase use the following format: YYYY-MM-DD", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else
		{
			
			//Inform the user that key text fields are empty.
			JOptionPane.showMessageDialog(ps,"Your data could not be updated.\n" + "Fields marked with an asterisk cannot be empty.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Function used by secretaries to create a new non-player profile and then return to secretary menu.
	 * The function will first set the user object to be empty.
	 * It will then populate the object with data from ProfileScreen.
	 * Finally it will send the data from the user object to the database.
	 */
	@SuppressWarnings("unused")
	public void createNonPlayer() {
		
		//Check that key fields are not empty strings.
		if (!ps.getTextFieldFullName().getText().trim().equals("") && !ps.getTextFieldAddress().getText().trim().equals("") && !ps.getTextFieldPostCode().getText().trim().equals("") && !ps.getTextFieldEmail().getText().trim().equals("") && !ps.getTextFieldSRUNumber().getText().trim().equals("") && !ps.getTextFieldDOB().getText().trim().equals("")) {
		
			////nPlayer is an empty nPlayer object.
			MainClass.getDataManager().setNPlayer(new NonPlayer());
			
			//Save data to object.
			MainClass.getDataManager().getNPlayer().setFullName(ps.getTextFieldFullName().getText().trim()); //Replace FullName of user object.
			MainClass.getDataManager().getNPlayer().setAddress(ps.getTextFieldAddress().getText().trim()); //Replace Address of user object.
			MainClass.getDataManager().getNPlayer().setPostCode(ps.getTextFieldPostCode().getText().trim()); //Replace PostCode of user object.
			MainClass.getDataManager().getNPlayer().setEmail(ps.getTextFieldEmail().getText().trim()); //Replace Email of user object.
			MainClass.getDataManager().getNPlayer().setMobNumber(ps.getTextFieldMobNumber().getText().trim()); //Replace MobNumber of user object.
			MainClass.getDataManager().getNPlayer().setKinName(ps.getTextFieldKin().getText().trim()); //Replace KinName of user object.
			MainClass.getDataManager().getNPlayer().setSRUNumber(ps.getTextFieldSRUNumber().getText().trim()); //Replace SRUNumber of user object.
			MainClass.getDataManager().getNPlayer().setTelNumber(ps.getTextFieldTelNumber().getText().trim()); //Replace TelNumber of user object.
			MainClass.getDataManager().getNPlayer().setKinTelNumber(ps.getTextFieldKinTel().getText().trim()); //Replace KinTelNumber of user object.
			MainClass.getDataManager().getNPlayer().setDoctorTelNumber(ps.getTextFieldDocTel().getText().trim()); //Replace DoctorTelNumber of user object.
			MainClass.getDataManager().getNPlayer().setDoctorName(ps.getTextFieldDocName().getText().trim()); //Replace DoctorName of user object.
			
			try {
				
				MainClass.getDataManager().getNPlayer().setDOB(LocalDate.parse(ps.getTextFieldDOB().getText())); //Try to DOB of user object, display error if unsuccessful.
				
				//Insert object into database. Additional queries needed to create tables that the secretary cannot edit.
				String query1 = "INSERT INTO ProfileTable(FullName, Address, PostCode, SRUNumber, DOB, TelNumber, MobNumber, Email, KinName, KinTelNumber, DoctorName, DoctorTelNumber) VALUES ('" + MainClass.getDataManager().getNPlayer().getFullName() + "', '" + MainClass.getDataManager().getNPlayer().getAddress() + "', '" + MainClass.getDataManager().getNPlayer().getPostCode() + "', '" + MainClass.getDataManager().getNPlayer().getSRUNumber() + "', '" + MainClass.getDataManager().getNPlayer().getDOB() + "', '" + MainClass.getDataManager().getNPlayer().getTelNumber() + "', '" + MainClass.getDataManager().getNPlayer().getMobNumber() + "', '" + MainClass.getDataManager().getNPlayer().getEmail() + "', '" + MainClass.getDataManager().getNPlayer().getKinName() + "', '" + MainClass.getDataManager().getNPlayer().getKinTelNumber() + "', '" + MainClass.getDataManager().getNPlayer().getDoctorName() + "', '" + MainClass.getDataManager().getNPlayer().getDoctorTelNumber() + "')";
				String query2 = "INSERT INTO PlayerTable(PlayerID, PlayerType) VALUES ((SELECT ProfileID FROM ProfileTable WHERE Email = '" + MainClass.getDataManager().getNPlayer().getEmail() + "'), 'NonPlayer')";
	
				//Send queries to database and check for successful execution.
				if (MainClass.getDataManager().sendUpdate(query1) == 1 && MainClass.getDataManager().sendUpdate(query2) == 1) {
					
					//Inform the user that the profile the profile has been created using a dialogue box.
					JOptionPane.showMessageDialog(ps,"Profile created successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					
					MainClass.setNewAccount(false); //Set newAccount to false
					SecretaryMenuController smc = new SecretaryMenuController(); //Create and display a new secretary menu.
					ps.dispose(); //Get rid of this screen.
				}
				else {
					
					//Inform the user that the profile was not created using a dialogue box.
					JOptionPane.showMessageDialog(ps,"Profile creation failed.\n" + "Please ensure that the number of characters in each text field is not excessive.\n" + "Email must be unique. SRU cannot contain more than 10 characters.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (Exception E) {
				
				//Display error message.
				JOptionPane.showMessageDialog(ps,"Date of Birth could not be saved!\n" + "Plase use the following format: YYYY-MM-DD", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else
		{
			
			//Inform the user that key text fields are empty.
			JOptionPane.showMessageDialog(ps,"Your data could not be updated.\n" + "Fields marked with an asterisk cannot be empty.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/*--------------------------Functions used for creating a hashed password---------------------------------*/
	
	

	/**
	 * Returns a hashed and salted password using a PBKDF2WithHmacSHA1 algorithm. BCrypt is stronger but is not built into Java. Note: original password is destroyed.
	 * @param password is the password submitted by the user.
	 * @return password hash in the format iterations:salt:hash
	 */
	private static String getPassHash(String password) {
		
		int iterations = 1000; //Number of times that the password is hashed. Means that hashing takes more time. Should be increased as processors improve.
        char[] passChar = password.toCharArray(); //Convert the password String into a character array.
        byte[] salt = getSalt(); //Create a salt byte array.
        
		PBEKeySpec spec = new PBEKeySpec(passChar, salt, iterations, 64 * 8); //Create a new PBEKeySpec specification from the inputed data.
	    Arrays.fill(passChar, Character.MIN_VALUE); //Assign a character value to each elements of the passChar character array.
	    
	    try 
	    {
	      SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); //Create an instance of the SecretKeyFactory using the "PBKDF2WithHmacSHA1" algorithm.
	      byte[] hash = skf.generateSecret(spec).getEncoded(); //Generate a byte array hash based on the provided specification.
	      return iterations + ":" + toHex(salt) + ":" + toHex(hash);
	    } 
	    catch (NoSuchAlgorithmException | InvalidKeySpecException e) 
	    {
	    	throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
	    } 
	    finally 
	    {
	    	spec.clearPassword(); //Destroy the entered password.
	    }
	}
     

	/**
	 * Generates a salt with a 16 byte seed
	 * @return the salt as a byte array.
	 */
    private static byte[] getSalt()
    {
    	SecureRandom sr = null; //Variable stores the SecureRandom instance.
    	
    	//Create an instance of SecureRandom class with the SHA1PRNG algorithm.
		try 
		{
			sr = SecureRandom.getInstance("SHA1PRNG");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			System.out.println("Cannot generate salt!");
			e.printStackTrace();
		} 

    	
        byte[] salt = new byte[16]; //Create a byte array of length 16.
        sr.nextBytes(salt); //Populate each byte in the array with data using the "SHA1PRNG" algorithm.
        return salt; //Return the byte array.
    }
    

    /**
     * Converts a byte array to a hexadecimal string.
     * @param array which is an array of bytes.
     * @return a hexadecimal String.
     */
    private static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        
        if (paddingLength > 0) //Pad the 
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }
        else
        {
            return hex; //Return the hexadecimal string.
        }
    }
		
}
