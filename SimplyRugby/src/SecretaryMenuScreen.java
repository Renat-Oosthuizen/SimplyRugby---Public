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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 * This class is responsible for creating the graphical interface of the secretary menu.
 * It displays general user details and a logout button at the top. A navigation bar on the left. A table of selectable profiles in the middle and a select profile button below it.
 * The purpose of this screen is to allow the secretary to select a profile and view their details.
 * This class inherits from JFrame.
 *@author Renat Oosthuizen
 *@since 10/05/2021
 */
@SuppressWarnings("serial")
public class SecretaryMenuScreen extends JFrame {
	
	/**SecretaryMenuController variable that performs all the logic for this screen.*/
	private SecretaryMenuController myController;

	/**
	 * Parameterised constructor for the class. It accepts it's own controller class in order to create data binding between the two classes.
	 * @param control is the controller for this View Screen.
	 */
	public SecretaryMenuScreen(SecretaryMenuController control) {
		
		myController = control; //Assign myController as an instance of SecretaryMenuController.
		
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
				String s = (String)JOptionPane.showInputDialog(contentPane, //Appears on top of contentPane
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
		
/*-------------------------Central Form------------------*/
		
		
		JPanel panelCenter = new JPanel(); //Assign panelCenter as a new JPanel.
		panelCenter.setBackground(Color.LIGHT_GRAY); //Give it a light grey background.
		contentPane.add(panelCenter, BorderLayout.CENTER); //Place it in the centre of contentPane.
		GridBagLayout gbl_panelCenter = new GridBagLayout(); //Assign gbl_panelCenter as a new GridBagLayout.
		gbl_panelCenter.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE}; //Give the layout column weights.
		gbl_panelCenter.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE}; //Give the layout row weights.
		panelCenter.setLayout(gbl_panelCenter); //Add the layout to panelCentre.
		
		//Jlist Header		
		JLabel lblHeader = new JLabel("Profile ID      Name                                Profile Type"); //Assign lblHeader as a new Label with header text.
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
		
		//JList
		JList<String> listProfiles = new JList<String>(); //Assign listProfiles as a new JList.
		listProfiles.setPreferredSize(new Dimension(300, 500)); //Set list dimensions.

		DefaultListModel<String> DLM = new DefaultListModel<String>(); //Assign DLM as a new DefaultListModel that will hold data.
		
		for (int i = 0; i < myController.getProfileData().size(); i+=3) //Populate model with data.
		{
			DLM.addElement(myController.getProfileData().get(i).toString() + "                       " + myController.getProfileData().get(i+1).toString() + "                               " + myController.getProfileData().get(i+2).toString());
		}
		
		listProfiles.setModel(DLM); //Add model to the list so that it now has data to display.
		JScrollPane JSP = new JScrollPane(listProfiles); //Assign JSP as a new JScrollPane and add the list to it.
		JSP.setPreferredSize(new Dimension(300, 250)); //Set scroll pane dimensions.
		GridBagConstraints gbc_listProfiles = new GridBagConstraints(); //Assign gbc_listProfiles as a new set of GridBagConstraints. 
		gbc_listProfiles.fill = GridBagConstraints.BOTH; //The scroll pane will resize vertically and horizontally.
		gbc_listProfiles.insets = new Insets(0, 100, 20, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_listProfiles.gridwidth = 3; //Make the Jlist have a width of 3 cells.
		gbc_listProfiles.gridx = 0; //X coordinate of the scroll pane.
		gbc_listProfiles.gridy = 2; //Y coordinate of the scroll pane.
		panelCenter.add(JSP, gbc_listProfiles); //Add the scroll pane containing the JList and constraints to panelCenter.
				
		
		//JList Selection Button
		JButton btnSelectProfile = new JButton("Select Profile"); //Assign btnSelectPlayer as a new JButton that displays "Select Player" text.
		btnSelectProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		btnSelectProfile.setBackground(new Color(50, 205, 50)); //Give the button a green background.
		btnSelectProfile.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of button.
		btnSelectProfile.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		GridBagConstraints gbc_btnSelectProfile = new GridBagConstraints(); //Assign gbc_btnSelectProfile as a new set of GridBagConstraints.
		gbc_btnSelectProfile.fill = GridBagConstraints.HORIZONTAL; //Button will resize horizontally.
		gbc_btnSelectProfile.insets = new Insets(20, 5, 50, 100); //Padding up, padding left, padding down, padding right (pixels).
		gbc_btnSelectProfile.gridx = 2; //X coordinate of the button.
		gbc_btnSelectProfile.gridy = 3; //Y coordinate of the button.
		panelCenter.add(btnSelectProfile, gbc_btnSelectProfile); //Add the button and constraints to panelCenter.
		
		btnSelectProfile.addActionListener(new ActionListener() { //Give the button an action listener.
			public void actionPerformed(ActionEvent e) {
				
				myController.showPlayerDetails(listProfiles.getSelectedIndex()); //Call function to display Profile Screen for selected profile from the controller.
				dispose(); //Get rid of this screen.
			}
		});
	}
}
