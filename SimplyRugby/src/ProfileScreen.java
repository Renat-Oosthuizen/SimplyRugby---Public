import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.Insets;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

/**
 * This class is responsible for the graphical interface of the profile screen.
 * It contains a number of text fields.
 * Coaches can use it to edit their own details and password or view the details of other players.
 * Secretaries can use it to create new profiles, delete profiles, reset passwords of other coaches and secretaries or edit the information of any profiles (including their own).
 * This class inherits from JFrame.
 *@author Renat Oosthuizen
 *@since 13/05/2021
 */
@SuppressWarnings("serial")
public class ProfileScreen extends JFrame {

	/**ProfileController variable that performs all the logic for this screen.*/
	private ProfileController myController;

	/**JTextField holds the full name of the profile.*/
	private JTextField textFieldFullName;
	/**JTextField holds the home address of the profile.*/
	private JTextField textFieldAddress;
	/**JTextField holds the post code of the profile.*/
	private JTextField textFieldPostCode;
	/**JTextField holds the email address of the profile.*/
	private JTextField textFieldEmail;
	/**JTextField holds the mobile number of the profile.*/
	private JTextField textFieldMobNumber;
	/**JTextField holds the name of the first kin of the profile.*/
	private JTextField textFieldKin;
	/**JTextField holds the Scottish Rugby Union number of the profile.*/
	private JTextField textFieldSRUNumber;
	/**JTextField holds the home telephone of the profile.*/
	private JTextField textFieldTelNumber;
	/**JTextField holds the password of the profile.*/
	private JPasswordField textFieldPass;
	/**JTextField holds the telephone number of the first kin of the profile.*/
	private JTextField textFieldKinTel;
	/**JTextField holds the telephone number of the profile's doctor.*/
	private JTextField textFieldDocTel;
	/**JTextField holds the repeated password of the profile.*/
	private JPasswordField textFieldRPass;
	/**JTextField holds the name of the doctor of the profile.*/
	private JTextField textFieldDocName;
	/**JTextField holds the date of birth of the profile.*/
	private JTextField textFieldDOB;
	
	/**JLabel holds the name of the logged user.*/
	private JLabel lblName;


	/**
	 * Parameterised constructor for the class. It accepts it's own controller class in order to create data binding between the two classes.
	 * @param control is the controller for this View Screen.
	 */
	public ProfileScreen(ProfileController control) {
		
		myController = control; //Assign myController as an instance of ProfileController.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The application will quit when the JFrame is closed.
		setBounds(0, 0, 1920, 1080); //JFrame is created at coordinates 0, 0 of screen with 1920x1080 pixel dimensions.
		JPanel contentPane = new JPanel(); //Assign contentPane to be a new instance of JPanel. This is the main panel of the JFrame.
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //Create a 5 pixel border around all sides of the contentPane.
		setContentPane(contentPane); //Insert contentPane into the JFrame.
		contentPane.setLayout(new BorderLayout(0, 0)); //Give contentPane a Border Layout.
		
/*-------------------------Top Bar------------------*/
		
		JPanel panelNorth = new JPanel(); //Assign panelNorth to be a new JPanel. 
		panelNorth.setPreferredSize(new Dimension(100,100)); //Setting dimensions of panelNorth. Width and height in pixels. Width gets ignored as it has a North, BorderLayout.
		panelNorth.setBackground(SystemColor.textHighlight); //Background colour is #0078d7.
		contentPane.add(panelNorth, BorderLayout.NORTH); //Insert panelNorth into the top of the contentPane.
		panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.X_AXIS)); //Give panelNorth a Box Layout, laid out along the x-axis.

		panelNorth.add(Box.createHorizontalStrut(10)); //This is static space that cannot change.
		
		//Logo
		JLabel lblLogo = new JLabel(); //Assign lblLogo as a new JLabel.
		panelNorth.add(lblLogo); //Add lblLogo to panelNorth.
		lblLogo.setIcon(new ImageIcon(ProfileScreen.class.getResource("/images/Blue Logo Small.png"))); //Insert an image into lblLogo.
	
		panelNorth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
		//User Name
		lblName = new JLabel(MainClass.getDataManager().getLoggedUser().getFullName()); //Assign lblName as a new JLabel that displays the name of the user.
		panelNorth.add(lblName); //Add lblName to panelNorth
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of lblName.

		panelNorth.add(Box.createHorizontalStrut(40)); //This is static space that cannot change.
	
		//User ID
		JLabel lblID = new JLabel("ID:  " + String.valueOf(MainClass.getDataManager().getLoggedUser().getID())); //Assign lblID as a new JLabel that displays the ID of the user.
		panelNorth.add(lblID); //Add lblID to panelNorth.
		lblID.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of lblID.
		
		panelNorth.add(Box.createHorizontalStrut(40)); //This is static space that cannot change.
		
		//Logout button
		JButton btnLogout = new JButton("Logout"); //Assign btnLogout as a new logout button that logs the user out and takes them to the login screen.
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		panelNorth.add(btnLogout); //Add the button to panelNorth.
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of the button.
		btnLogout.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		btnLogout.setBackground(Color.RED); //Set button's colour to red.
		btnLogout.setAlignmentX(Component.RIGHT_ALIGNMENT); //Make the button drift towards the right.
		btnLogout.addActionListener(new ActionListener() { //Give the button an action listener.
			public void actionPerformed(ActionEvent e) {
				
				myController.logout(); //Run the logout function from the controller.
				dispose(); //Get rid of this screen.
			}
		});
		
		panelNorth.add(Box.createHorizontalStrut(20)); //This is static space that cannot change.
		/*-------------------------Left Navigation Bar------------------*/
		
		JPanel panelWest = new JPanel(); //Assign panelWest as a new JPanel.
		panelWest.setPreferredSize(new Dimension(162,100)); //Setting dimensions (width and height in pixels) of panelWest. Height gets ignored as it has a West, BorderLayout.
		panelWest.setBackground(Color.BLACK); //Give the panel a black background colour.
		contentPane.add(panelWest, BorderLayout.WEST); //Insert the panel into the left side of contentPane.
		panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS)); //Give the panel a Box Layout, laid out along the y-axis.
		
		if  (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach")) { //If logged user is a coach, display these navigation buttons.
			
			panelWest.add(Box.createVerticalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnMyDetails = new JButton("My Details"); //Assign btnMyDetails as a new JButton that displays "My Details" text.
			btnMyDetails.setBackground(new Color(152, 251, 152));  //Change background colour to light green.
			btnMyDetails.setMaximumSize(new Dimension(180, 23)); //Button dimension (width and height in pixels). Note, height has no effect due to being West in the BorderLayout.
			btnMyDetails.setPreferredSize(new Dimension(90, 100)); //Button dimension (width and height in pixels). Note, width has no effect due to being West in the BorderLayout.
			btnMyDetails.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of button.
			btnMyDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			btnMyDetails.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelWest.add(btnMyDetails); //Add the button to panelWest.
			btnMyDetails.addActionListener(new ActionListener() { //Give the button an action listener.
				public void actionPerformed(ActionEvent e) {
					
					myController.showMyDetails(); //Call the showMyDetails function from the controller that displays details of the logged user.
					dispose(); //Get rid of this screen.
				}
			});
			
			panelWest.add(Box.createVerticalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnViewPlayers = new JButton("View Players");  //Assign btnViewPlayers as a new JButton that displays "View Players" text.
			btnViewPlayers.setBackground(new Color(152, 251, 152)); //Change background colour to light green.
			btnViewPlayers.setPreferredSize(new Dimension(93, 100)); //Button dimension (width and height in pixels). Note, height has no effect due to being West in the BorderLayout.
			btnViewPlayers.setMaximumSize(new Dimension(180, 23));  //Button dimension (width and height in pixels). Note, width has no effect due to being West in the BorderLayout.
			btnViewPlayers.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of button.
			btnViewPlayers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			btnViewPlayers.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelWest.add(btnViewPlayers); //Add the button to panelWest.
			btnViewPlayers.addActionListener(new ActionListener() { //Give the button an action listener.
				public void actionPerformed(ActionEvent e) {
					
					myController.showViewPlayers(); //Call the showViewPlayers function from the controller which lists all players.
					dispose(); //Get rid of this screen.
				}
			});
			
			panelWest.add(Box.createVerticalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnViewSquads = new JButton("View Squads"); //Assign btnViewquads as a new JButton that displays "View Squads" text.
			btnViewSquads.setBackground(new Color(152, 251, 152)); //Change background colour to light green.
			btnViewSquads.setPreferredSize(new Dimension(93, 100)); //Button dimension (width and height in pixels). Note, height has no effect due to being West in the BorderLayout.
			btnViewSquads.setMaximumSize(new Dimension(180, 23)); //Button dimension (width and height in pixels). Note, width has no effect due to being West in the BorderLayout.
			btnViewSquads.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of button.
			btnViewSquads.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			btnViewSquads.setFocusable(false);//Get rid of weird square around text of the button when hovered over.
			panelWest.add(btnViewSquads); //Add the button to panelWest.
			btnViewSquads.addActionListener(new ActionListener() { //Give the button an action listener.
				public void actionPerformed(ActionEvent e) {
					
					myController.showViewSquads(); //Call the showViewSquads function from the controller which will display all the squads that the logged coach is a member of.
					dispose(); //Get rid of this screen.
				}
			});
			
			panelWest.add(Box.createVerticalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
		}
		
	if  (MainClass.getDataManager().getLoggedUser().getUserType().equals("Secretary")) { //If logged user is a secretary, display these navigation buttons.
		
		panelWest.add(Box.createVerticalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
		JButton btnMyDetails = new JButton("My Details"); //Assign btnMyDetails as a new JButton that displays "My Details" text.
		btnMyDetails.setBackground(new Color(152, 251, 152));  //Change background colour to light green.
		btnMyDetails.setMaximumSize(new Dimension(180, 23)); //Button dimension (width and height in pixels). Note, height has no effect due to being West in the BorderLayout.
		btnMyDetails.setPreferredSize(new Dimension(90, 100)); //Button dimension (width and height in pixels). Note, width has no effect due to being West in the BorderLayout.
		btnMyDetails.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of button.
		btnMyDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		btnMyDetails.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		panelWest.add(btnMyDetails); //Add the button to panelWest.
		btnMyDetails.addActionListener(new ActionListener() { //Give the button an action listener.
			public void actionPerformed(ActionEvent e) {
				
				myController.showMyDetails(); //Call the showMyDetails function from the controller that displays details of the logged user.
				dispose(); //Get rid of this screen.
			}
		});
		
		panelWest.add(Box.createVerticalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
		JButton btnViewAccounts = new JButton("View Accounts"); //Assign btnViewAccounts as a new JButton that displays "View Accounts" text.
		btnViewAccounts.setBackground(new Color(152, 251, 152)); //Change background colour to light green.
		btnViewAccounts.setPreferredSize(new Dimension(93, 100)); //Button dimension (width and height in pixels). Note, height has no effect due to being West in the BorderLayout.
		btnViewAccounts.setMaximumSize(new Dimension(180, 23));  //Button dimension (width and height in pixels). Note, width has no effect due to being West in the BorderLayout.
		btnViewAccounts.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of button.
		btnViewAccounts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		btnViewAccounts.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		panelWest.add(btnViewAccounts); //Add the button to panelWest.
		btnViewAccounts.addActionListener(new ActionListener() { //Give the button an action listener.
			public void actionPerformed(ActionEvent e) {
				
				myController.showViewAccounts(); //Call the showViewAccounts function from the controller which lists all profiles.
				dispose(); //Get rid of this screen
			}
		});
		
		panelWest.add(Box.createVerticalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
		JButton btnNewAccounts = new JButton("Create New Account"); //Assign btnNewAccounts as a new JButton that displays "Create New Account" text.
		btnNewAccounts.setBackground(new Color(152, 251, 152));  //Change background colour to light green.
		btnNewAccounts.setPreferredSize(new Dimension(93, 100));  //Button dimension (width and height in pixels). Note, height has no effect due to being West in the BorderLayout.
		btnNewAccounts.setMaximumSize(new Dimension(180, 23));  //Button dimension (width and height in pixels). Note, width has no effect due to being West in the BorderLayout.
		btnNewAccounts.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of button.
		btnNewAccounts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		btnNewAccounts.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		panelWest.add(btnNewAccounts); //Add the button to panelWest.
		btnNewAccounts.addActionListener(new ActionListener() { //Give the button an action listener.
			
			public void actionPerformed(ActionEvent e) {
				
				//Dialog box asking for the type of account to be created.
				Object[] possibilities = {"Coach", "Secretary", "Junior Player", "Senior Player", "Non Player"}; //Array of options.
				String s = (String)JOptionPane.showInputDialog(contentPane, //Appears on top of contentPane.
				                    "What kind of account would you like to create?\n", //Text content of the option pane.
				                    "Create New Account", //Name of the option pane.
				                    JOptionPane.PLAIN_MESSAGE, //Type of option pane.
				                    null, //Option pane has no icon.
				                    possibilities, //Give the option pane the array of options for the user to select.
				                    "Coach"); //The selected content of the option pane on load.

				
				if ((s != null) && s.equals("Coach")) { //If "Coach" was returned...
					
				    MainClass.setTargetType("Coach"); //Set target to Coach.
					myController.showNewAccount(); //Call the showNewAccount function from the controller which will allow the creation of a new profile.
					dispose(); //Get rid of this screen.
				}
				else if ((s != null) && s.equals("Secretary")) { //If "Secretary" was returned...
					
					MainClass.setTargetType("Secretary"); //Set target to Secretary.
					myController.showNewAccount(); //Call the showNewAccount function from the controller which will allow the creation of a new profile.
					dispose(); //Get rid of this screen.
				}
				else if ((s != null) && s.equals("Junior Player")) { //If "Junior Player" was returned...
					
					//Create object
					MainClass.getDataManager().setJPlayer(new JuniorPlayer());
					
					MainClass.setTargetType("jPlayer"); //Set target to jPlayer.
					myController.showNewAccount(); //Call the showNewAccount function from the controller which will allow the creation of a new profile.
					dispose(); //Get rid of this screen.
				}
				else if ((s != null) && s.equals("Senior Player")) { //If "Senior Player" was returned...
					
					MainClass.setTargetType("sPlayer"); //Set target to sPlayer.
					myController.showNewAccount(); //Call the showNewAccount function from the controller which will allow the creation of a new profile.
					dispose(); //Get rid of this screen.
				}
				else if ((s != null) && s.equals("Non Player")) { //If "Non Player" was returned...
					
					MainClass.setTargetType("nPlayer"); //Set target to nPlayer.
					myController.showNewAccount(); //Call the showNewAccount function from the controller which will allow the creation of a new profile.
					dispose(); //Get rid of this screen.
				}

			}
			
		});
		
		panelWest.add(Box.createVerticalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
	}
	
		/*-------------------------Central Form------------------*/
		
		JPanel panelCenter = new JPanel(); //Assign panelCenter as a new JPanel.
		panelCenter.setBackground(Color.LIGHT_GRAY); //Give it a light grey background.
		contentPane.add(panelCenter, BorderLayout.CENTER); //Place it in the centre of contentPane.
		GridBagLayout gbl_panelCenter = new GridBagLayout(); //Assign gbl_panelCenter as a new GridBagLayout.
		gbl_panelCenter.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0}; //Give the layout column weights.
		panelCenter.setLayout(gbl_panelCenter); //Add the layout to panelCentre.
		
		/*Row 1*/
		JLabel lblFullName = new JLabel("Full Name*:"); //Create a new JLabel and give it text to display.
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblFullName = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblFullName.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblFullName.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblFullName.gridx = 0; //X coordinate of the JLabel.
		gbc_lblFullName.gridy = 0; //Y coordinate of the JLabel.
		panelCenter.add(lblFullName, gbc_lblFullName); //Add the label and it's constraints to panelCenter.
		
		textFieldFullName = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldFullName = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldFullName.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldFullName.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldFullName.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldFullName.gridy = 0; //Y coordinate of the JTextField.
		panelCenter.add(getTextFieldFullName(), gbc_textFieldFullName); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldFullName.setEditable(false);
		}

		
		JLabel lblMobNumber = new JLabel("Mobile Number:"); //Create a new JLabel and give it text to display.
		lblMobNumber.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblMobNumber = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblMobNumber.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblMobNumber.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblMobNumber.gridx = 2; //X coordinate of the JLabel.
		gbc_lblMobNumber.gridy = 0; //Y coordinate of the JLabel.
		panelCenter.add(lblMobNumber, gbc_lblMobNumber); //Add the label and it's constraints to panelCenter.
		
		textFieldMobNumber = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldMobNumber = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldMobNumber.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldMobNumber.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldMobNumber.gridx = 3; //X coordinate of the JTextField.
		gbc_textFieldMobNumber.gridy = 0; //Y coordinate of the JTextField.
		panelCenter.add(textFieldMobNumber, gbc_textFieldMobNumber); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldMobNumber.setEditable(false);
		}

		
		/*Row 2*/
		JLabel lblAddress = new JLabel("Address*:"); //Create a new JLabel and give it text to display.
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblAddress = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblAddress.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblAddress.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblAddress.gridx = 0; //X coordinate of the JLabel.
		gbc_lblAddress.gridy = 1; //Y coordinate of the JLabel.
		panelCenter.add(lblAddress, gbc_lblAddress); //Add the label and it's constraints to panelCenter.
		
		textFieldAddress = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldAddress = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldAddress.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldAddress.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldAddress.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldAddress.gridy = 1; //Y coordinate of the JTextField.
		panelCenter.add(textFieldAddress, gbc_textFieldAddress); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldAddress.setEditable(false);
		}
		
		JLabel lblEmail = new JLabel("Email*:"); //Create a new JLabel and give it text to display.
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblEmail = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblEmail.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblEmail.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblEmail.gridx = 2; //X coordinate of the JLabel.
		gbc_lblEmail.gridy = 1; //Y coordinate of the JLabel.
		panelCenter.add(lblEmail, gbc_lblEmail); //Add the label and it's constraints to panelCenter.
		
		textFieldEmail = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldEmail.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldEmail.gridx = 3; //X coordinate of the JTextField.
		gbc_textFieldEmail.gridy = 1; //Y coordinate of the JTextField.
		panelCenter.add(textFieldEmail, gbc_textFieldEmail); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldEmail.setEditable(false);
		}

		
		/*Row 3*/
		JLabel lblPostCode = new JLabel("Post Code*:"); //Create a new JLabel and give it text to display.
		lblPostCode.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblPostCode = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblPostCode.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblPostCode.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblPostCode.gridx = 0; //X coordinate of the JLabel.
		gbc_lblPostCode.gridy = 2; //Y coordinate of the JLabel.
		panelCenter.add(lblPostCode, gbc_lblPostCode); //Add the label and it's constraints to panelCenter.
		
		textFieldPostCode = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldPostCode = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldPostCode.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldPostCode.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldPostCode.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldPostCode.gridy = 2; //Y coordinate of the JTextField.
		panelCenter.add(textFieldPostCode, gbc_textFieldPostCode); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldPostCode.setEditable(false);
		}

		
		JLabel lblKin = new JLabel("Next of Kin:"); //Create a new JLabel and give it text to display.
		if (MainClass.getTargetType().equals("jPlayer")) { lblKin.setText("Guardian 1 Name:"); } //If looking at a junior player profile then change the contents of the label.
		lblKin.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblKin = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblKin.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblKin.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblKin.gridx = 2; //X coordinate of the JLabel.
		gbc_lblKin.gridy = 2; //Y coordinate of the JLabel.
		panelCenter.add(lblKin, gbc_lblKin); //Add the label and it's constraints to panelCenter.
		
		textFieldKin = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldKin = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldKin.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldKin.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldKin.gridx = 3; //X coordinate of the JTextField.
		gbc_textFieldKin.gridy = 2; //Y coordinate of the JTextField.
		panelCenter.add(textFieldKin, gbc_textFieldKin); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldKin.setEditable(false);
		}

		/*Row 4*/
		JLabel lblSRUNumber = new JLabel("SRU Number*:"); //Create a new JLabel and give it text to display.
		lblSRUNumber.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblSRUNumber = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblSRUNumber.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblSRUNumber.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblSRUNumber.gridx = 0; //X coordinate of the JLabel.
		gbc_lblSRUNumber.gridy = 3; //Y coordinate of the JLabel.
		panelCenter.add(lblSRUNumber, gbc_lblSRUNumber); //Add the label and it's constraints to panelCenter.
		
		textFieldSRUNumber = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldSRUNumber = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldSRUNumber.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldSRUNumber.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldSRUNumber.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldSRUNumber.gridy = 3; //Y coordinate of the JTextField.
		panelCenter.add(textFieldSRUNumber, gbc_textFieldSRUNumber); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldSRUNumber.setEditable(false);
		}

		
		JLabel lblKinTel = new JLabel("Kin Telephone Number:"); //Create a new JLabel and give it text to display.
		if (MainClass.getTargetType().equals("jPlayer")) { lblKinTel.setText("Guardian 1 Telephone Number:"); } //If looking at a junior player profile then change the contents of the label.
		lblKinTel.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblKinTel = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblKinTel.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblKinTel.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblKinTel.gridx = 2; //X coordinate of the JLabel.
		gbc_lblKinTel.gridy = 3; //Y coordinate of the JLabel.
		panelCenter.add(lblKinTel, gbc_lblKinTel); //Add the label and it's constraints to panelCenter.
		
		textFieldKinTel = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldKinTel = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldKinTel.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldKinTel.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldKinTel.gridx = 3; //X coordinate of the JTextField.
		gbc_textFieldKinTel.gridy = 3; //Y coordinate of the JTextField.
		panelCenter.add(textFieldKinTel, gbc_textFieldKinTel); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldKinTel.setEditable(false);
		}

		
		/*Row 5*/
		JLabel lblDOB = new JLabel("Date of Birth*:"); //Create a new JLabel and give it text to display.
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblDOB = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblDOB.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblDOB.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblDOB.gridx = 0; //X coordinate of the JLabel.
		gbc_lblDOB.gridy = 4; //Y coordinate of the JLabel.
		panelCenter.add(lblDOB, gbc_lblDOB); //Add the label and it's constraints to panelCenter.
		
		textFieldDOB = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldDOB = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldDOB.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldDOB.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldDOB.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldDOB.gridy = 4; //Y coordinate of the JTextField.
		panelCenter.add(textFieldDOB, gbc_textFieldDOB); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldDOB.setEditable(false);
		}

		
		JLabel lblDocName = new JLabel("Doctor Name:"); //Create a new JLabel and give it text to display.
		lblDocName.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblDocName = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblDocName.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblDocName.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblDocName.gridx = 2; //X coordinate of the JLabel.
		gbc_lblDocName.gridy = 4; //Y coordinate of the JLabel.
		panelCenter.add(lblDocName, gbc_lblDocName); //Add the label and it's constraints to panelCenter.
		
		textFieldDocName = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldDocName = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldDocName.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldDocName.insets = new Insets(20, 0,20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldDocName.gridx = 3; //X coordinate of the JTextField.
		gbc_textFieldDocName.gridy = 4; //Y coordinate of the JTextField.
		panelCenter.add(textFieldDocName, gbc_textFieldDocName); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldDocName.setEditable(false);
		}

		
		/*Row 6*/
		JLabel lblTelNumber = new JLabel("Telephone Number:"); //Create a new JLabel and give it text to display.
		lblTelNumber.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblTelNumber = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblTelNumber.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblTelNumber.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblTelNumber.gridx = 0; //X coordinate of the JLabel.
		gbc_lblTelNumber.gridy = 5; //Y coordinate of the JLabel.
		panelCenter.add(lblTelNumber, gbc_lblTelNumber); //Add the JLabel and it's constraints to panelCenter.
		
		textFieldTelNumber = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldTelNumber = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldTelNumber.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldTelNumber.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldTelNumber.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldTelNumber.gridy = 5; //Y coordinate of the JTextField.
		panelCenter.add(textFieldTelNumber, gbc_textFieldTelNumber); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldTelNumber.setEditable(false);
		}

		
		JLabel lblDocTel = new JLabel("Doctor's Telephone Number:"); //Create a new JLabel and give it text to display.
		lblDocTel.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblDocTel = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblDocTel.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblDocTel.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblDocTel.gridx = 2; //X coordinate of the JLabel.
		gbc_lblDocTel.gridy = 5; //Y coordinate of the JLabel.
		panelCenter.add(lblDocTel, gbc_lblDocTel); //Add the JLabel and it's constraints to panelCenter.
		
		textFieldDocTel = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldDocTel = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldDocTel.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldDocTel.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldDocTel.gridx = 3; //X coordinate of the JTextField.
		gbc_textFieldDocTel.gridy = 5; //Y coordinate of the JTextField.
		panelCenter.add(textFieldDocTel, gbc_textFieldDocTel); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && !MainClass.getTargetType().equals("loggedUser")) { //If the logged user is a coach and they are not looking at their own profile then make the text field uneditable.
			textFieldDocTel.setEditable(false);
		}
		
		/*Row 7 - Password fields for a logged user*/
		if (MainClass.getTargetType().equals("loggedUser")) {
			
			JLabel lblPass = new JLabel("New Password:"); //Create a new JLabel and give it text to display.
			lblPass.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
			GridBagConstraints gbc_lblPass = new GridBagConstraints(); //Create a new set of GridBagConstraints.
			gbc_lblPass.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
			gbc_lblPass.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
			gbc_lblPass.gridx = 0; //X coordinate of the JLabel.
			gbc_lblPass.gridy = 6; //Y coordinate of the JLabel.
			panelCenter.add(lblPass, gbc_lblPass); //Add the label and it's constraints to panelCenter.
			
			textFieldPass = new JPasswordField(); //Create a new JTextField.
			GridBagConstraints gbc_textFieldPass = new GridBagConstraints(); //Create a new set of GridBagConstraints.
			gbc_textFieldPass.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
			gbc_textFieldPass.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
			gbc_textFieldPass.gridx = 1; //X coordinate of the JTextField.
			gbc_textFieldPass.gridy = 6; //Y coordinate of the JTextField.
			panelCenter.add(textFieldPass, gbc_textFieldPass); //Add the text field and it's constraints to panelCenter.
	
			
			JLabel lblRPass = new JLabel("Repeat Password:"); //Create a new JLabel and give it text to display.
			lblRPass.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
			GridBagConstraints gbc_lblRPass = new GridBagConstraints(); //Create a new set of GridBagConstraints.
			gbc_lblRPass.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
			gbc_lblRPass.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
			gbc_lblRPass.gridx = 2; //X coordinate of the JLabel.
			gbc_lblRPass.gridy = 6; //Y coordinate of the JLabel.
			panelCenter.add(lblRPass, gbc_lblRPass); //Add the label and it's constraints to panelCenter.
			
			textFieldRPass = new JPasswordField();  //Create a new JTextField.
			GridBagConstraints gbc_textFieldRPass = new GridBagConstraints(); //Create a new set of GridBagConstraints.
			gbc_textFieldRPass.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
			gbc_textFieldRPass.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
			gbc_textFieldRPass.gridx = 3; //X coordinate of the JTextField.
			gbc_textFieldRPass.gridy = 6; //Y coordinate of the JTextField.
			panelCenter.add(textFieldRPass, gbc_textFieldRPass); //Add the text field and it's constraints to panelCenter.
			
		}
		
		
		/*-------------------------Bottom Panel Buttons------------------*/
		
			
		JPanel panelSouth = new JPanel(); //Assign panelSouth as a new JPanel.
		panelSouth.setPreferredSize(new Dimension(100,50)); //Width and height (pixels), width gets ignored as it has a South, BorderLayout.
		panelSouth.setBackground(Color.LIGHT_GRAY); //Give it a light grey background.
		contentPane.add(panelSouth, BorderLayout.SOUTH); //Add the panel to the bottom of the screen.
		
		JPanel panelLeftGray = new JPanel(); //Assign panelLeftGray as a new JPanel.
		panelLeftGray.setPreferredSize(new Dimension(162, 0)); //Preferred size of panel. Out of width and height (pixels) of panelLeftGray, only width matters.
		panelLeftGray.setMaximumSize(new Dimension(162, 32767)); //Maximum size of the panel. Width and height (pixels) both matter.
		panelLeftGray.setBackground(Color.BLACK); //Give it a black colour.
		panelSouth.add(panelLeftGray); //Add the panel to panelSouth.
			
		//Looking at own account - Save
		if (MainClass.getTargetType().equals("loggedUser")) {
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnSave = new JButton("Save"); //Create a new JButton and give it text to display. This button will save changes to the logged user.
			btnSave.setBackground(new Color(50, 205, 50)); //Give the button a green background.
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnSave.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnSave); //Add button to panelSouth.
			btnSave.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.saveLoggedUser(); //Call the function to save changes to the logged user.
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
		}
		
		
		
		//Coach looking at Senior Player account - Player Skills
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && MainClass.getTargetType().equals("sPlayer")) {
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnPlayerSkills = new JButton("Player Skills"); //Create a new JButton and give it text to display. This button will display the player skills page with data from the current player.
			btnPlayerSkills.setBackground(new Color(152, 251, 152)); //Give the button a light green background.
			btnPlayerSkills.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnPlayerSkills.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnPlayerSkills.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnPlayerSkills); //Add button to panelSouth.
			btnPlayerSkills.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.showPlayerSkills(); //Call function to create and display the skills page with data from the current player.
					dispose(); //Get rid of this screen.
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		}
		
		
		
		//Coach looking at Junior Player account - More Details, Player Skills
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach") && MainClass.getTargetType().equals("jPlayer")) {
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnMoreDetails = new JButton("More Details"); //Create a new JButton and give it text to display. This button will create and display the junior screen with details of the current junior player.
			btnMoreDetails.setBackground(new Color(152, 251, 152)); //Give the button a bright green background.
			btnMoreDetails.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnMoreDetails.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnMoreDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnMoreDetails); //Add button to panelSouth.
			btnMoreDetails.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.showJuniorDetails(); //Call the function to create and display the junior screen with details of the current junior player.
					dispose(); //Get rid of this screen.
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnPlayerSkills = new JButton("Player Skills"); //Create a new JButton and give it text to display. This button will display the player skills page with data from the current player.
			btnPlayerSkills.setBackground(new Color(152, 251, 152)); //Give the button a light green background.
			btnPlayerSkills.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnPlayerSkills.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnPlayerSkills.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnPlayerSkills); //Add button to panelSouth.
			btnPlayerSkills.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.showPlayerSkills(); //Call function to create and display the skills page with data from the current player.
					dispose(); //Get rid of this screen.
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		}
		
		
		
		//Secretary looking at Coach/Secretary account - Reset Password, Save, Delete Account
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Secretary") && MainClass.getTargetType().equals("user")) {
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnResetPassword = new JButton("Reset Password"); //Create a new JButton and give it text to display. This button will reset the password of the target coach/secretary profile to "root".
			btnResetPassword.setBackground(Color.ORANGE); //Give the button a orange background.
			btnResetPassword.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnResetPassword.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnResetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnResetPassword); //Add button to panelSouth.
			btnResetPassword.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					//Confirm password reset dialogue box.
					int a = JOptionPane.showConfirmDialog(contentPane, "Are you sure you wish to reset the password for this account?", "Warning!", JOptionPane.YES_NO_OPTION);
					
					if(a==JOptionPane.YES_OPTION) {  //If the user confirms...
						
						myController.resetPassword(); //Function to reset the password of the selected coach/secretary profile to "root".
					}
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnSave = new JButton("Save"); //Create a new JButton and give it text to display. This button will save changes to the selected coach/secretary account.
			btnSave.setBackground(new Color(50, 205, 50)); //Give the button a green background.
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnSave.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnSave); //Add button to panelSouth.
			btnSave.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.editUser(); //Call the function to save changes to the selected coach/secretary account.
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnDeleteAccount = new JButton("Delete Account"); //Create a new JButton and give it text to display. This button will delete the selected coach or secretary profile.
			btnDeleteAccount.setBackground(Color.RED); //Give the button a red background.
			btnDeleteAccount.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnDeleteAccount.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnDeleteAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnDeleteAccount); //Add button to panelSouth.
			btnDeleteAccount.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					//Confirm profile deletion dialogue box.
					int a = JOptionPane.showConfirmDialog(contentPane, "Are you sure you wish to delete this account?", "Warning!", JOptionPane.YES_NO_OPTION);
					
					if(a==JOptionPane.YES_OPTION) {  //If the user confirms...
						
						myController.deleteUser(); //Call function to delete the selected coach or secretary profile, then return to secretary menu.
					}
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		}
		
		
		
		//Secretary looking at Senior Player/ Non Player account - Save, Delete Account
		if (!MainClass.isNewAccount() && MainClass.getDataManager().getLoggedUser().getUserType().equals("Secretary") && (MainClass.getTargetType().equals("sPlayer") || MainClass.getTargetType().equals("nPlayer")) ) {
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnSave = new JButton("Save"); //Create a new JButton and give it text to display. This button will save changes to the selected senior player or non-player profile.
			btnSave.setBackground(new Color(50, 205, 50)); //Give the button a green background.
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnSave.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnSave); //Add button to panelSouth.
			btnSave.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					if (MainClass.getTargetType().equals("sPlayer")) //If looking at a senior player...
					{
						myController.editSeniorPlayer(); //Call function to save the changes to the senior player profile.
					}
					else if (MainClass.getTargetType().equals("nPlayer")) //If looking at a non-player...
					{
						myController.editNonPlayer(); //Call function to save the changes to the non-player profile.
					}
					
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnDeleteAccount = new JButton("Delete Account"); //Create a new JButton and give it text to display. This button will delete the selected senior player or non-player profile.
			btnDeleteAccount.setBackground(Color.RED); //Give the button a red background.
			btnDeleteAccount.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnDeleteAccount.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnDeleteAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnDeleteAccount); //Add button to panelSouth.
			btnDeleteAccount.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					//Confirm profile deletion dialogue box.
					int a = JOptionPane.showConfirmDialog(contentPane, "Are you sure you wish to delete this account?", "Warning!", JOptionPane.YES_NO_OPTION);
					
					if(a==JOptionPane.YES_OPTION) {  //If the user confirms deletion...
						
						if (MainClass.getTargetType().equals("sPlayer")) //If the profile being looked at is a senior player...
						{
							myController.deleteSeniorPlayer(); //Call function to delete the senior player profile and return to secretary menu.
							dispose(); //Get rid of this screen.
						}
						else if (MainClass.getTargetType().equals("nPlayer")) //If the profile being looked at is a non-player...
						{
							myController.deleteNonPlayer(); //Call function to delete the non-player profile and return to secretary menu.
							dispose(); //Get rid of this screen.
						}
					}
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
		}
		
		
		
		//Secretary looking at Junior Player account - Delete Account, More Details
		if (!MainClass.isNewAccount() && MainClass.getDataManager().getLoggedUser().getUserType().equals("Secretary") && MainClass.getTargetType().equals("jPlayer") ) {
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnDeleteAccount = new JButton("Delete Account"); //Create a new JButton and give it text to display. This button will delete the selected junior player profile.
			btnDeleteAccount.setBackground(Color.RED); //Give the button a red background.
			btnDeleteAccount.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnDeleteAccount.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnDeleteAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnDeleteAccount); //Add button to panelSouth.
			btnDeleteAccount.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					//Confirm profile deletion dialogue box.
					int a = JOptionPane.showConfirmDialog(contentPane, "Are you sure you wish to delete this account?", "Warning!", JOptionPane.YES_NO_OPTION);
					
					if(a==JOptionPane.YES_OPTION) {  
						
						myController.deleteJuniorPlayer(); //If the user confirms, call function to delete the selected junior player profile and return to secretary menu.
						dispose(); //Get rid of this screen.
					}
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnMoreDetails = new JButton("More Details"); //Create a new JButton and give it text to display. This button will save details to jPlayer object and show junior screen.
			btnMoreDetails.setBackground(new Color(152, 251, 152)); //Give the button a bright green background.
			btnMoreDetails.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnMoreDetails.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnMoreDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnMoreDetails); //Add button to panelSouth.
			btnMoreDetails.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.rememberJuniorShowMoreDetails(); //Save details to jPlayer object and show junior screen.
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		}

		

		//Secretary looking at Junior Player account creation - More Details
		if(MainClass.isNewAccount() && MainClass.getTargetType().equals("jPlayer")) {
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnMoreDetails = new JButton("More Details"); //Create a new JButton and give it text to display. This button will save details to jPlayer object and show junior screen.
			btnMoreDetails.setBackground(new Color(152, 251, 152)); //Give the button a bright green background.
			btnMoreDetails.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnMoreDetails.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnMoreDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnMoreDetails); //Add button to panelSouth.
			btnMoreDetails.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.rememberJuniorShowMoreDetails(); //Save details to jPlayer object and show junior screen.
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		}
		
		
		
		//Secretary looking at any Non Junior account creation - Create Account
		if(MainClass.isNewAccount() && !MainClass.getTargetType().equals("jPlayer")) {
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnCreateAccount = new JButton("Create Account"); //Create a new JButton and give it text to display. This button will create a new coach/secretary/senior player or non-player profile.
			btnCreateAccount.setBackground(new Color(50, 205, 50)); //Give the button a green background.
			btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnCreateAccount.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnCreateAccount); //Add button to panelSouth.
			btnCreateAccount.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					if (MainClass.getTargetType().equals("Coach")) //If creating a coach profile...
					{
						myController.createCoach(); //Call function to create a new coach profile. Then return to secretary menu.
					}
					else if (MainClass.getTargetType().equals("Secretary")) //If creating a secretary profile...
					{
						myController.createSecretary(); //Call function to create a new secretary profile. Then return to secretary menu.
					}
					else if (MainClass.getTargetType().equals("sPlayer")) //If creating a senior player profile...
					{
						myController.createSeniorPlayer(); //Call function to create a new senior player profile. Then return to secretary menu.
					}
					else //If creating a non-player profile...
					{
						myController.createNonPlayer(); //Call function to create a new non-player profile. Then return to secretary menu.
					}
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
		}
			

	}
	
	/*Getters for text fields*/
	
	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldFullName which holds the full name of the profile.
	 */
	public JTextField getTextFieldFullName() {
		return textFieldFullName;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldAddress which holds the home address of the profile.
	 */
	public JTextField getTextFieldAddress() {
		return textFieldAddress;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldPostCode which holds the post code of the profile.
	 */
	public JTextField getTextFieldPostCode() {
		return textFieldPostCode;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldEmail which holds the email address of the profile.
	 */
	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldMobNumber which holds the mobile number of the profile.
	 */
	public JTextField getTextFieldMobNumber() {
		return textFieldMobNumber;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldKin which holds the name of the first kin of the profile.
	 */
	public JTextField getTextFieldKin() {
		return textFieldKin;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldSRUNumber which holds the Scottish Rugby Union number of the profile.
	 */
	public JTextField getTextFieldSRUNumber() {
		return textFieldSRUNumber;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldTelNumber which holds the home telephone of the profile.
	 */
	public JTextField getTextFieldTelNumber() {
		return textFieldTelNumber;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldPass which holds the password of the profile.
	 */
	public JTextField getTextFieldPass() {
		return textFieldPass;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldKinTel which holds the telephone number of the first kin of the profile.
	 */
	public JTextField getTextFieldKinTel() {
		return textFieldKinTel;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldDocTel which holds the telephone number of the profile's doctor.
	 */
	public JTextField getTextFieldDocTel() {
		return textFieldDocTel;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldRPass which holds the repeated password of the profile.
	 */
	public JTextField getTextFieldRPass() {
		return textFieldRPass;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldDocName which holds the name of the doctor of the profile.
	 */
	public JTextField getTextFieldDocName() {
		return textFieldDocName;
	}

	/**
	 * Getter for the ProfileScreen class.
	 * @return textFieldDOB which holds the date of birth of the profile.
	 */
	public JTextField getTextFieldDOB() {
		return textFieldDOB;
	}

	/*Setters for text fields*/
	
	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldFullName holds the full name of the profile.
	 */
	public void setTextFieldFullName(String textFieldFullName) {
		this.textFieldFullName.setText(textFieldFullName);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldAddress holds the home address of the profile.
	 */
	public void setTextFieldAddress(String textFieldAddress) {
		this.textFieldAddress.setText(textFieldAddress);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldPostCode holds the post code of the profile.
	 */
	public void setTextFieldPostCode(String textFieldPostCode) {
		this.textFieldPostCode.setText(textFieldPostCode);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldEmail holds the email address of the profile.
	 */
	public void setTextFieldEmail(String textFieldEmail) {
		this.textFieldEmail.setText(textFieldEmail);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldMobNumber holds the mobile number of the profile.
	 */
	public void setTextFieldMobNumber(String textFieldMobNumber) {
		this.textFieldMobNumber.setText(textFieldMobNumber);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldKin holds the name of the first kin of the profile.
	 */
	public void setTextFieldKin(String textFieldKin) {
		this.textFieldKin.setText(textFieldKin);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldSRUNumber holds the Scottish Rugby Union number of the profile.
	 */
	public void setTextFieldSRUNumber(String textFieldSRUNumber) {
		this.textFieldSRUNumber.setText(textFieldSRUNumber);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldTelNumber holds the home telephone of the profile.
	 */
	public void setTextFieldTelNumber(String textFieldTelNumber) {
		this.textFieldTelNumber.setText(textFieldTelNumber);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldPass holds the password of the profile.
	 */
	public void setTextFieldPass(String textFieldPass) {
		this.textFieldPass.setText(textFieldPass);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldKinTel holds the telephone number of the first kin of the profile.
	 */
	public void setTextFieldKinTel(String textFieldKinTel) {
		this.textFieldKinTel.setText(textFieldKinTel);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldDocTel holds the telephone number of the profile's doctor.
	 */
	public void setTextFieldDocTel(String textFieldDocTel) {
		this.textFieldDocTel.setText(textFieldDocTel);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldRPass holds the repeated password of the profile.
	 */
	public void setTextFieldRPass(String textFieldRPass) {
		this.textFieldRPass.setText(textFieldRPass);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldDocName holds the name of the doctor of the profile.
	 */
	public void setTextFieldDocName(String textFieldDocName) {
		this.textFieldDocName.setText(textFieldDocName);
	}

	/**
	 * Setter for the ProfileScreen class.
	 * @param textFieldDOB holds the date of birth of the profile.
	 */
	public void setTextFieldDOB(String textFieldDOB) {
		this.textFieldDOB.setText(textFieldDOB);
	}

	
	//Setter for the Nav Bar name label
	/**
	 * Setter for the ProfileScreen class.
	 * @param lblName holds the name of the logged user.
	 */
	public void setLblName(String lblName) {
		this.lblName.setText(lblName);
	}
	


}
