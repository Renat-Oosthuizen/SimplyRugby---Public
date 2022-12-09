import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import java.awt.Cursor;

/**
 * This class is responsible for the graphical interface of the login screen.
 * It has a logo at the top and 2 text field with accompanying labels.
 * There is a hidden label that displays error messages and a button for submitting the contents of the text fields for validation.
 * This class inherits from JFrame.
 *@author Renat Oosthuizen
 *@since 13/05/2021
 */
@SuppressWarnings("serial")
public class LoginScreen extends JFrame {

	private JTextField textEmail;
	private JTextField textPassword;
	
	/**LoginController variable that performs all the logic for this screen.*/
	private LoginController myController;

	
	/**
	 * Parameterised constructor for the class. It accepts it's own controller class in order to create data binding between the two classes.
	 * @param control is the controller for this View Screen.
	 */
	public LoginScreen(LoginController control) {
		
		myController = control; //Assign myController as an instance of LoginController.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The application will quit when the JFrame is closed.
		setBounds(0, 0, 1920, 1080); //JFrame is created at coordinates 0, 0 of screen with 1920x1080 pixel dimensions.
		JPanel contentPane = new JPanel(); //Assign contentPane to be a new instance of JPanel. This is the main panel of the JFrame.
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //Create a 5 pixel border around all sides of the contentPane.
		setContentPane(contentPane); //Insert contentPane into the JFrame.
		contentPane.setLayout(new BorderLayout(0, 0)); //Give contentPane a Border Layout.
	
		
		/*---------------------Central Panel--------------------------------*/
		
		JPanel panelCenter = new JPanel(); //Assign panelCenter as a new JPanel.
		contentPane.add(panelCenter, BorderLayout.CENTER); //Place it in the centre of contentPane.
		GridBagLayout gbl_panelCenter = new GridBagLayout(); //Assign gbl_panelCenter as a new GridBagLayout.
		gbl_panelCenter.columnWeights = new double[]{0.0}; //Give the layout column weights.
		gbl_panelCenter.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0}; //Give the layout row weights.
		panelCenter.setLayout(gbl_panelCenter); //Add the layout to panelCentre.
		
		//Label with image
		JLabel lblLogo = new JLabel(""); //Create a new JLabel with no text.
		
		lblLogo.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/Medium Transparent Logo.png"))); //Give the JLabel an image to display. Will only work as an executable because of Maven, remove "/resources" to compile in IDE
		GridBagConstraints gbc_lblLogo = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblLogo.insets = new Insets(20, 50, 10, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblLogo.gridx = 0; //X coordinate of the JLabel.
		gbc_lblLogo.gridy = 0; //Y coordinate of the JLabel.
		panelCenter.add(lblLogo, gbc_lblLogo); //Add the label and it's constraints to panelCenter.
		
		//Error Label
		final JLabel lblErrorMessage = new JLabel(""); //Create a new JLabel with no text.
		lblErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of the JLabel.
		lblErrorMessage.setForeground(Color.RED); //Set the colour of the JLabel text to red.
		GridBagConstraints gbc_lblErrorMessage = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblErrorMessage.insets = new Insets(10, 50, 10, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblErrorMessage.gridx = 0; //X coordinate of the JLabel.
		gbc_lblErrorMessage.gridy = 1; //Y coordinate of the JLabel.
		panelCenter.add(lblErrorMessage, gbc_lblErrorMessage); //Add the label and it's constraints to panelCenter.
		
		//"Email:" label
		JLabel lblEnterEmail = new JLabel("Email:"); //Create a new JLabel and give it text to display.
		lblEnterEmail.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of the JLabel.
		GridBagConstraints gbc_lblEnterEmail = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblEnterEmail.insets = new Insets(10, 50, 10, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblEnterEmail.gridx = 0; //X coordinate of the JLabel.
		gbc_lblEnterEmail.gridy = 2; //Y coordinate of the JLabel.
		panelCenter.add(lblEnterEmail, gbc_lblEnterEmail); //Add the label and it's constraints to panelCenter.
		
		//Email text field
		textEmail = new JTextField(); //Create a new JTextField.
		textEmail.setHorizontalAlignment(SwingConstants.CENTER); //Text field will always be in the centre of the screen.
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 14)); //Set font of the JTextField.
		GridBagConstraints gbc_textEmail = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textEmail.insets = new Insets(10, 50, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textEmail.gridx = 0; //X coordinate of the JTextField.
		gbc_textEmail.gridy = 3; //Y coordinate of the JTextField.
		panelCenter.add(textEmail, gbc_textEmail); //Add the text field and it's constraints to panelCenter.
		
		//"Password:" label
		JLabel lblEnterPassword = new JLabel("Password:"); //Create a new JLabel and give it text to display.
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of the JTextField.
		GridBagConstraints gbc_lblEnterPassword = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_lblEnterPassword.insets = new Insets(20, 50, 10, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_lblEnterPassword.gridx = 0; //X coordinate of the JLabel.
		gbc_lblEnterPassword.gridy = 4; //Y coordinate of the JLabel.
		panelCenter.add(lblEnterPassword, gbc_lblEnterPassword); //Add the label and it's constraints to panelCenter.
		
		//Password text field
		textPassword = new JPasswordField(); //Create a new JTextField.
		textPassword.setHorizontalAlignment(SwingConstants.CENTER); //Text field will always be in the centre of the screen.
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_textPassword = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_textPassword.fill = GridBagConstraints.HORIZONTAL; //Allow the text field to be resized horizontally.
		gbc_textPassword.insets = new Insets(10, 50, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_textPassword.gridx = 0; //X coordinate of the JTextField.
		gbc_textPassword.gridy = 5; //Y coordinate of the JTextField.
		panelCenter.add(textPassword, gbc_textPassword); //Add the text field and it's constraints to panelCenter.
		
		//Login button
		JButton btnLogin = new JButton("Login"); //Create a new JButton and give it text to display.
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Cursor looks like a hand when hovered over the button.
		btnLogin.setBackground(new Color(50, 205, 50)); //Give the button a green background.
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16)); //Set font of button.
		btnLogin.setFocusable(false); //Get rid of weird square around text of the button when hovered over.
		GridBagConstraints gbc_btnLogin = new GridBagConstraints(); //Create a new set of GridBagConstraints.
		gbc_btnLogin.insets = new Insets(20, 50, 20, 50); //Padding up, padding left, padding down, padding right (pixels).
		gbc_btnLogin.gridx = 0; //X coordinate of the JButton.
		gbc_btnLogin.gridy = 6; //Y coordinate of the JButton.
		panelCenter.add(btnLogin, gbc_btnLogin); //Add the JButton and it's constraints to panelCenter.
		btnLogin.addActionListener(new ActionListener() { //When the button is pressed...
			public void actionPerformed(ActionEvent arg0) {
				
				if(validateInput() == true) //If neither text field is empty.
				{ 
					
					boolean result = myController.performLogin(textEmail.getText(), textPassword.getText()); //Call Controller class to perform a login attempt.
				
					if (result == true) //If a match is found clear the text fields and the error label message, then close the screen.
					{ 
						
						textEmail.setText(""); 
						textPassword.setText("");
						lblErrorMessage.setText("");
						dispose();
					}
					else //Otherwise display an error label message and clear the text fields.
					{ 
						
						lblErrorMessage.setText("Error: Email or Password is incorrect"); 
						textEmail.setText(""); 
						textPassword.setText(""); 
					}
				}
				else //If a text field is empty, display an error label message to let the user know that the text fields cannot be empty.
				{
					lblErrorMessage.setText("Error: Email and Password fields cannot be empty"); 
				}
			}
		});

		/*Coloured Borders*/
		JPanel panelWest = new JPanel(); //Create a new panel.
		panelWest.setBackground(Color.BLACK); //Give it a black colour.
		contentPane.add(panelWest, BorderLayout.WEST); //Add it to the left side of the screen.
		
		JPanel panelEast = new JPanel(); //Create a new panel.
		panelEast.setBackground(Color.BLACK); //Give it a black colour.
		contentPane.add(panelEast, BorderLayout.EAST); //Add it to the right side of the screen.
		
		JPanel panelSouth = new JPanel(); //Create a new panel.
		panelSouth.setBackground(Color.BLUE); //Give it a blue colour.
		contentPane.add(panelSouth, BorderLayout.SOUTH); //Add it to the bottom side of the screen.
		
		JPanel panelNorth = new JPanel(); //Create a new panel.
		panelNorth.setBackground(Color.BLUE); //Give it a blue colour.
		contentPane.add(panelNorth, BorderLayout.NORTH); //Add it to the top side of the screen.
		
	}
	
	/**
	 * Checks that the input fields are not empty during submission
	 * @return true if both email and password text fields contain data. Otherwise return false.
	 */
	private boolean validateInput() {
		
		if(textEmail.getText().equals("") || textPassword.getText().equals("")) {
			
			return false;
		}
		else
		{
			return true;
		}
		
	}
}
