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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * This class is responsible for creating the graphical interface of the View Squads page.
 * It displays general user details and a logout button at the top. A navigation bar on the left. The middle section allows a user to enter a squad name and create a new squad. 
 * Below that is a table of selectable squads and a select squad button below it.
 * The purpose of this screen is to allow the coach to create a new squad or select a squad so that they can view/edit it's details.
 * This class inherits from JFrame.
 *@author Renat Oosthuizen
 *@since 10/05/2021
 */
@SuppressWarnings("serial")
public class ViewSquadsScreen extends JFrame {

	/**ViewSquadsController variable that performs all the logic for this screen.*/
	private ViewSquadsController myController;
	
	/**JTextField variable holds the name of the brand new squad that will be created.*/
	private JTextField textFieldSquadName;
	

	/**
	 * Parameterised constructor for the class. It accepts it's own controller class in order to create data binding between the two classes.
	 * @param control is the controller for this View Screen.
	 */
	public ViewSquadsScreen(ViewSquadsController control) {
		
		myController = control; //Assign myController as ViewSquadsController.
		
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
		GridBagLayout gbl_panelCenter = new GridBagLayout(); //Assign gbl_panelCenter as a new GridBagLayout.
		gbl_panelCenter.columnWeights = new double[]{0.0, 1.0, 1.0}; //Give the layout column weights.
		gbl_panelCenter.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE}; //Give the layout row weights.
		panelCenter.setLayout(gbl_panelCenter); //Add the layout to panelCentre.
		
		
		/*Create New Squad*/
		JLabel lblNewSquad = new JLabel("New Squad:"); //Assign lblNewSquad as a new JLabel that displays "New Squad:" text.
		lblNewSquad.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the button.
		GridBagConstraints gbc_lblNewSquad = new GridBagConstraints(); //Assign gbc_lblNewSquad as a new set of GridBagConstraints. 
		gbc_lblNewSquad.anchor = GridBagConstraints.EAST; //Label will attempt to stay on the right side of the screen.
		gbc_lblNewSquad.insets = new Insets(50, 100, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblNewSquad.gridx = 0; //X coordinate of the header.
		gbc_lblNewSquad.gridy = 0; //Y coordinate of the header.
		panelCenter.add(lblNewSquad, gbc_lblNewSquad); //Add the label and it's constraints to panelCenter.
		
		textFieldSquadName = new JTextField(); //Assign textFieldSquadName as a new JTextField that will store a squad name.
		GridBagConstraints gbc_textFieldSquadName = new GridBagConstraints(); //Assign gbc_textFieldSquadName as a new set of GridBagConstraints. 
		gbc_textFieldSquadName.fill = GridBagConstraints.HORIZONTAL;  //Allow the text field to be resized horizontally.
		gbc_textFieldSquadName.insets = new Insets(50, 0, 20, 5); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textFieldSquadName.gridx = 1; //X coordinate of the header.
		gbc_textFieldSquadName.gridy = 0;//Y coordinate of the header.
		panelCenter.add(textFieldSquadName, gbc_textFieldSquadName); //Add the text field and it's constraints to panelCenter.
		
		JButton btnCreateSquad = new JButton("Create Squad"); //Assign btnCreateSquad as a new button that will attempt to create a new squad.
		btnCreateSquad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		btnCreateSquad.setBackground(new Color(50, 205, 50)); //Give it a green background colour.
		btnCreateSquad.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of the button.
		GridBagConstraints gbc_btnCreateSquad = new GridBagConstraints(); //Assign gbc_btnCreateSquad as a new set of GridBagConstraints. 
		gbc_btnCreateSquad.anchor = GridBagConstraints.EAST; //Button will attempt to stay on the right side of the screen.
		gbc_btnCreateSquad.insets = new Insets(50, 5, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_btnCreateSquad.gridx = 2; //X coordinate of the header.
		gbc_btnCreateSquad.gridy = 0; //Y coordinate of the header.
		panelCenter.add(btnCreateSquad, gbc_btnCreateSquad); //Add the button and it's constraints to panelCenter.
		btnCreateSquad.addActionListener(new ActionListener() { //Give the button an action listener.

			public void actionPerformed(ActionEvent e) {
				
				if (!textFieldSquadName.getText().trim().equals("")) { //If user has entered a squad name.. !!Must restrict user from entering more than 20 characters!!!
					
					myController.createSquad(); //Function to display the Edit Squad Screen for a new Squad.
					dispose(); //Get rid of this screen
				}
				else {
					
					JOptionPane.showMessageDialog(null, //Appears centred on screen
						    "Please enter a valid squad name.", //Message
						    "Error!",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		//Jlist Header
		JLabel lblHeader = new JLabel("Squad ID      Squad Name"); //Assign lblHeader as a new Label with header text.
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the header.
		lblHeader.setHorizontalAlignment(SwingConstants.LEFT); //Align it the text to the left.
		lblHeader.setBackground(SystemColor.activeCaption); //Give the text a light blue background colour.
		lblHeader.setOpaque(true); //Make the header opaque so that the background colour would render.
		GridBagConstraints gbc_lblHeader = new GridBagConstraints(); //Assign gbc_lblHeader as a new set of GridBagConstraints. 
		gbc_lblHeader.fill = GridBagConstraints.HORIZONTAL; //Allow the header to be resized horizontally.
		gbc_lblHeader.gridwidth = 3; //Make the label have a length of 3 cells.
		gbc_lblHeader.insets = new Insets(0, 100, 0, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblHeader.gridx = 0; //X coordinate of the header.
		gbc_lblHeader.gridy = 1; //Y coordinate of the header.
		panelCenter.add(lblHeader, gbc_lblHeader); //Add the header and it's constraints to panelCenter.
		
		//JList
		final JList<String> listSquads = new JList<String>(); //Assign listSquads as a new JList.
		listSquads.setPreferredSize(new Dimension(300, 500)); //Set list dimensions.

		DefaultListModel<String> DLM = new DefaultListModel<String>(); //Assign DLM as a new DefaultListModel that will hold data.
		
		for (int i = 0; i < myController.getSquadData().size(); i+=2) //Populate model with data.
		{
			String space; //Variable stores the space displayed between SquadID and SquadName in JList. The length of the space is adjusted to make table look cleaner.
			
			if(myController.getSquadData().get(i).toString().length() < 2){ //Adjust length of space based on length of ID string.
				
				space = "                         ";
			}
			else {
				
				space = "                       ";
			}
			
			DLM.addElement(myController.getSquadData().get(i).toString() + space + myController.getSquadData().get(i+1).toString());
		}
		

		
		listSquads.setModel(DLM); //Add model to the list so that it now has data to display.
		JScrollPane JSP = new JScrollPane(listSquads); //Assign JSP as a new JScrollPane and add the list to it.
		JSP.setPreferredSize(new Dimension(300, 250)); //Set scroll pane dimensions.
		GridBagConstraints gbc_listSquads = new GridBagConstraints(); //Assign gbc_listSquads as a new set of GridBagConstraints. 
		gbc_listSquads.fill = GridBagConstraints.BOTH; //The scroll pane will resize vertically and horizontally.
		gbc_listSquads.insets = new Insets(0, 100, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_listSquads.gridwidth = 3; //Make the Jlist have a width of 3 cells.
		gbc_listSquads.gridx = 0; //X coordinate of the scroll pane.
		gbc_listSquads.gridy = 2; //Y coordinate of the scroll pane.
		panelCenter.add(JSP, gbc_listSquads); //Add the scroll pane containing the JList and constraints to panelCenter.
		
		
		//JList Selection Button
		JButton btnSelectSquad = new JButton("Select Squad"); //Assign btnSelectSquad as a new JButton that displays "Select Squad" text.
		btnSelectSquad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		btnSelectSquad.setBackground(new Color(50, 205, 50)); //Give the button a green background.
		btnSelectSquad.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of button.
		btnSelectSquad.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		GridBagConstraints gbc_btnSelectSquad = new GridBagConstraints(); //Assign gbc_btnSelectSquad as a new set of GridBagConstraints.
		gbc_btnSelectSquad.anchor = GridBagConstraints.EAST; //Button will try to stay on the right side of the screen.
		gbc_btnSelectSquad.insets = new Insets(20, 5, 50, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_btnSelectSquad.gridx = 2; //X coordinate of the button.
		gbc_btnSelectSquad.gridy = 3; //Y coordinate of the button.
		panelCenter.add(btnSelectSquad, gbc_btnSelectSquad); //Add the button and constraints to panelCenter.
		
		btnSelectSquad.addActionListener(new ActionListener() { //Give the button an action listener.

			public void actionPerformed(ActionEvent e) {
				
				myController.showSquadDetails(listSquads.getSelectedIndex()); //Call function to display the Edit Squad Screen for the selected Squad.
				dispose(); //Get rid of this screen.
			}
		});
		
	}

	/*---GETTERS---*/
	
	/**
	 * Getter for the ViewSquadScreen class.
	 * @return textFieldSquadName which holds the name of the squad that will be created.
	 */
	public JTextField getTextFieldSquadName() {
		return textFieldSquadName;
	}


}
