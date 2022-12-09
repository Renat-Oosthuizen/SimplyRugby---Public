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
 * This class is responsible for the graphical interface of the edit squad screen.
 * It is only accessible by coaches.
 * The coach can edit the squad name or input profile IDs into different positions within the squad.
 * When saved, the page will update and display the player names while hiding profile IDs.
 * This class inherits from JFrame.
 *@author Renat Oosthuizen
 *@since 13/05/2021
 */
@SuppressWarnings("serial")
public class EditSquadScreen extends JFrame {

	/**EditSquadController variable that performs all the logic for this screen.*/
	private EditSquadController myController;
	
	/**Holds the name of the first coach in the squad.*/
	private JTextField textFieldCoach1;
	/**Holds the name of the second coach in the squad.*/
	private JTextField textFieldCoach2;
	/**Holds the name of the third coach in the squad*/
	private JTextField textFieldCoach3;
	/**Holds the name of the player in the Number Eight position.*/
	private JTextField textFieldNumberEight;
	/**Holds the name of the player in the Right Flanker position.*/
	private JTextField textFieldRightFlanker;
	/**Holds the name of the player in the Scrum Half position.*/
	private JTextField textFieldScrumHalf;
	/**Holds the name of the player in the Hooker position.*/
	private JTextField textFieldHooker;
	/**Holds the name of the player in the Right Prop position.*/
	private JTextField textFieldRightProp;
	/**Holds the name of the player in the Left Lock position.*/
	private JTextField textFieldLeftLock;
	/**Holds the name of the player in the Fly Half position.*/
	private JTextField textFieldFlyHalf;
	/**Holds the name of the player in the Outer Centre position.*/
	private JTextField textFieldOuterCentre;
	/**Holds the name of the player in the Left Wing position.*/
	private JTextField textFieldLeftWing;
	/**Holds the name of the player in the Inner Centre position.*/
	private JTextField textFieldInnerCentre;
	/**Holds the name of the player in the Left Prop position.*/
	private JTextField textFieldLeftProp;
	/**Holds the name of the player in the Right Lock position.*/
	private JTextField textFieldRightLock;
	/**Holds the name of the player in the Right Wing position.*/
	private JTextField textFieldRightWing;
	/**Holds the name of the player in the Left Flanker position.*/
	private JTextField textFieldLeftFlanker;
	/**Holds the name of the player in the Full Back position.*/
	private JTextField textFieldFullBack;
	
	/**Holds the name of the squad.*/
	private JTextField textFieldSquadName;
	/**Holds the ID of the first coach in the squad.*/
	private JTextField textFieldCoach1ID;
	/**Holds the ID of the second coach in the squad.*/
	private JTextField textFieldCoach2ID;
	/**Holds the ID of the third coach in the squad.*/
	private JTextField textFieldCoach3ID;
	/**Holds the ID of the player in the Hooker position.*/
	private JTextField textFieldHookerID;
	/**Holds the ID of the player in the Left Prop position.*/
	private JTextField textFieldLeftPropID;
	/**Holds the ID of the player in the Right Prop position.*/
	private JTextField textFieldRightPropID;
	/**Holds the ID of the player in the Left Lock position.*/
	private JTextField textFieldLeftLockID;
	/**Holds the ID of the player in the Right Lock position.*/
	private JTextField textFieldRightLockID;
	/**Holds the ID of the player in the Left Flanker position.*/
	private JTextField textFieldLeftFlankerID;
	/**Holds the ID of the player in the Right Flanker position.*/
	private JTextField textFieldRightFlankerID;
	/**Holds the ID of the player in the Number Eight position.*/
	private JTextField textFieldNumberEightID;
	/**Holds the ID of the player in the Scrum Half position.*/
	private JTextField textFieldScrumHalfID;
	/**Holds the ID of the player in the Fly Half position.*/
	private JTextField textFieldFlyHalfID;
	/**Holds the ID of the player in the Inner Centre position.*/
	private JTextField textFieldInnerCentreID;
	/**Holds the ID of the player in the Outer Centre position.*/
	private JTextField textFieldOuterCentreID;
	/**Holds the ID of the player in the Left Wing position.*/
	private JTextField textFieldLeftWingID;
	/**Holds the ID of the player in the Right Wing position.*/
	private JTextField textFieldRightWingID;
	/**Holds the ID of the player in the Full Back position.*/
	private JTextField textFieldFullBackID;

	/**
	 * Parameterised constructor for the class. It accepts it's own controller class in order to create data binding between the two classes.
	 * @param control is the controller for this View Screen.
	 */
	public EditSquadScreen(EditSquadController control) {
		
		myController = control; //Assign myController as an instance of EditSquadController.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The application will quit when the JFrame is closed.
		setBounds(0, 0, 1920, 1080); //JFrame is created at coordinates 0, 0 of screen with 1920x1080 pixel dimensions.
		final JPanel contentPane = new JPanel(); //Assign contentPane to be a new instance of JPanel. This is the main panel of the JFrame.
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
		lblLogo.setIcon(new ImageIcon(ProfileScreen.class.getResource("/resources/Blue Logo Small.png"))); //Insert an image into lblLogo. Will only work as an executable because of Maven, remove "/resources" to compile in IDE
	
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
		
		/*-------------------------Central Form------------------*/
		
		JPanel panelCenter = new JPanel(); //Assign panelCenter as a new JPanel.
		panelCenter.setBackground(Color.LIGHT_GRAY); //Give it a light grey background.
		contentPane.add(panelCenter, BorderLayout.CENTER); //Place it in the centre of contentPane.
		GridBagLayout gbl_panelCenter = new GridBagLayout(); //Assign gbl_panelCenter as a new GridBagLayout.
		gbl_panelCenter.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0}; //Give the layout column weights.
		panelCenter.setLayout(gbl_panelCenter); //Add the layout to panelCentre.
		
		/*Row 1*/
		JLabel lblSquadName = new JLabel("Squad Name:"); //Create a new JLabel and give it text to display.
		lblSquadName.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the button.
		GridBagConstraints gbc_lblSquadName = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblSquadName.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblSquadName.insets = new Insets(0, 0, 5, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblSquadName.gridx = 3; //X coordinate of the JLabel.
		gbc_lblSquadName.gridy = 0; //Y coordinate of the JLabel.
		panelCenter.add(lblSquadName, gbc_lblSquadName); //Add the label and it's constraints to panelCenter.
		
		textFieldSquadName = new JTextField(); //Create a new JTextField.
		textFieldSquadName.setFont(new Font("Tahoma", Font.PLAIN, 11)); //Set the font of the text.
		GridBagConstraints gbc_textFieldSquadName = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		textFieldSquadName.setPreferredSize(new Dimension(300, 25)); //Preferred dimensions (width and height in pixels).
		gbc_textFieldSquadName.insets = new Insets(0, 0, 5, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldSquadName.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldSquadName.gridx = 4; //X coordinate of the JTextField.
		gbc_textFieldSquadName.gridy = 0; //Y coordinate of the JTextField.
		panelCenter.add(textFieldSquadName, gbc_textFieldSquadName); //Add the text field and it's constraints to panelCenter.
		
		
		/*Row 2*/
		JLabel lblCoach1 = new JLabel("Coach 1:"); //Create a new JLabel and give it text to display.
		lblCoach1.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblCoach1 = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblCoach1.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblCoach1.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblCoach1.gridx = 0; //X coordinate of the JLabel.
		gbc_lblCoach1.gridy = 1; //Y coordinate of the JLabel.
		panelCenter.add(lblCoach1, gbc_lblCoach1); //Add the label and it's constraints to panelCenter.
		
		textFieldCoach1 = new JTextField(); //Create a new JTextField.
		textFieldCoach1.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldCoach1 = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldCoach1.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldCoach1.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldCoach1.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldCoach1.gridy = 1; //Y coordinate of the JTextField.
		panelCenter.add(textFieldCoach1, gbc_textFieldCoach1); //Add the text field and it's constraints to panelCenter.
		
		textFieldCoach1ID = new JTextField(); //Create a new JTextField.
		textFieldCoach1ID.setEditable(false); //Make the JTextField uneditable by the user.
		textFieldCoach1ID.setToolTipText("Feature is currently disabled. Sorry."); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldCoach1ID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldCoach1ID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally
		gbc_textFieldCoach1ID.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldCoach1ID.gridx = 2; //X coordinate of the JTextField.
		gbc_textFieldCoach1ID.gridy = 1; //Y coordinate of the JTextField.
		panelCenter.add(textFieldCoach1ID, gbc_textFieldCoach1ID); //Add the text field and it's constraints to panelCenter.
		textFieldCoach1ID.setColumns(10); //Adjusts the width of the JTextField and those below it.

		
		JLabel lblRightFlanker = new JLabel("Right Flanker:"); //Create a new JLabel and give it text to display.
		lblRightFlanker.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblRightFlanker = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblRightFlanker.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblRightFlanker.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblRightFlanker.gridx = 5; //X coordinate of the JLabel.
		gbc_lblRightFlanker.gridy = 1; //Y coordinate of the JLabel.
		panelCenter.add(lblRightFlanker, gbc_lblRightFlanker); //Add the label and it's constraints to panelCenter.
		
		textFieldRightFlanker = new JTextField(); //Create a new JTextField.
		textFieldRightFlanker.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldRightFlanker = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldRightFlanker.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldRightFlanker.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldRightFlanker.gridx = 6; //X coordinate of the JTextField.
		gbc_textFieldRightFlanker.gridy = 1; //Y coordinate of the JTextField
		panelCenter.add(textFieldRightFlanker, gbc_textFieldRightFlanker); //Add the text field and it's constraints to panelCenter.
		 
		textFieldRightFlankerID = new JTextField(); //Create a new JTextField.
		textFieldRightFlankerID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldRightFlankerID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldRightFlankerID.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldRightFlankerID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldRightFlankerID.gridx = 7; //X coordinate of the JTextField.
		gbc_textFieldRightFlankerID.gridy = 1; //Y coordinate of the JTextField.
		panelCenter.add(textFieldRightFlankerID, gbc_textFieldRightFlankerID); //Add the text field and it's constraints to panelCenter.
		textFieldRightFlankerID.setColumns(10); //Adjusts the width of the JTextField and those below it.

		
		/*Row 3*/
		JLabel lblCoach2 = new JLabel("Coach 2:"); //Create a new JLabel and give it text to display.
		lblCoach2.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblCoach2 = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblCoach2.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblCoach2.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblCoach2.gridx = 0; //X coordinate of the JLabel.
		gbc_lblCoach2.gridy = 2; //Y coordinate of the JLabel.
		panelCenter.add(lblCoach2, gbc_lblCoach2); //Add the label and it's constraints to panelCenter.
		
		textFieldCoach2 = new JTextField(); //Create a new JTextField.
		textFieldCoach2.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldCoach2 = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldCoach2.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldCoach2.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldCoach2.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldCoach2.gridy = 2; //Y coordinate of the JTextField.
		panelCenter.add(textFieldCoach2, gbc_textFieldCoach2); //Add the text field and it's constraints to panelCenter.
		 
		textFieldCoach2ID = new JTextField(); //Create a new JTextField.
		textFieldCoach2ID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldCoach2ID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldCoach2ID.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldCoach2ID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldCoach2ID.gridx = 2; //X coordinate of the JTextField.
		gbc_textFieldCoach2ID.gridy = 2; //Y coordinate of the JTextField.
		panelCenter.add(textFieldCoach2ID, gbc_textFieldCoach2ID); //Add the text field and it's constraints to panelCenter.
		
		
		JLabel lblNumberEight = new JLabel("Number Eight:"); //Create a new JLabel and give it text to display.
		lblNumberEight.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblNumberEight = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblNumberEight.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblNumberEight.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblNumberEight.gridx = 5; //X coordinate of the JLabel.
		gbc_lblNumberEight.gridy = 2; //Y coordinate of the JLabel.
		panelCenter.add(lblNumberEight, gbc_lblNumberEight); //Add the label and it's constraints to panelCenter.
		
		textFieldNumberEight = new JTextField(); //Create a new JTextField.
		textFieldNumberEight.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldNumberEight = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldNumberEight.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally
		gbc_textFieldNumberEight.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldNumberEight.gridx = 6; //X coordinate of the JTextField.
		gbc_textFieldNumberEight.gridy = 2; //Y coordinate of the JTextField.
		panelCenter.add(textFieldNumberEight, gbc_textFieldNumberEight); //Add the text field and it's constraints to panelCenter.

		textFieldNumberEightID = new JTextField(); //Create a new JTextField.
		textFieldNumberEightID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldNumberEightID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldNumberEightID.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldNumberEightID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally
		gbc_textFieldNumberEightID.gridx = 7; //X coordinate of the JTextField.
		gbc_textFieldNumberEightID.gridy = 2; //Y coordinate of the JTextField.
		panelCenter.add(textFieldNumberEightID, gbc_textFieldNumberEightID); //Add the text field and it's constraints to panelCenter.
		
		
		/*Row 4*/
		JLabel lblCoach3 = new JLabel("Coach 3:"); //Create a new JLabel and give it text to display.
		lblCoach3.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblCoach3 = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblCoach3.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblCoach3.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblCoach3.gridx = 0; //X coordinate of the JLabel.
		gbc_lblCoach3.gridy = 3; //Y coordinate of the JLabel.
		panelCenter.add(lblCoach3, gbc_lblCoach3); //Add the label and it's constraints to panelCenter.
		
		textFieldCoach3 = new JTextField(); //Create a new JTextField.
		textFieldCoach3.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldCoach3 = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldCoach3.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldCoach3.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldCoach3.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldCoach3.gridy = 3; //X coordinate of the JTextField.
		panelCenter.add(textFieldCoach3, gbc_textFieldCoach3); //Add the text field and it's constraints to panelCenter.
		
		textFieldCoach3ID = new JTextField(); //Create a new JTextField.
		textFieldCoach3ID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldCoach3ID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldCoach3ID.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldCoach3ID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldCoach3ID.gridx = 2; //X coordinate of the JTextField.
		gbc_textFieldCoach3ID.gridy = 3; //X coordinate of the JTextField.
		panelCenter.add(textFieldCoach3ID, gbc_textFieldCoach3ID); //Add the text field and it's constraints to panelCenter.

		
		JLabel lblScrumHalf = new JLabel("Scrum Half:"); //Create a new JLabel and give it text to display.
		lblScrumHalf.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblScrumHalf = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblScrumHalf.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblScrumHalf.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblScrumHalf.gridx = 5; //X coordinate of the JLabel.
		gbc_lblScrumHalf.gridy = 3; //Y coordinate of the JLabel.
		panelCenter.add(lblScrumHalf, gbc_lblScrumHalf); //Add the label and it's constraints to panelCenter.
		
		textFieldScrumHalf = new JTextField(); //Create a new JTextField.
		textFieldScrumHalf.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldScrumHalf = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldScrumHalf.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldScrumHalf.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldScrumHalf.gridx = 6; //X coordinate of the JTextField.
		gbc_textFieldScrumHalf.gridy = 3; //Y coordinate of the JTextField.
		panelCenter.add(textFieldScrumHalf, gbc_textFieldScrumHalf); //Add the text field and it's constraints to panelCenter.

		textFieldScrumHalfID = new JTextField(); //Create a new JTextField.
		textFieldScrumHalfID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldScrumHalfID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldScrumHalfID.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldScrumHalfID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldScrumHalfID.gridx = 7; //X coordinate of the JTextField.
		gbc_textFieldScrumHalfID.gridy = 3; //Y coordinate of the JTextField.
		panelCenter.add(textFieldScrumHalfID, gbc_textFieldScrumHalfID); //Add the text field and it's constraints to panelCenter.
		
		
		/*Row 5*/
		JLabel lblHooker = new JLabel("Hooker:"); //Create a new JLabel and give it text to display.
		lblHooker.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblHooker = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblHooker.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblHooker.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblHooker.gridx = 0; //X coordinate of the JLabel.
		gbc_lblHooker.gridy = 4; //Y coordinate of the JLabel.
		panelCenter.add(lblHooker, gbc_lblHooker); //Add the label and it's constraints to panelCenter.
		
		textFieldHooker = new JTextField(); //Create a new JTextField.
		textFieldHooker.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldHooker = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldHooker.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldHooker.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldHooker.gridx = 1;  //X coordinate of the JTextField.
		gbc_textFieldHooker.gridy = 4; //Y coordinate of the JTextField.
		panelCenter.add(textFieldHooker, gbc_textFieldHooker); //Add the text field and it's constraints to panelCenter.
		
		textFieldHookerID = new JTextField(); //Create a new JTextField.
		textFieldHookerID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldHookerID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldHookerID.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldHookerID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldHookerID.gridx = 2; //X coordinate of the JTextField.
		gbc_textFieldHookerID.gridy = 4; //Y coordinate of the JTextField.
		panelCenter.add(textFieldHookerID, gbc_textFieldHookerID); //Add the text field and it's constraints to panelCenter.

		
		JLabel lblFlyHalf = new JLabel("Fly Half:"); //Create a new JLabel and give it text to display.
		lblFlyHalf.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblFlyHalf = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblFlyHalf.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblFlyHalf.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblFlyHalf.gridx = 5; //X coordinate of the JLabel.
		gbc_lblFlyHalf.gridy = 4; //Y coordinate of the JLabel.
		panelCenter.add(lblFlyHalf, gbc_lblFlyHalf); //Add the label and it's constraints to panelCenter.
		
		textFieldFlyHalf = new JTextField(); //Create a new JTextField.
		textFieldFlyHalf.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldFlyHalf = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldFlyHalf.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldFlyHalf.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldFlyHalf.gridx = 6; //X coordinate of the JTextField.
		gbc_textFieldFlyHalf.gridy = 4; //Y coordinate of the JTextField.
		panelCenter.add(textFieldFlyHalf, gbc_textFieldFlyHalf); //Add the text field and it's constraints to panelCenter.

		textFieldFlyHalfID = new JTextField(); //Create a new JTextField.
		textFieldFlyHalfID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldFlyHalfID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldFlyHalfID.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldFlyHalfID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldFlyHalfID.gridx = 7; //X coordinate of the JTextField.
		gbc_textFieldFlyHalfID.gridy = 4; //Y coordinate of the JTextField.
		panelCenter.add(textFieldFlyHalfID, gbc_textFieldFlyHalfID); //Add the text field and it's constraints to panelCenter.
		
		/*Row 6*/
		JLabel lblLeftProp = new JLabel("Left Prop:"); //Create a new JLabel and give it text to display.
		lblLeftProp.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblLeftProp = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblLeftProp.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblLeftProp.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblLeftProp.gridx = 0; //X coordinate of the JLabel.
		gbc_lblLeftProp.gridy = 5; //Y coordinate of the JLabel.
		panelCenter.add(lblLeftProp, gbc_lblLeftProp); //Add the label and it's constraints to panelCenter.
		
		textFieldLeftProp = new JTextField(); //Create a new JTextField.
		textFieldLeftProp.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldLeftProp = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldLeftProp.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldLeftProp.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldLeftProp.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldLeftProp.gridy = 5; //Y coordinate of the JTextField.
		panelCenter.add(textFieldLeftProp, gbc_textFieldLeftProp); //Add the text field and it's constraints to panelCenter.
		
		textFieldLeftPropID = new JTextField(); //Create a new JTextField.
		textFieldLeftPropID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldLeftPropID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldLeftPropID.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldLeftPropID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldLeftPropID.gridx = 2; //X coordinate of the JTextField.
		gbc_textFieldLeftPropID.gridy = 5; //Y coordinate of the JTextField.
		panelCenter.add(textFieldLeftPropID, gbc_textFieldLeftPropID); //Add the text field and it's constraints to panelCenter.

		
		JLabel lblInnerCentre = new JLabel("Inner Centre:"); //Create a new JLabel and give it text to display.
		lblInnerCentre.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblInnerCentre = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblInnerCentre.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblInnerCentre.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblInnerCentre.gridx = 5; //X coordinate of the JLabel.
		gbc_lblInnerCentre.gridy = 5; //Y coordinate of the JLabel.
		panelCenter.add(lblInnerCentre, gbc_lblInnerCentre); //Add the label and it's constraints to panelCenter.
		
		textFieldInnerCentre = new JTextField(); //Create a new JTextField.
		textFieldInnerCentre.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldInnerCentre = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldInnerCentre.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldInnerCentre.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldInnerCentre.gridx = 6; //X coordinate of the JTextField.
		gbc_textFieldInnerCentre.gridy = 5; //Y coordinate of the JTextField.
		panelCenter.add(textFieldInnerCentre, gbc_textFieldInnerCentre); //Add the text field and it's constraints to panelCenter.

		textFieldInnerCentreID = new JTextField(); //Create a new JTextField.
		textFieldInnerCentreID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldInnerCentreID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldInnerCentreID.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldInnerCentreID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldInnerCentreID.gridx = 7; //X coordinate of the JTextField.
		gbc_textFieldInnerCentreID.gridy = 5; //Y coordinate of the JTextField.
		panelCenter.add(textFieldInnerCentreID, gbc_textFieldInnerCentreID); //Add the text field and it's constraints to panelCenter.
		
		/*Row 7*/
		JLabel lblRightProp = new JLabel("Right Prop:"); //Create a new JLabel and give it text to display.
		lblRightProp.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblRightProp = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblRightProp.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblRightProp.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblRightProp.gridx = 0; //X coordinate of the JLabel.
		gbc_lblRightProp.gridy = 6; //Y coordinate of the JLabel.
		panelCenter.add(lblRightProp, gbc_lblRightProp); //Add the label and it's constraints to panelCenter.
		
		textFieldRightProp = new JTextField(); //Create a new JTextField.
		textFieldRightProp.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldRightProp = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldRightProp.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldRightProp.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldRightProp.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldRightProp.gridy = 6; //Y coordinate of the JTextField.
		panelCenter.add(textFieldRightProp, gbc_textFieldRightProp); //Add the text field and it's constraints to panelCenter.
		
		textFieldRightPropID = new JTextField(); //Create a new JTextField.
		textFieldRightPropID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldRightPropID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldRightPropID.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldRightPropID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldRightPropID.gridx = 2; //X coordinate of the JTextField.
		gbc_textFieldRightPropID.gridy = 6; //Y coordinate of the JTextField.
		panelCenter.add(textFieldRightPropID, gbc_textFieldRightPropID); //Add the text field and it's constraints to panelCenter.

		
		JLabel lblOuterCentre = new JLabel("Outer Centre:"); //Create a new JLabel and give it text to display.
		lblOuterCentre.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblOuterCentre = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblOuterCentre.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblOuterCentre.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblOuterCentre.gridx = 5; //X coordinate of the JLabel.
		gbc_lblOuterCentre.gridy = 6; //Y coordinate of the JLabel.
		panelCenter.add(lblOuterCentre, gbc_lblOuterCentre); //Add the label and it's constraints to panelCenter.
		
		textFieldOuterCentre = new JTextField(); //Create a new JTextField.
		textFieldOuterCentre.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldOuterCentre = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldOuterCentre.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldOuterCentre.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldOuterCentre.gridx = 6; //X coordinate of the JTextField.
		gbc_textFieldOuterCentre.gridy = 6; //Y coordinate of the JTextField.
		panelCenter.add(textFieldOuterCentre, gbc_textFieldOuterCentre); //Add the text field and it's constraints to panelCenter.

		textFieldOuterCentreID = new JTextField(); //Create a new JTextField.
		textFieldOuterCentreID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldOuterCentreID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldOuterCentreID.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldOuterCentreID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldOuterCentreID.gridx = 7; //X coordinate of the JTextField.
		gbc_textFieldOuterCentreID.gridy = 6; //Y coordinate of the JTextField.
		panelCenter.add(textFieldOuterCentreID, gbc_textFieldOuterCentreID); //Add the text field and it's constraints to panelCenter.
		
		/*Row 8*/
		JLabel lblLeftLock = new JLabel("Left Lock:"); //Create a new JLabel and give it text to display.
		lblLeftLock.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblLeftLock = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblLeftLock.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen. 
		gbc_lblLeftLock.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblLeftLock.gridx = 0; //X coordinate of the JLabel.
		gbc_lblLeftLock.gridy = 7; //Y coordinate of the JLabel.
		panelCenter.add(lblLeftLock, gbc_lblLeftLock); //Add the label and it's constraints to panelCenter.
		
		textFieldLeftLock = new JTextField(); //Create a new JTextField.
		textFieldLeftLock.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldLeftLock = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldLeftLock.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldLeftLock.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldLeftLock.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldLeftLock.gridy = 7; //Y coordinate of the JTextField.
		panelCenter.add(textFieldLeftLock, gbc_textFieldLeftLock); //Add the text field and it's constraints to panelCenter.
		
		textFieldLeftLockID = new JTextField(); //Create a new JTextField.
		textFieldLeftLockID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldLeftLockID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldLeftLockID.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldLeftLockID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldLeftLockID.gridx = 2; //X coordinate of the JTextField.
		gbc_textFieldLeftLockID.gridy = 7; //Y coordinate of the JTextField.
		panelCenter.add(textFieldLeftLockID, gbc_textFieldLeftLockID); //Add the text field and it's constraints to panelCenter.

		
		JLabel lblLeftWing = new JLabel("Left Wing:"); //Create a new JLabel and give it text to display.
		lblLeftWing.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblLeftWing = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblLeftWing.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblLeftWing.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblLeftWing.gridx = 5; //X coordinate of the JLabel.
		gbc_lblLeftWing.gridy = 7; //Y coordinate of the JLabel.
		panelCenter.add(lblLeftWing, gbc_lblLeftWing); //Add the label and it's constraints to panelCenter.
		
		textFieldLeftWing = new JTextField(); //Create a new JTextField.
		textFieldLeftWing.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldLeftWing = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldLeftWing.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldLeftWing.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldLeftWing.gridx = 6; //X coordinate of the JTextField.
		gbc_textFieldLeftWing.gridy = 7; //Y coordinate of the JTextField.
		panelCenter.add(textFieldLeftWing, gbc_textFieldLeftWing); //Add the text field and it's constraints to panelCenter.
		
		textFieldLeftWingID = new JTextField(); //Create a new JTextField.
		textFieldLeftWingID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldLeftWingID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldLeftWingID.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldLeftWingID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldLeftWingID.gridx = 7; //X coordinate of the JTextField.
		gbc_textFieldLeftWingID.gridy = 7; //Y coordinate of the JTextField.
		panelCenter.add(textFieldLeftWingID, gbc_textFieldLeftWingID); //Add the text field and it's constraints to panelCenter.
		
		/*Row 9*/
		JLabel lblRightLock = new JLabel("Right Lock:"); //Create a new JLabel and give it text to display.
		lblRightLock.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblRightLock = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblRightLock.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblRightLock.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblRightLock.gridx = 0; //X coordinate of the JLabel.
		gbc_lblRightLock.gridy = 8; //Y coordinate of the JLabel.
		panelCenter.add(lblRightLock, gbc_lblRightLock); //Add the label and it's constraints to panelCenter.
		
		textFieldRightLock = new JTextField(); //Create a new JTextField.
		textFieldRightLock.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldRightLock = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldRightLock.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldRightLock.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldRightLock.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldRightLock.gridy = 8; //Y coordinate of the JTextField.
		panelCenter.add(textFieldRightLock, gbc_textFieldRightLock); //Add the text field and it's constraints to panelCenter.
		
		textFieldRightLockID = new JTextField(); //Create a new JTextField.
		textFieldRightLockID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldRightLockID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldRightLockID.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldRightLockID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldRightLockID.gridx = 2; //X coordinate of the JTextField.
		gbc_textFieldRightLockID.gridy = 8; //Y coordinate of the JTextField.
		panelCenter.add(textFieldRightLockID, gbc_textFieldRightLockID); //Add the text field and it's constraints to panelCenter.
		
		
		JLabel lblRightWing = new JLabel("Right Wing:"); //Create a new JLabel and give it text to display.
		lblRightWing.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblRightWing = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblRightWing.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblRightWing.insets = new Insets(20, 50, 20, 5); //padding up, padding left, padding down, padding right
		gbc_lblRightWing.gridx = 5; //X coordinate of the JLabel
		gbc_lblRightWing.gridy = 8; //Y coordinate of the JLabel.
		panelCenter.add(lblRightWing, gbc_lblRightWing); //Add the label and it's constraints to panelCenter.
		
		textFieldRightWing = new JTextField(); //Create a new JTextField.
		textFieldRightWing.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldRightWing = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldRightWing.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldRightWing.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldRightWing.gridx = 6; //X coordinate of the JTextField.
		gbc_textFieldRightWing.gridy = 8; //Y coordinate of the JTextField.
		panelCenter.add(textFieldRightWing, gbc_textFieldRightWing); //Add the text field and it's constraints to panelCenter.
		
		textFieldRightWingID = new JTextField(); //Create a new JTextField.
		textFieldRightWingID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldRightWingID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldRightWingID.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldRightWingID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldRightWingID.gridx = 7; //X coordinate of the JTextField.
		gbc_textFieldRightWingID.gridy = 8; //Y coordinate of the JTextField.
		panelCenter.add(textFieldRightWingID, gbc_textFieldRightWingID); //Add the text field and it's constraints to panelCenter.
		
		/*Row 10*/
		JLabel lblLeftFlanker = new JLabel("Left Flanker:"); //Create a new JLabel and give it text to display.
		lblLeftFlanker.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblLeftFlanker = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblLeftFlanker.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblLeftFlanker.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblLeftFlanker.gridx = 0; //X coordinate of the JLabel.
		gbc_lblLeftFlanker.gridy = 9; //Y coordinate of the JLabel.
		panelCenter.add(lblLeftFlanker, gbc_lblLeftFlanker); //Add the label and it's constraints to panelCenter.
		 
		textFieldLeftFlanker = new JTextField(); //Create a new JTextField.
		textFieldLeftFlanker.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldLeftFlanker = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldLeftFlanker.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldLeftFlanker.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldLeftFlanker.gridx = 1; //X coordinate of the JTextField.
		gbc_textFieldLeftFlanker.gridy = 9; //Y coordinate of the JTextField.
		panelCenter.add(textFieldLeftFlanker, gbc_textFieldLeftFlanker); //Add the text field and it's constraints to panelCenter.
		
		textFieldLeftFlankerID = new JTextField(); //Create a new JTextField.
		textFieldLeftFlankerID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldLeftFlankerID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldLeftFlankerID.insets = new Insets(20, 0, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldLeftFlankerID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldLeftFlankerID.gridx = 2; //X coordinate of the JTextField.
		gbc_textFieldLeftFlankerID.gridy = 9; //Y coordinate of the JTextField.
		panelCenter.add(textFieldLeftFlankerID, gbc_textFieldLeftFlankerID); //Add the text field and it's constraints to panelCenter.
		
		
		JLabel lblFullBack = new JLabel("Full Back:"); //Create a new JLabel and give it text to display.
		lblFullBack.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblFullBack = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblFullBack.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblFullBack.insets = new Insets(20, 50, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblFullBack.gridx = 5; //X coordinate of the JLabel.
		gbc_lblFullBack.gridy = 9; //Y coordinate of the JLabel.
		panelCenter.add(lblFullBack, gbc_lblFullBack); //Add the label and it's constraints to panelCenter.
		
		textFieldFullBack = new JTextField(); //Create a new JTextField.
		textFieldFullBack.setEditable(false); //Make the JTextField uneditable by the user.
		GridBagConstraints gbc_textFieldFullBack = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldFullBack.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldFullBack.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldFullBack.gridx = 6; //X coordinate of the JTextField.
		gbc_textFieldFullBack.gridy = 9; //Y coordinate of the JTextField.
		panelCenter.add(textFieldFullBack, gbc_textFieldFullBack); //Add the text field and it's constraints to panelCenter.
		
		textFieldFullBackID = new JTextField(); //Create a new JTextField.
		textFieldFullBackID.setToolTipText("Enter Profile ID"); //JTextField will display the ToolTip text when hovered over by user.
		GridBagConstraints gbc_textFieldFullBackID = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldFullBackID.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldFullBackID.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldFullBackID.gridx = 7; //X coordinate of the JTextField.
		gbc_textFieldFullBackID.gridy = 9; //Y coordinate of the JTextField.
		panelCenter.add(textFieldFullBackID, gbc_textFieldFullBackID); //Add the text field and it's constraints to panelCenter.
		
		
		/*-------------------------Bottom Buttons------------------*/
			
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
		
		JButton btnDeleteSquad = new JButton("Delete Squad"); //Create a new JButton and give it text to display. This button will trigger the deletion of the squad.
		btnDeleteSquad.setBackground(Color.RED); //Give the button a red background.
		btnDeleteSquad.setFont(new Font("Tahoma", Font.BOLD, 16)); //Font of the button.
		btnDeleteSquad.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
		btnDeleteSquad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		panelSouth.add(btnDeleteSquad); //Add button to panelSouth.
		
		btnDeleteSquad.addActionListener(new ActionListener() { //When button is clicked...
			public void actionPerformed(ActionEvent e) {
				
				//Confirm squad deletion dialogue box.
				int a = JOptionPane.showConfirmDialog(contentPane, "Are you sure you wish to delete this squad?", "Warning!", JOptionPane.YES_NO_OPTION);
				
				if(a==JOptionPane.YES_OPTION) { //If the user confirms squad deletion...
					
					myController.deleteSquad(); //Call function to delete the squad.
					dispose(); //Get rid of this screen.
				}
			}
		});
		
		panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
		JButton btnSave = new JButton("Save"); //Create a new JButton and give it text to display. This button will save changes to the squad and reload the page to display new information.
		btnSave.setBackground(new Color(50, 205, 50)); //Give the button a green background.
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of button.
		btnSave.setFocusable(false);  //Get rid of weird square around text of the button when hovered over.
		panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		panelSouth.add(btnSave); //Add button to panelSouth.
		
		btnSave.addActionListener(new ActionListener() { //When button is clicked...
			public void actionPerformed(ActionEvent e) {
				
				myController.saveSquad(); //Call function to save the details of the currently viewed squad and reload the page so they can be displayed.

			}
		});
		
		panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
	}

	//Setters for non ID text fields
	
	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldSquadName which holds the name of the squad.
	 */
	public void setTextFieldSquadName(String textFieldSquadName) {
		this.textFieldSquadName.setText(textFieldSquadName);
	}
	
	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldCoach1 which holds the name of the first coach in the squad.
	 */
	public void setTextFieldCoach1(String textFieldCoach1) {
		this.textFieldCoach1.setText(textFieldCoach1);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldCoach2 which holds the name of the second coach in the squad.
	 */
	public void setTextFieldCoach2(String textFieldCoach2) {
		this.textFieldCoach2.setText(textFieldCoach2);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldCoach3 which holds the name of the third coach in the squad.
	 */
	public void setTextFieldCoach3(String textFieldCoach3) {
		this.textFieldCoach3.setText(textFieldCoach3);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldNumberEight which holds the name of the player in the Number Eight position.
	 */
	public void setTextFieldNumberEight(String textFieldNumberEight) {
		this.textFieldNumberEight.setText(textFieldNumberEight);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldRightFlanker which holds the name of the player in the Right Flanker position.
	 */
	public void setTextFieldRightFlanker(String textFieldRightFlanker) {
		this.textFieldRightFlanker.setText(textFieldRightFlanker);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldScrumHalf which holds the name of the player in the Scrum Half position.
	 */
	public void setTextFieldScrumHalf(String textFieldScrumHalf) {
		this.textFieldScrumHalf.setText(textFieldScrumHalf);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldHooker which holds the name of the player in the Hooker position.
	 */
	public void setTextFieldHooker(String textFieldHooker) {
		this.textFieldHooker.setText(textFieldHooker);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldRightProp which holds the name of the player in the Right Prop position.
	 */
	public void setTextFieldRightProp(String textFieldRightProp) {
		this.textFieldRightProp.setText(textFieldRightProp);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldLeftLock which holds the name of the player in the Left Lock position.
	 */
	public void setTextFieldLeftLock(String textFieldLeftLock) {
		this.textFieldLeftLock.setText(textFieldLeftLock);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldFlyHalf which holds the name of the player in the Fly Half position.
	 */
	public void setTextFieldFlyHalf(String textFieldFlyHalf) {
		this.textFieldFlyHalf.setText(textFieldFlyHalf);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldOuterCentre which holds the name of the player in the Outer Centre position.
	 */
	public void setTextFieldOuterCentre(String textFieldOuterCentre) {
		this.textFieldOuterCentre.setText(textFieldOuterCentre);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldLeftWing which holds the name of the player in the Left Wing position.
	 */
	public void setTextFieldLeftWing(String textFieldLeftWing) {
		this.textFieldLeftWing.setText(textFieldLeftWing);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldInnerCentre which holds the name of the player in the Inner Centre position.
	 */
	public void setTextFieldInnerCentre(String textFieldInnerCentre) {
		this.textFieldInnerCentre.setText(textFieldInnerCentre);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldLeftProp which holds the name of the player in the Left Prop position.
	 */
	public void setTextFieldLeftProp(String textFieldLeftProp) {
		this.textFieldLeftProp.setText(textFieldLeftProp);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldRightLock which holds the name of the player in the Right Lock position.
	 */
	public void setTextFieldRightLock(String textFieldRightLock) {
		this.textFieldRightLock.setText(textFieldRightLock);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldRightWing which holds the name of the player in the Right Wing position.
	 */
	public void setTextFieldRightWing(String textFieldRightWing) {
		this.textFieldRightWing.setText(textFieldRightWing);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldLeftFlanker which holds the name of the player in the Left Flanker position.
	 */
	public void setTextFieldLeftFlanker(String textFieldLeftFlanker) {
		this.textFieldLeftFlanker.setText(textFieldLeftFlanker);
	}

	/**
	 * Setter for the EditSquadScreen class.
	 * @param textFieldFullBack which holds the name of the player in the Full Back position.
	 */
	public void setTextFieldFullBack(String textFieldFullBack) {
		this.textFieldFullBack.setText(textFieldFullBack);
	}
	
	//Getters for ID text fields and Squad Name
	
	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldSquadName which holds the name of the squad.
	 */
	public JTextField getTextFieldSquadName() {
		return textFieldSquadName;
	}
	
	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldCoach1ID which holds the ID of the first coach in the squad.
	 */
	public JTextField getTextFieldCoach1ID() {
		return textFieldCoach1ID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldCoach2ID which holds the ID of the second coach in the squad.
	 */
	public JTextField getTextFieldCoach2ID() {
		return textFieldCoach2ID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldCoach3ID which holds the ID of the third coach in the squad.
	 */
	public JTextField getTextFieldCoach3ID() {
		return textFieldCoach3ID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldHookerID which holds the ID of the player in the Hooker position.
	 */
	public JTextField getTextFieldHookerID() {
		return textFieldHookerID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldLeftPropID which holds the ID of the player in the Left Prop position.
	 */
	public JTextField getTextFieldLeftPropID() {
		return textFieldLeftPropID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldRightPropID which holds the ID of the player in the Right Prop position.
	 */
	public JTextField getTextFieldRightPropID() {
		return textFieldRightPropID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldLeftLockID which holds the ID of the player in the Left Lock position.
	 */
	public JTextField getTextFieldLeftLockID() {
		return textFieldLeftLockID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldRightLockID which holds the ID of the player in the Right Lock position.
	 */
	public JTextField getTextFieldRightLockID() {
		return textFieldRightLockID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldLeftFlankerID which holds the ID of the player in the Left Flanker position.
	 */
	public JTextField getTextFieldLeftFlankerID() {
		return textFieldLeftFlankerID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldRightFlankerID which holds the ID of the player in the Right Flanker position.
	 */
	public JTextField getTextFieldRightFlankerID() {
		return textFieldRightFlankerID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldNumberEightID which holds the ID of the player in the Number Eight position.
	 */
	public JTextField getTextFieldNumberEightID() {
		return textFieldNumberEightID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldScrumHalfID which holds the ID of the player in the Scrum Half position.
	 */
	public JTextField getTextFieldScrumHalfID() {
		return textFieldScrumHalfID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldFlyHalfID which holds the ID of the player in the Fly Half position.
	 */
	public JTextField getTextFieldFlyHalfID() {
		return textFieldFlyHalfID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldInnerCentreID which holds the ID of the player in the Inner Centre position.
	 */
	public JTextField getTextFieldInnerCentreID() {
		return textFieldInnerCentreID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldOuterCentreID which holds the ID of the player in the Outer Centre position.
	 */
	public JTextField getTextFieldOuterCentreID() {
		return textFieldOuterCentreID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldLeftWingID which holds the ID of the player in the Left Wing position.
	 */
	public JTextField getTextFieldLeftWingID() {
		return textFieldLeftWingID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldRightWingID which holds the ID of the player in the Right Wing position.
	 */
	public JTextField getTextFieldRightWingID() {
		return textFieldRightWingID;
	}

	/**
	 * Getter for the EditSquadScreen class.
	 * @return textFieldFullBackID which holds the ID of the player in the Full Back position.
	 */
	public JTextField getTextFieldFullBackID() {
		return textFieldFullBackID;
	}


}
