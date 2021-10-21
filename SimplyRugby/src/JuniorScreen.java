import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * This class is responsible for the graphical interface of the junior screen.
 * It allows coaches to view additional information exclusive to junior players.
 * From here coaches are able to navigate to the profile page or the skills page for that junior player. 
 * Secretaries can edit text fields on this screen and save the changes to an existing junior player or a newly created junior player.
 * They can also delete the junior player account.
 * From here secretaries can navigate back to the profile page for that junior player, any edits made on this page will be temporarily remembered.
 * This class inherits from JFrame.
 *@author Renat Oosthuizen
 *@since 13/05/2021
 */
@SuppressWarnings("serial")
public class JuniorScreen extends JFrame {

	/**JuniorController variable that performs all the logic for this screen.*/
	private JuniorController myController;
	
	/**Holds the junior player's relationship to the first guardian.*/
	private JTextField textFieldG1Relationship;
	/**Holds the address of the first guardian of the junior player.*/
	private JTextField textFieldG1Address;
	/**Holds the name of the second guardian of the junior player.*/
	private JTextField textFieldG2Name;
	/**Holds the junior player's relationship to the second guardian.*/
	private JTextField textFieldG2Relationship;
	/**Holds the phone number  of the second guardian of the junior player.*/
	private JTextField textFieldG2TelNumber;
	/**Holds the address of the junior player's doctor.*/
	private JTextField textFieldDocAddress;
	/**Holds the address of the second guardian of the junior player.*/
	private JTextField textFieldG2Address;

	/**
	 * Parameterised constructor for the class. It accepts it's own controller class in order to create data binding between the two classes.
	 * @param control is the controller for this View Screen.
	 */
	public JuniorScreen(JuniorController control) {
		
		myController = control; //Assign myController as an instance of JuniorScreenController.
		
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
		JLabel lblName = new JLabel(MainClass.getDataManager().getLoggedUser().getFullName()); //Assign lblName as a new JLabel that displays the name of the user.
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
		
		//If logged user is a coach, display these navigation buttons.
		if  (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach")) { 
			
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
		//If logged user is a secretary, display these navigation buttons.
		if  (MainClass.getDataManager().getLoggedUser().getUserType().equals("Secretary")) { 
			
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
		gbl_panelCenter.columnWeights = new double[]{0.0, 1.0}; //Give the layout column weights.
		panelCenter.setLayout(gbl_panelCenter); //Add the layout to panelCentre.
		
		/*Row 1*/
		JLabel lblG1Relationship = new JLabel("Guardian 1 Relationship:"); //Create a new JLabel and give it text to display.
		lblG1Relationship.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblG1Relationship = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblG1Relationship.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblG1Relationship.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblG1Relationship.gridx = 0; //X coordinate of the JLabel.
		gbc_lblG1Relationship.gridy = 0; //Y coordinate of the JLabel.
		panelCenter.add(lblG1Relationship, gbc_lblG1Relationship); //Add the label and it's constraints to panelCenter.
		
		textFieldG1Relationship = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldG1Relationship = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldG1Relationship.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldG1Relationship.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldG1Relationship.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldG1Relationship.gridy = 0; //Y coordinate of the JTextField.
		panelCenter.add(textFieldG1Relationship, gbc_textFieldG1Relationship); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach")) { //If the logged user is a coach then make the text field uneditable.
			textFieldG1Relationship.setEditable(false);
		}

		
		/*Row 2*/
		JLabel lblG1Address = new JLabel("Guardian 1 Address:"); //Create a new JLabel and give it text to display.
		lblG1Address.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblG1Address = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblG1Address.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblG1Address.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblG1Address.gridx = 0; //X coordinate of the JLabel.
		gbc_lblG1Address.gridy = 1; //Y coordinate of the JLabel.
		panelCenter.add(lblG1Address, gbc_lblG1Address); //Add the label and it's constraints to panelCenter.
		
		textFieldG1Address = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldG1Address = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldG1Address.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldG1Address.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldG1Address.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldG1Address.gridy = 1; //Y coordinate of the JTextField.
		panelCenter.add(textFieldG1Address, gbc_textFieldG1Address); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach")) { //If the logged user is a coach then make the text field uneditable.
			textFieldG1Address.setEditable(false);
		}
		
		/*Row 3*/
		JLabel lblG2Name = new JLabel("Guardian 2 Name:"); //Create a new JLabel and give it text to display.
		lblG2Name.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblG2Name = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblG2Name.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblG2Name.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblG2Name.gridx = 0; //X coordinate of the JLabel.
		gbc_lblG2Name.gridy = 2; //Y coordinate of the JLabel.
		panelCenter.add(lblG2Name, gbc_lblG2Name); //Add the label and it's constraints to panelCenter.
		
		textFieldG2Name = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldG2Name = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldG2Name.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldG2Name.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldG2Name.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldG2Name.gridy = 2; //Y coordinate of the JTextField.
		panelCenter.add(textFieldG2Name, gbc_textFieldG2Name); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach")) { //If the logged user is a coach then make the text field uneditable.
			textFieldG2Name.setEditable(false);
		}
		
		/*Row 4*/
		JLabel lblG2Relationship = new JLabel("Guardian 2 Relationship:"); //Create a new JLabel and give it text to display.
		lblG2Relationship.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblG2Relationship = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblG2Relationship.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblG2Relationship.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblG2Relationship.gridx = 0; //X coordinate of the JLabel.
		gbc_lblG2Relationship.gridy = 3; //Y coordinate of the JLabel.
		panelCenter.add(lblG2Relationship, gbc_lblG2Relationship); //Add the label and it's constraints to panelCenter.
		
		textFieldG2Relationship = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldG2Relationship = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldG2Relationship.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldG2Relationship.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldG2Relationship.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldG2Relationship.gridy = 3; //Y coordinate of the JTextField.
		panelCenter.add(textFieldG2Relationship, gbc_textFieldG2Relationship); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach")) { //If the logged user is a coach then make the text field uneditable.
			textFieldG2Relationship.setEditable(false);
		}
		
		/*Row 5*/
		JLabel lblG2Address = new JLabel("Guardian 2 Address:"); //Create a new JLabel and give it text to display.
		lblG2Address.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblG2Address = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblG2Address.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblG2Address.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblG2Address.gridx = 0; //X coordinate of the JLabel.
		gbc_lblG2Address.gridy = 4; //Y coordinate of the JLabel.
		panelCenter.add(lblG2Address, gbc_lblG2Address); //Add the label and it's constraints to panelCenter.
		
		textFieldG2Address = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldG2Address = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldG2Address.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldG2Address.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldG2Address.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldG2Address.gridy = 4; //Y coordinate of the JTextField.
		panelCenter.add(textFieldG2Address, gbc_textFieldG2Address); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach")) { //If the logged user is a coach then make the text field uneditable.
			textFieldG2Address.setEditable(false);
		}
		
		/*Row 6*/
		JLabel lblG2TelNumber = new JLabel("Guardian 2 Telephone Number:"); //Create a new JLabel and give it text to display.
		lblG2TelNumber.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblG2TelNumber = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblG2TelNumber.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblG2TelNumber.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblG2TelNumber.gridx = 0; //X coordinate of the JLabel.
		gbc_lblG2TelNumber.gridy = 5; //Y coordinate of the JLabel.
		panelCenter.add(lblG2TelNumber, gbc_lblG2TelNumber); //Add the label and it's constraints to panelCenter.
		
		textFieldG2TelNumber = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldG2TelNumber = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldG2TelNumber.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldG2TelNumber.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldG2TelNumber.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldG2TelNumber.gridy = 5; //Y coordinate of the JTextField.
		panelCenter.add(textFieldG2TelNumber, gbc_textFieldG2TelNumber); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach")) { //If the logged user is a coach then make the text field uneditable.
			textFieldG2TelNumber.setEditable(false);
		}
		
		/*Row 7*/
		JLabel lblDocAddress = new JLabel("Doctor's Address:"); //Create a new JLabel and give it text to display.
		lblDocAddress.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblDocAddress = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblDocAddress.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblDocAddress.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblDocAddress.gridx = 0; //X coordinate of the JLabel.
		gbc_lblDocAddress.gridy = 6; //Y coordinate of the JLabel.
		panelCenter.add(lblDocAddress, gbc_lblDocAddress); //Add the label and it's constraints to panelCenter.
		
		textFieldDocAddress = new JTextField(); //Create a new JTextField.
		GridBagConstraints gbc_textFieldDocAddress = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldDocAddress.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldDocAddress.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldDocAddress.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldDocAddress.gridy = 6; //Y coordinate of the JTextField.
		panelCenter.add(textFieldDocAddress, gbc_textFieldDocAddress); //Add the text field and it's constraints to panelCenter.
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach")) { //If the logged user is a coach then make the text field uneditable.
			textFieldDocAddress.setEditable(false);
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
			
		panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
		/*If a Coach is looking at a junior account.*/
		if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Coach")) 
		{ 

			JButton btnGoBack = new JButton("Go Back"); //Create a new JButton and give it text to display. This button will take the user back to the profile page without re-querying the database.
			btnGoBack.setBackground(new Color(152, 251, 152)); //Give the button a light green background.
			btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnGoBack.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnGoBack); //Add button to panelSouth.
			btnGoBack.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.goBackCoach(); //Takes user back to the player profile page without re-querying the database.
					dispose(); //Get rid of this screen.
				}
			});
	
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnPlayerSkills = new JButton("Player Skills"); //Create a new JButton and give it text to display. This button will show the skills page for the current junior player.
			btnPlayerSkills.setBackground(new Color(152, 251, 152)); //Give the button a light green background.
			btnPlayerSkills.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnPlayerSkills.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnPlayerSkills.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnPlayerSkills); //Add button to panelSouth.
			btnPlayerSkills.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.showPlayerSkills(); //Create and display the skills page for the current junior player.
					dispose(); //Get rid of this screen
				}
			});
			
		}
		/*If a Secretary is creating a new junior account.*/
		else if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Secretary") && MainClass.isNewAccount()) 
		{ 
			
			JButton btnGoBack = new JButton("Go Back"); //Create a new JButton and give it text to display. This button will take the user back to the profile page while remembering any edits made on this page.
			btnGoBack.setBackground(new Color(152, 251, 152)); //Give the button a light green background.
			btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnGoBack.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnGoBack); //Add button to panelSouth.
			btnGoBack.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.goBackSecretary(); //Takes user back to the player profile page without re-querying the database. Edits made on this page will be remembered.
					dispose(); //Get rid of this screen
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions. This button will save data from this page and the profile page to the database.
			
			JButton btnSave = new JButton("Create Account"); //Create a new JButton and give it text to display.
			btnSave.setBackground(new Color(50, 205, 50)); //Give the button a green background.
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnSave.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnSave); //Add button to panelSouth.
			btnSave.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) { 
					
					myController.saveNewJuniorPlayer(); //Save data from this page and the profile page to the database. Return to secretary menu.
					dispose(); //Get rid of this screen.
				}
			});
			
		}
		/*If a Secretary is looking at an existing Junior Player account*/
		else if (MainClass.getDataManager().getLoggedUser().getUserType().equals("Secretary") && !MainClass.isNewAccount())
		{
			
			JButton btnGoBack = new JButton("Go Back"); //Create a new JButton and give it text to display. This button will take the user back to the profile page while remembering any edits made on this page.
			btnGoBack.setBackground(new Color(152, 251, 152)); //Give the button a light green background.
			btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnGoBack.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnGoBack); //Add button to panelSouth.
			btnGoBack.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.goBackSecretary(); //Takes user back to the player profile page without re-querying the database. Edits made on this page will be remembered.
					dispose(); //Get rid of this screen
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnSave = new JButton("Save"); //Create a new JButton and give it text to display. This button will save changes made to the current junior player from both this and the profile page to the database.
			btnSave.setBackground(new Color(50, 205, 50)); //Give the button a red background.
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnSave.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnSave); //Add button to panelSouth.
			btnSave.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					myController.editJuniorPlayer(); //Save changes made to the current junior player from both this and the profile page to the database.
				}
			});
			
			panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
			
			JButton btnCancelAccountCreation = new JButton("Delete Account"); //Create a new JButton and give it text to display. This button will delete this junior player and return to secretary menu.
			btnCancelAccountCreation.setBackground(Color.RED); //Give the button a red background.
			btnCancelAccountCreation.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
			btnCancelAccountCreation.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
			panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
			btnCancelAccountCreation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
			panelSouth.add(btnCancelAccountCreation); //Add button to panelSouth.
			btnCancelAccountCreation.addActionListener(new ActionListener() { //When button is clicked...
				public void actionPerformed(ActionEvent e) {
					
					//Confirm profile deletion dialogue box.
					int a = JOptionPane.showConfirmDialog(contentPane, "Are you sure you wish to delete this account?", "Warning!", JOptionPane.YES_NO_OPTION);
					
					if(a==JOptionPane.YES_OPTION) {  
						
						myController.deleteJuniorPlayer(); //Delete this junior player and return to secretary menu.
						dispose(); //Get rid of this screen
					}
				}
			});
			
		}

		panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
	}

	//Getters
	
	/**
	 * Getter for the JuniorScreen class.
	 * @return contents of textFieldG1Relationship which holds the junior player's relationship to the first guardian.
	 */
	public String getTextFieldG1Relationship() {
		return textFieldG1Relationship.getText();
	}

	/**
	 * Getter for the JuniorScreen class.
	 * @return contents of textFieldG1Address which holds the address of the first guardian of the junior player.
	 */
	public String getTextFieldG1Address() {
		return textFieldG1Address.getText();
	}

	/**
	 * Getter for the JuniorScreen class.
	 * @return contents of textFieldG2Name which holds the name of the second guardian of the junior player.
	 */
	public String getTextFieldG2Name() {
		return textFieldG2Name.getText();
	}

	/**
	 * Getter for the JuniorScreen class.
	 * @return contents of textFieldG2Relationship which holds the junior player's relationship to the second guardian.
	 */
	public String getTextFieldG2Relationship() {
		return textFieldG2Relationship.getText();
	}

	/**
	 * Getter for the JuniorScreen class.
	 * @return contents of textFieldG2TelNumber which holds the phone number  of the second guardian of the junior player.
	 */
	public String getTextFieldG2TelNumber() {
		return textFieldG2TelNumber.getText();
	}

	/**
	 * Getter for the JuniorScreen class.
	 * @return contents of textFieldDocAddress which holds the address of the junior player's doctor.
	 */
	public String getTextFieldDocAddress() {
		return textFieldDocAddress.getText();
	}

	/**
	 * Getter for the JuniorScreen class.
	 * @return contents of textFieldG2Address which holds the address of the second guardian of the junior player.
	 */
	public String getTextFieldG2Address() {
		return textFieldG2Address.getText();
	}

	//Setters
	
	/**
	 * Setter for the JuniorScreen class.
	 * @param textFieldG1Relationship which holds the junior player's relationship to the first guardian.
	 */
	public void setTextFieldG1Relationship(String textFieldG1Relationship) {
		this.textFieldG1Relationship.setText(textFieldG1Relationship);
	}

	/**
	 * Setter for the JuniorScreen class.
	 * @param textFieldG1Address which holds the address of the first guardian of the junior player.
	 */
	public void setTextFieldG1Address(String textFieldG1Address) {
		this.textFieldG1Address.setText(textFieldG1Address);
	}

	/**
	 * Setter for the JuniorScreen class.
	 * @param textFieldG2Name which holds the name of the second guardian of the junior player.
	 */
	public void setTextFieldG2Name(String textFieldG2Name) {
		this.textFieldG2Name.setText(textFieldG2Name);
	}

	/**
	 * Setter for the JuniorScreen class.
	 * @param textFieldG2Relationship which holds the junior player's relationship to the second guardian.
	 */
	public void setTextFieldG2Relationship(String textFieldG2Relationship) {
		this.textFieldG2Relationship.setText(textFieldG2Relationship);
	}

	/**
	 * Setter for the JuniorScreen class.
	 * @param textFieldG2TelNumber which holds the phone number  of the second guardian of the junior player.
	 */
	public void setTextFieldG2TelNumber(String textFieldG2TelNumber) {
		this.textFieldG2TelNumber.setText(textFieldG2TelNumber);
	}

	/**
	 * Setter for the JuniorScreen class.
	 * @param textFieldDocAddress which holds the address of the junior player's doctor.
	 */
	public void setTextFieldDocAddress(String textFieldDocAddress) {
		this.textFieldDocAddress.setText(textFieldDocAddress);
	}

	/**
	 * Setter for the JuniorScreen class.
	 * @param textFieldG2Address which holds the address of the second guardian of the junior player.
	 */
	public void setTextFieldG2Address(String textFieldG2Address) {
		this.textFieldG2Address.setText(textFieldG2Address);
	}
	
	

}
