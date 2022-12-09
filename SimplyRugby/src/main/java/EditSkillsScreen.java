import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;

/**
 * This class is responsible for the graphical interface of the edit skills screen.
 * This page is only accessible by coaches.
 * There are a number of combo boxes that allow the coach to grade the player's skills on a scale of 1 to 5.
 * There are also a number of text fields that the coach can edit to give additional information about the player's health or skills.
 * All these changes can be permanently saved.
 * This class inherits from JFrame.
 *@author Renat Oosthuizen
 *@since 13/05/2021
 */
@SuppressWarnings("serial")
public class EditSkillsScreen extends JFrame {

	/**EditSkillsController variable that performs all the logic for this screen.*/
	private EditSkillsController myController;
	
	
	/**Holds the name of the player.*/
	private JTextField textFieldPlayerName;
	/**Holds a String array of squad positions and is used to display the player's preferred position.*/
	private JComboBox<String[]> comboBoxPreferredPosition;
	/**Hold a String comment on the player's health.*/
	private JTextArea textFieldHealthComment;
	
	
	/**Hold a String comment on the player's Passing skill.*/
	private JTextArea textFieldPassingComment;
	/**Hold a String comment on the player's Tackling skill.*/
	private JTextArea textFieldTacklingComment;
	/**Hold a String comment on the player's Kicking skill.*/
	private JTextArea textFieldKickingComment;
	
	
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Goal skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxGoal;
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Standard skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxStandard;
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Spin skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxSpin;
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Pop skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxPop;
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Front skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxFront;
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Rear skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxRear;
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Side skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxSide;
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Scrabble skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxScrabble;
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Drop skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxDrop;
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Punt skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxPunt;
	/**Holds an integer array of numbers from 1 to 5 and is used to display the player's Grubber skill on a scale of 1 to 5.*/
	private JComboBox<int[]> comboBoxGrubber;

	/**
	 * Parameterised constructor for the class. It accepts it's own controller class in order to create data binding between the two classes.
	 * @param control is the controller for this View Screen.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EditSkillsScreen(EditSkillsController control) {
		
		myController = control; //Assign myController as an instance of EditSkillsController.
		
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
		GridBagLayout gbl_panelCenter = new GridBagLayout(); //Create a new GridBagLayout.
		gbl_panelCenter.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE}; //Give the layout column weights.
		gbl_panelCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE}; //Give the layout row weights.
		panelCenter.setLayout(gbl_panelCenter); //Add the layout to panelCentre.
		
		/*Row 1*/
		JLabel lblPlayerName = new JLabel("Player Name:"); //Create a new JLabel and give it text to display.
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblPlayerName = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblPlayerName.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblPlayerName.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblPlayerName.gridx = 0; //X coordinate of the JLabel.
		gbc_lblPlayerName.gridy = 0; //Y coordinate of the JLabel.
		panelCenter.add(lblPlayerName, gbc_lblPlayerName); //Add the label and it's constraints to panelCenter.
		
		textFieldPlayerName = new JTextField(); //Create a new JTextField.
		textFieldPlayerName.setEditable(false); //Make the JTextField uneditable.
		GridBagConstraints gbc_textFieldPlayerName = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldPlayerName.insets = new Insets(20, 0, 20, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldPlayerName.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textFieldPlayerName.gridwidth = 2; //Make the JTextField have a width of 2 cells.
		gbc_textFieldPlayerName.gridx = 2; //X coordinate of the JTextField.
		gbc_textFieldPlayerName.gridy = 0; //Y coordinate of the JTextField.
		panelCenter.add(textFieldPlayerName, gbc_textFieldPlayerName); //Add the text field and it's constraints to panelCenter.
		
		
		JLabel lblPreferredPosition = new JLabel("Preferred Position:"); //Create a new JLabel and give it text to display.
		lblPreferredPosition.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblPreferredPosition = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblPreferredPosition.insets = new Insets(20, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblPreferredPosition.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblPreferredPosition.gridx = 4; //X coordinate of the JLabel.
		gbc_lblPreferredPosition.gridy = 0; //Y coordinate of the JLabel.
		panelCenter.add(lblPreferredPosition, gbc_lblPreferredPosition); //Add the label and it's constraints to panelCenter.
		
		comboBoxPreferredPosition = new JComboBox(); //Create a new JComboBox.
		comboBoxPreferredPosition.setModel(new DefaultComboBoxModel(new String[] {"Full Back", "Wing", "Centre", "Fly Half", "Scrum Half", "Hooker", "Prop", "2nd Row", "Back Row"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxPreferredPosition = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxPreferredPosition.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxPreferredPosition.fill = GridBagConstraints.HORIZONTAL; //Allow the JComboBox to be resized horizontally.
		gbc_comboBoxPreferredPosition.gridx = 5; //X coordinate of the JComboBox.
		gbc_comboBoxPreferredPosition.gridy = 0; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxPreferredPosition, gbc_comboBoxPreferredPosition); //Add the JComboBox and it's constraints to panelCenter.
		
		
		/*Row 2*/
		JLabel lblHealthComment = new JLabel("Health Comment:"); //Create a new JLabel and give it text to display.
		lblHealthComment.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblHealthComment = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblHealthComment.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblHealthComment.insets = new Insets(20, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblHealthComment.gridx = 0; //X coordinate of the JLabel.
		gbc_lblHealthComment.gridy = 1; //Y coordinate of the JLabel.
		panelCenter.add(lblHealthComment, gbc_lblHealthComment); //Add the label and it's constraints to panelCenter.
		
		textFieldHealthComment = new JTextArea(); //Create a new JTextArea which is a multi-line text field.
		GridBagConstraints gbc_textFieldHealthComment = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldHealthComment.insets = new Insets(20, 0, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldHealthComment.gridwidth = 5; //Make the text field have a width of 5 cells.
		gbc_textFieldHealthComment.fill = GridBagConstraints.HORIZONTAL; //Make the JTextArea scale both horizontally.
		gbc_textFieldHealthComment.gridx = 1; //X coordinate of the JTextArea.
		gbc_textFieldHealthComment.gridy = 1; //Y coordinate of the JTextArea.
		panelCenter.add(textFieldHealthComment, gbc_textFieldHealthComment); //Add the JTextArea and it's constraints to panelCenter.
		
		/*Table Headers*/
		JLabel lblCategory = new JLabel("Category"); //Create a new JLabel and give it text to display.
		lblCategory.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER); //Centre the JLabel text.
		lblCategory.setBackground(SystemColor.activeCaption); //Give the JLabel a light blue background.
		lblCategory.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblCategory = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblCategory.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblCategory.insets = new Insets(0, 100, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblCategory.gridwidth = 2; //Make the label have a width of 2 cells.
		gbc_lblCategory.gridx = 0; //X coordinate of the JLabel.
		gbc_lblCategory.gridy = 2; //Y coordinate of the JLabel.
		panelCenter.add(lblCategory, gbc_lblCategory); //Add the label and it's constraints to panelCenter.
		
		JLabel lblSkill = new JLabel("Skill"); //Create a new JLabel and give it text to display.
		lblSkill.setBorder(new MatteBorder(5, 0, 5, 5, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblSkill.setHorizontalAlignment(SwingConstants.CENTER); //Centre the JLabel text.
		lblSkill.setBackground(SystemColor.activeCaption); //Give the JLabel a light blue background.
		lblSkill.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblSkill.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel
		GridBagConstraints gbc_lblSkill = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblSkill.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblSkill.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblSkill.gridwidth = 2; //Make the label have a width of 2 cells.
		gbc_lblSkill.gridx = 2; //X coordinate of the JLabel.
		gbc_lblSkill.gridy = 2; //Y coordinate of the JLabel.
		panelCenter.add(lblSkill, gbc_lblSkill); //Add the label and it's constraints to panelCenter.
		
		JLabel lblComments = new JLabel("Comments"); //Create a new JLabel and give it text to display.
		lblComments.setBorder(new MatteBorder(5, 0, 5, 5, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblComments.setHorizontalAlignment(SwingConstants.CENTER); //Centre the JLabel text.
		lblComments.setBackground(SystemColor.activeCaption); //Give the JLabel a light blue background.
		lblComments.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblComments.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblComments = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblComments.insets = new Insets(0, 0, 0, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblComments.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblComments.gridwidth = 2; //Make the label have a width of 2 cells.
		gbc_lblComments.gridx = 4; //X coordinate of the JLabel.
		gbc_lblComments.gridy = 2; //Y coordinate of the JLabel.
		panelCenter.add(lblComments, gbc_lblComments); //Add the label and it's constraints to panelCenter.
		
		
		/*First 3 Table Rows*/
		JLabel lblPassing = new JLabel("Passing"); //Create a new JLabel and give it text to display.
		lblPassing.setBorder(new MatteBorder(0, 5, 5, 5, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblPassing.setHorizontalAlignment(SwingConstants.CENTER); //Centre the JLabel text.
		lblPassing.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblPassing.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblPassing.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblPassing = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblPassing.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblPassing.insets = new Insets(0, 100, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblPassing.gridwidth = 2; //Make the label have a width of 2 cells
		gbc_lblPassing.gridheight = 3; //Make the label have a height of 3 cells
		gbc_lblPassing.gridx = 0; //X coordinate of the JLabel.
		gbc_lblPassing.gridy = 3; //Y coordinate of the JLabel.
		panelCenter.add(lblPassing, gbc_lblPassing); //Add the label and it's constraints to panelCenter.
		
		
		JLabel lblStandard = new JLabel("Standard:"); //Create a new JLabel and give it text to display.
		lblStandard.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblStandard.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblStandard.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblStandard.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblStandard.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblStandard = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblStandard.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblStandard.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblStandard.gridx = 2; //X coordinate of the JLabel.
		gbc_lblStandard.gridy = 3; //Y coordinate of the JLabel.
		panelCenter.add(lblStandard, gbc_lblStandard); //Add the label and it's constraints to panelCenter.
		
		comboBoxStandard = new JComboBox(); //Create a new JComboBox.
		comboBoxStandard.setBorder(new MatteBorder(0, 0, 2, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxStandard.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxStandard = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxStandard.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxStandard.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxStandard.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxStandard.gridy = 3; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxStandard, gbc_comboBoxStandard); //Add the JComboBox and it's constraints to panelCenter.
		
		
		JLabel lblSpin = new JLabel("Spin:"); //Create a new JLabel and give it text to display.
		lblSpin.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblSpin.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblSpin.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblSpin.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblSpin.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblSpin = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblSpin.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblSpin.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblSpin.gridx = 2; //X coordinate of the JLabel.
		gbc_lblSpin.gridy = 4; //Y coordinate of the JLabel.
		panelCenter.add(lblSpin, gbc_lblSpin); //Add the label and it's constraints to panelCenter.
		
		comboBoxSpin = new JComboBox(); //Create a new JComboBox.
		comboBoxSpin.setBorder(new MatteBorder(0, 0, 2, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxSpin.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxSpin = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxSpin.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxSpin.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxSpin.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxSpin.gridy = 4; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxSpin, gbc_comboBoxSpin); //Add the JComboBox and it's constraints to panelCenter.
		
		
		JLabel lblPop = new JLabel("Pop:"); //Create a new JLabel and give it text to display.
		lblPop.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblPop.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblPop.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblPop.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblPop.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblPop = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblPop.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblPop.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblPop.gridx = 2; //X coordinate of the JLabel.
		gbc_lblPop.gridy = 5; //Y coordinate of the JLabel.
		panelCenter.add(lblPop, gbc_lblPop); //Add the label and it's constraints to panelCenter.
		
		comboBoxPop = new JComboBox(); //Create a new JComboBox.
		comboBoxPop.setBorder(new MatteBorder(0, 0, 5, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxPop.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxPop = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxPop.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxPop.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxPop.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxPop.gridy = 5; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxPop, gbc_comboBoxPop); //Add the JComboBox and it's constraints to panelCenter.
		
		
		textFieldPassingComment = new JTextArea(); //Create a new JTextArea which is a multi-line text field.
		textFieldPassingComment.setBorder(new MatteBorder(0, 0, 5, 5, (Color) new Color(0, 0, 0))); //Give the JTextArea a black border with specified dimensions on each side (pixels).
		textFieldPassingComment.setLineWrap(true); //Text will jump down a line once it reached the end of the text area.
		GridBagConstraints gbc_textFieldPassingComment = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldPassingComment.insets = new Insets(0, 0, 0, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldPassingComment.fill = GridBagConstraints.BOTH; //Make the JTextArea scale both horizontally and vertically.
		gbc_textFieldPassingComment.gridwidth = 2; //Make the text field have a width of 2 cells.
		gbc_textFieldPassingComment.gridheight = 3; //Make the text field have a height of 3 cells.
		gbc_textFieldPassingComment.gridx = 4; //X coordinate of the JTextArea.
		gbc_textFieldPassingComment.gridy = 3; //Y coordinate of the JTextArea.
		panelCenter.add(textFieldPassingComment, gbc_textFieldPassingComment); //Add the JTextArea and it's constraints to panelCenter.
		
		/*Next 4 Table Rows*/
		JLabel lblTackling = new JLabel("Tackling"); //Create a new JLabel and give it text to display.
		lblTackling.setBorder(new MatteBorder(0, 5, 5, 5, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblTackling.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblTackling.setHorizontalAlignment(SwingConstants.CENTER); //Centre the JLabel text.
		lblTackling.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblTackling.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblTackling = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblTackling.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblTackling.insets = new Insets(0, 100, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblTackling.gridwidth = 2; //Make the label have a width of 2 cells.
		gbc_lblTackling.gridheight = 4; //Make the label have a height of 4 cells.
		gbc_lblTackling.gridx = 0; //X coordinate of the JLabel.
		gbc_lblTackling.gridy = 6; //Y coordinate of the JLabel.
		panelCenter.add(lblTackling, gbc_lblTackling); //Add the label and it's constraints to panelCenter.
		
		
		JLabel lblFront = new JLabel("Front:"); //Create a new JLabel and give it text to display.
		lblFront.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblFront.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblFront.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblFront.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblFront.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblFront = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblFront.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblFront.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblFront.gridx = 2; //X coordinate of the JLabel.
		gbc_lblFront.gridy = 6; //Y coordinate of the JLabel.
		panelCenter.add(lblFront, gbc_lblFront); //Add the label and it's constraints to panelCenter.
		
		comboBoxFront = new JComboBox(); //Create a new JComboBox.
		comboBoxFront.setBorder(new MatteBorder(0, 0, 2, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxFront.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxFront = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxFront.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxFront.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxFront.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxFront.gridy = 6; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxFront, gbc_comboBoxFront); //Add the JComboBox and it's constraints to panelCenter.
		
		
		JLabel lblRear = new JLabel("Rear:"); //Create a new JLabel and give it text to display.
		lblRear.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblRear.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblRear.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblRear.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblRear.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblRear = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblRear.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblRear.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblRear.gridx = 2; //X coordinate of the JLabel.
		gbc_lblRear.gridy = 7; //Y coordinate of the JLabel.
		panelCenter.add(lblRear, gbc_lblRear); //Add the label and it's constraints to panelCenter.
		
		comboBoxRear = new JComboBox(); //Create a new JComboBox.
		comboBoxRear.setBorder(new MatteBorder(0, 0, 2, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxRear.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxRear = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxRear.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxRear.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxRear.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxRear.gridy = 7; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxRear, gbc_comboBoxRear); //Add the JComboBox and it's constraints to panelCenter.
		
		
		JLabel lblSide = new JLabel("Side:"); //Create a new JLabel and give it text to display.
		lblSide.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));//Give the JLabel a black border with specified dimensions on each side (pixels).
		lblSide.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblSide.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblSide.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblSide.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblSide = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblSide.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblSide.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblSide.gridx = 2; //X coordinate of the JLabel.
		gbc_lblSide.gridy = 8; //Y coordinate of the JLabel.
		panelCenter.add(lblSide, gbc_lblSide); //Add the label and it's constraints to panelCenter.
		
		comboBoxSide = new JComboBox(); //Create a new JComboBox.
		comboBoxSide.setBorder(new MatteBorder(0, 0, 2, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxSide.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxSide = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxSide.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxSide.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxSide.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxSide.gridy = 8; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxSide, gbc_comboBoxSide); //Add the JComboBox and it's constraints to panelCenter.
		
		
		JLabel lblScrabble = new JLabel("Scrabble:"); //Create a new JLabel and give it text to display.
		lblScrabble.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblScrabble.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblScrabble.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblScrabble.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblScrabble.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblScrabble = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblScrabble.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblScrabble.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblScrabble.gridx = 2; //X coordinate of the JLabel.
		gbc_lblScrabble.gridy = 9; //Y coordinate of the JLabel.
		panelCenter.add(lblScrabble, gbc_lblScrabble); //Add the label and it's constraints to panelCenter.
		
		comboBoxScrabble = new JComboBox(); //Create a new JComboBox.
		comboBoxScrabble.setBorder(new MatteBorder(0, 0, 5, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxScrabble.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxScrabble = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxScrabble.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxScrabble.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxScrabble.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxScrabble.gridy = 9; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxScrabble, gbc_comboBoxScrabble); //Add the JComboBox and it's constraints to panelCenter.
		
		
		textFieldTacklingComment = new JTextArea(); //Create a new JTextArea which is a multi-line text field.
		textFieldTacklingComment.setBorder(new MatteBorder(0, 0, 5, 5, (Color) new Color(0, 0, 0))); //Give the JTextArea a black border with specified dimensions on each side (pixels).
		textFieldTacklingComment.setLineWrap(true);//Text will jump down a line once it reached the end of the text area.
		GridBagConstraints gbc_textFieldTacklingComment = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldTacklingComment.insets = new Insets(0, 0, 0, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldTacklingComment.fill = GridBagConstraints.BOTH; //Make the JTextArea scale both horizontally and vertically.
		gbc_textFieldTacklingComment.gridwidth = 2; //Make the text field have a width of 2 cells.
		gbc_textFieldTacklingComment.gridheight = 4; //Make the text field have a height of 4 cells.
		gbc_textFieldTacklingComment.gridx = 4; //X coordinate of the JTextArea.
		gbc_textFieldTacklingComment.gridy = 6; //Y coordinate of the JTextArea.
		panelCenter.add(textFieldTacklingComment, gbc_textFieldTacklingComment); //Add the JTextArea and it's constraints to panelCenter.
		
		/*Last 4 Table Rows*/
		JLabel lblKicking = new JLabel("Kicking"); //Create a new JLabel and give it text to display.
		lblKicking.setBorder(new MatteBorder(0, 5, 5, 5, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblKicking.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblKicking.setHorizontalAlignment(SwingConstants.CENTER); //Centre the JLabel text.
		lblKicking.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblKicking.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the JLabel.
		GridBagConstraints gbc_lblKicking = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblKicking.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblKicking.insets = new Insets(0, 100, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblKicking.gridwidth = 2; //Make the label have a width of 2 cells.
		gbc_lblKicking.gridheight = 4; //Make the label have a height of 4 cells.
		gbc_lblKicking.gridx = 0; //X coordinate of the JLabel.
		gbc_lblKicking.gridy = 10; //Y coordinate of the JLabel.
		panelCenter.add(lblKicking, gbc_lblKicking); //Add the label and it's constraints to panelCenter.
		
		
		JLabel lblDrop = new JLabel("Drop:"); //Create a new JLabel and give it text to display.
		lblDrop.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblDrop.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblDrop.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblDrop.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblDrop.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblDrop = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblDrop.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblDrop.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblDrop.gridx = 2; //X coordinate of the JLabel.
		gbc_lblDrop.gridy = 10; //Y coordinate of the JLabel.
		panelCenter.add(lblDrop, gbc_lblDrop); //Add the label and it's constraints to panelCenter.
		
		comboBoxDrop = new JComboBox(); //Create a new JComboBox.
		comboBoxDrop.setBorder(new MatteBorder(0, 0, 2, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxDrop.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxDrop = new GridBagConstraints();  //Create a new set of GridBagConstraints.
		gbc_comboBoxDrop.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxDrop.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxDrop.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxDrop.gridy = 10; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxDrop, gbc_comboBoxDrop); //Add the JComboBox and it's constraints to panelCenter.
	
		
		JLabel lblPunt = new JLabel("Punt:"); //Create a new JLabel and give it text to display.
		lblPunt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblPunt.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblPunt.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblPunt.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblPunt.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblPunt = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblPunt.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblPunt.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblPunt.gridx = 2; //X coordinate of the JLabel.
		gbc_lblPunt.gridy = 11; //Y coordinate of the JLabel.
		panelCenter.add(lblPunt, gbc_lblPunt); //Add the label and it's constraints to panelCenter.
		
		comboBoxPunt = new JComboBox(); //Create a new JComboBox.
		comboBoxPunt.setBorder(new MatteBorder(0, 0, 2, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxPunt.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxPunt = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxPunt.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxPunt.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxPunt.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxPunt.gridy = 11; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxPunt, gbc_comboBoxPunt); //Add the JComboBox and it's constraints to panelCenter.
		
		
		JLabel lblGrubber = new JLabel("Grubber:"); //Create a new JLabel and give it text to display.
		lblGrubber.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblGrubber.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblGrubber.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblGrubber.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblGrubber.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblGrubber = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblGrubber.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblGrubber.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblGrubber.gridx = 2; //X coordinate of the JLabel.
		gbc_lblGrubber.gridy = 12; //Y coordinate of the JLabel.
		panelCenter.add(lblGrubber, gbc_lblGrubber); //Add the label and it's constraints to panelCenter.
		
		comboBoxGrubber = new JComboBox(); //Create a new JComboBox.
		comboBoxGrubber.setBorder(new MatteBorder(0, 0, 2, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxGrubber.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxGrubber = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxGrubber.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxGrubber.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxGrubber.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxGrubber.gridy = 12; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxGrubber, gbc_comboBoxGrubber); //Add the JComboBox and it's constraints to panelCenter.
		
		
		JLabel lblGoal = new JLabel("Goal:"); //Create a new JLabel and give it text to display.
		lblGoal.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(0, 0, 0))); //Give the JLabel a black border with specified dimensions on each side (pixels).
		lblGoal.setBackground(Color.WHITE); //Give the JLabel a white background.
		lblGoal.setHorizontalAlignment(SwingConstants.RIGHT); //Make the JLabel text attempt to stay on the right side.
		lblGoal.setOpaque(true); //Make JLabel opaque so that the background colour is visible.
		lblGoal.setFont(new Font("Tahoma", Font.BOLD, 11)); //Set font of the JLabel.
		GridBagConstraints gbc_lblGoal = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblGoal.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblGoal.fill = GridBagConstraints.BOTH; //Make the label scale both horizontally and vertically.
		gbc_lblGoal.gridx = 2; //X coordinate of the JLabel.
		gbc_lblGoal.gridy = 13; //Y coordinate of the JLabel.
		panelCenter.add(lblGoal, gbc_lblGoal); //Add the label and it's constraints to panelCenter.
		
		comboBoxGoal = new JComboBox(); //Create a new JComboBox.
		comboBoxGoal.setBorder(new MatteBorder(0, 0, 5, 5, (Color) new Color(0, 0, 0))); //Give the JComboBox a black border with specified dimensions on each side (pixels).
		comboBoxGoal.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"})); //Give the JComboBox contents to display/select from.
		GridBagConstraints gbc_comboBoxGoal = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_comboBoxGoal.insets = new Insets(0, 0, 0, 0); //Padding up, padding left, padding down, padding right (pixels).
		gbc_comboBoxGoal.fill = GridBagConstraints.BOTH; //Make the JComboBox scale both horizontally and vertically.
		gbc_comboBoxGoal.gridx = 3; //X coordinate of the JComboBox.
		gbc_comboBoxGoal.gridy = 13; //Y coordinate of the JComboBox.
		panelCenter.add(comboBoxGoal, gbc_comboBoxGoal); //Add the JComboBox and it's constraints to panelCenter.

		
		textFieldKickingComment = new JTextArea(); //Create a new JTextArea which is a multi-line text field.
		textFieldKickingComment.setBorder(new MatteBorder(0, 0, 5, 5, (Color) new Color(0, 0, 0))); //Give the JTextArea a black border with specified dimensions on each side (pixels).
		textFieldKickingComment.setLineWrap(true); //Text will jump down a line once it reached the end of the text area.
		GridBagConstraints gbc_textFieldKickingComment = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textFieldKickingComment.insets = new Insets(0, 0, 0, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldKickingComment.fill = GridBagConstraints.BOTH; //Make the JTextArea scale both horizontally and vertically.
		gbc_textFieldKickingComment.gridwidth = 2; //Make the JTextArea have a width of 2 cells.
		gbc_textFieldKickingComment.gridheight = 4; //Make the JTextArea have a height of 4 cells.
		gbc_textFieldKickingComment.gridx = 4; //X coordinate of the JTextArea.
		gbc_textFieldKickingComment.gridy = 10; //Y coordinate of the JTextArea.
		panelCenter.add(textFieldKickingComment, gbc_textFieldKickingComment); //Add the text field and it's constraints to panelCenter.
		
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
		
		JButton btnGoBack = new JButton("Go Back"); //Create a new JButton and give it text to display. This button will show the user the profile page with the current player's data.
		btnGoBack.setBackground(new Color(152, 251, 152)); //Give the button a light green background.
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of button.
		btnGoBack.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
		btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		panelSouth.add(btnGoBack); //Add button to panelSouth.
		btnGoBack.addActionListener(new ActionListener() { //When button is clicked...
			public void actionPerformed(ActionEvent e) {
				
				myController.goBack(); //Takes user back to the player profile page without re-querying the database.
				dispose(); //Get rid of this screen
			}
		});
		
		panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
		JButton btnSave = new JButton("Save"); //Create a new JButton and give it text to display. This button will save changes to the player's skills and comments.
		btnSave.setBackground(new Color(50, 205, 50)); //Give the button a green background.
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of button.
		btnSave.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS)); //Give panelSouth a box layout and an x-axis alignment.
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		panelSouth.add(btnSave); //Add button to panelSouth.
		
		btnSave.addActionListener(new ActionListener() { //When button is clicked...
			public void actionPerformed(ActionEvent e) {
				
				myController.saveSkills(); //Function to save the details of the currently viewed player.

			}
		});
		
		panelSouth.add(Box.createHorizontalGlue()); //This is space between elements that automatically adjusts to screen resolutions.
		
	}

	/*---GETTERS---*/
	
	/**
	 * Getter for the EditSkillsScreen class.
	 * @return the player's name.
	 */
	public String getTextFieldPlayerName() {
		return textFieldPlayerName.getText();
	}
	
	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's preferred position from a ComboBox.
	 */
	public String getComboBoxPreferredPosition() {
		return (String) comboBoxPreferredPosition.getSelectedItem();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return a comment on the player's health.
	 */
	public String getTextFieldHealthComment() {
		return textFieldHealthComment.getText();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return a comment on the player's Passing skill.
	 */
	public String getTextFieldPassingComment() {
		return textFieldPassingComment.getText();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return a comment on the player's Tackling skill.
	 */
	public String getTextFieldTacklingComment() {
		return textFieldTacklingComment.getText();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return a comment on the player's Kicking skill.
	 */
	public String getTextFieldKickingComment() {
		return textFieldKickingComment.getText();
	}
	
	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Goal skill (1 to 5) from a ComboBox. 
	 */
	public int getComboBoxGoal() {
		return comboBoxGoal.getSelectedIndex();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Standard skill (1 to 5) from a ComboBox. 
	 */
	public int getComboBoxStandard() {
		return comboBoxStandard.getSelectedIndex();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Spin skill (1 to 5) from a ComboBox. 
	 */
	public int getComboBoxSpin() {
		return comboBoxSpin.getSelectedIndex();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Prop skill (1 to 5) from a ComboBox. 
	 */
	public int getComboBoxPop() {
		return comboBoxPop.getSelectedIndex();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Front skill (1 to 5) from a ComboBox. 
	 */
	public int getComboBoxFront() {
		return comboBoxFront.getSelectedIndex();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Rear skill (1 to 5) from a ComboBox. 
	 */
	public int getComboBoxRear() {
		return comboBoxRear.getSelectedIndex();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Side skill (1 to 5) from a ComboBox.
	 */
	public int getComboBoxSide() {
		return comboBoxSide.getSelectedIndex();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Scrubble skill (1 to 5) from a ComboBox.
	 */
	public int getComboBoxScrabble() {
		return comboBoxScrabble.getSelectedIndex();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Drop skill (1 to 5) from a ComboBox.
	 */
	public int getComboBoxDrop() {
		return comboBoxDrop.getSelectedIndex();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Punt skill (1 to 5) from a ComboBox. 
	 */
	public int getComboBoxPunt() {
		return comboBoxPunt.getSelectedIndex();
	}

	/**
	 * Getter for the EditSkillsScreen class.
	 * @return index of the player's Grubber skill (1 to 5) from a ComboBox.
	 */
	public int getComboBoxGrubber() {
		return comboBoxGrubber.getSelectedIndex();
	}

	
	/*---SETTERS---*/
	
	/**
	 * Setter for the EditSkillsScreen class.
	 * @param textFieldPlayerName
	 */
	public void setTextFieldPlayerName(String textFieldPlayerName) {
		this.textFieldPlayerName.setText(textFieldPlayerName);
	}
	
	/**
	 * Setter for the EditSkillsScreen class.
	 * @param preferredPosition
	 */
	public void setComboBoxPreferredPosition(String preferredPosition) {
		
		for (int i = 0; i < 9; i++)
		{
			this.comboBoxPreferredPosition.setSelectedIndex(i);
			
			if (this.comboBoxPreferredPosition.getSelectedItem().equals(preferredPosition))
			{
				break;
			}
		}
		
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param textFieldHealthComment which holds a comment on the player's health.
	 */
	public void setTextFieldHealthComment(String textFieldHealthComment) {
		this.textFieldHealthComment.setText(textFieldHealthComment);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param textFieldPassingComment which holds a comment on the player's Passing skill.
	 */
	public void setTextFieldPassingComment(String textFieldPassingComment) {
		this.textFieldPassingComment.setText(textFieldPassingComment);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param textFieldTacklingComment which holds a comment on the Tackling skill.
	 */
	public void setTextFieldTacklingComment(String textFieldTacklingComment) {
		this.textFieldTacklingComment.setText(textFieldTacklingComment);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param textFieldKickingComment which holds a comment on the Kicking Skill.
	 */
	public void setTextFieldKickingComment(String textFieldKickingComment) {
		this.textFieldKickingComment.setText(textFieldKickingComment);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Goal skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxGoal(int index) {
		this.comboBoxGoal.setSelectedIndex(index);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Standard skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxStandard(int index) {
		this.comboBoxStandard.setSelectedIndex(index);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Spin skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxSpin(int index) {
		this.comboBoxSpin.setSelectedIndex(index);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Pop skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxPop(int index) {
		this.comboBoxPop.setSelectedIndex(index);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Front skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxFront(int index) {
		this.comboBoxFront.setSelectedIndex(index);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Rear skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxRear(int index) {
		this.comboBoxRear.setSelectedIndex(index);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Side skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxSide(int index) {
		this.comboBoxSide.setSelectedIndex(index);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Scrabble skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxScrabble(int index) {
		this.comboBoxScrabble.setSelectedIndex(index);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Drop skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxDrop(int index) {
		this.comboBoxDrop.setSelectedIndex(index);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Punt skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxPunt(int index) {
		this.comboBoxPunt.setSelectedIndex(index);
	}

	/**
	 * Setter for the EditSkillsScreen class.
	 * @param index which corresponds to the player's Grubber skill (1 to 5) in the JComboBox.
	 */
	public void setComboBoxGrubber(int index) {
		this.comboBoxGrubber.setSelectedIndex(index);
	}

}
