import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Component;

/**
 * This class is responsible for creating the graphical interface of the coach menu.
 * It displays general user details and a logout button at the top. A navigation bar on the left. A table of selectable players in the middle and a select player button below it.
 * The purpose of this screen is to allow the coach to select a player and view their details.
 * This class inherits from JFrame.
 *@author Renat Oosthuizen
 *@since 10/05/2021
 */
@SuppressWarnings("serial")
public class CoachMenuScreen extends JFrame {
	
	/**CoachMenuController variable that performs all the logic for this screen.*/
	private CoachMenuController myController;

	/**
	 * Parameterised constructor for the class. It accepts it's own controller class in order to create data binding between the two classes.
	 * @param control is the controller for this View Screen.
	 */
	public CoachMenuScreen(CoachMenuController control) {
		
		myController = control; //Assign myController as an instance of CoachMenuController.
		
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
		gbl_panelCenter.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE}; //Give the layout column weights.
		gbl_panelCenter.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE}; //Give the layout row weights.
		panelCenter.setLayout(gbl_panelCenter); //Add the layout to panelCentre.
		
		//Jlist Header		
		JLabel lblHeader = new JLabel("Profile ID      Name                                Player Type"); //Assign lblHeader as a new Label with header text.
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 12)); //Set font of the header.
		lblHeader.setHorizontalAlignment(SwingConstants.LEFT); //Align it the text to the left.
		lblHeader.setBackground(SystemColor.activeCaption); //Give the text a light blue background colour.
		lblHeader.setOpaque(true); //Make the header opaque so that the background colour would render.
		GridBagConstraints gbc_lblHeader = new GridBagConstraints(); //Assign gbc_lblHeader as a new set of GridBagConstraints. 
		gbc_lblHeader.fill = GridBagConstraints.HORIZONTAL; //Allow the header to be resized horizontally.
		gbc_lblHeader.gridwidth = 3; //Make the label have a length of 3 cells.
		gbc_lblHeader.insets = new Insets(20, 100, 0, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblHeader.gridx = 0; //X coordinate of the header.
		gbc_lblHeader.gridy = 1; //Y coordinate of the header.
		panelCenter.add(lblHeader, gbc_lblHeader); //Add the header and it's constraints to panelCenter.
		
		
		/*JList*/
		JList<String> listPlayers = new JList<String>(); //Assign listPlayers as a new JList.
		listPlayers.setPreferredSize(new Dimension(300, 500)); //Set list dimensions.

		DefaultListModel<String> DLM = new DefaultListModel<String>(); //Assign DLM as a new DefaultListModel that will hold data.
		
		for (int i = 0; i < myController.getPlayerData().size(); i+=3) //Populate model with data.
		{
			DLM.addElement(myController.getPlayerData().get(i).toString() + "                       " + myController.getPlayerData().get(i+1).toString() + "                           " + myController.getPlayerData().get(i+2).toString());
		}
		
		listPlayers.setModel(DLM); //Add model to the list so that it now has data to display.
		JScrollPane JSP = new JScrollPane(listPlayers); //Assign JSP as a new JScrollPane and add the list to it.
		JSP.setPreferredSize(new Dimension(300, 250)); //Set scroll pane dimensions.
		GridBagConstraints gbc_listPlayers = new GridBagConstraints(); //Assign gbc_listPlayers as a new set of GridBagConstraints. 
		gbc_listPlayers.fill = GridBagConstraints.BOTH; //The scroll pane will resize vertically and horizontally.
		gbc_listPlayers.insets = new Insets(0, 100, 20, 100); //Padding up, padding left, padding down, padding right (pixels)
		gbc_listPlayers.gridwidth = 3; //Make the scroll pane have a width of 3 cells.
		gbc_listPlayers.gridx = 0; //X coordinate of the scroll pane.
		gbc_listPlayers.gridy = 2; //Y coordinate of the scroll pane.
		panelCenter.add(JSP, gbc_listPlayers); //Add the scroll pane containing the JList and constraints to panelCenter.
		
		
		//JList Selection Button
		JButton btnSelectPlayer = new JButton("Select Player"); //Assign btnSelectPlayer as a new JButton that displays "Select Player" text.
		btnSelectPlayer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		btnSelectPlayer.setBackground(new Color(50, 205, 50)); //Give the button a green background.
		btnSelectPlayer.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of button.
		btnSelectPlayer.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		GridBagConstraints gbc_btnSelectPlayer = new GridBagConstraints(); //Assign gbc_btnSelectPlayer as a new set of GridBagConstraints.
		gbc_btnSelectPlayer.fill = GridBagConstraints.HORIZONTAL; //Button will resize horizontally.
		gbc_btnSelectPlayer.insets = new Insets(20, 5, 50, 100); //Padding up, padding left, padding down, padding right (pixels)
		gbc_btnSelectPlayer.gridx = 2; //X coordinate of the button.
		gbc_btnSelectPlayer.gridy = 3; //Y coordinate of the button.
		panelCenter.add(btnSelectPlayer, gbc_btnSelectPlayer); //Add the button and constraints to panelCenter.
		
		btnSelectPlayer.addActionListener(new ActionListener() { //Give the button an action listener.
			public void actionPerformed(ActionEvent e) {
				
				myController.showPlayerDetails(listPlayers.getSelectedIndex()); //Call function to display Profile Screen for selected profile from the controller.
				dispose(); //Get rid of this screen.
			}
		});
		
	}
}
