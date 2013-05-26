 package project;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Kamyar_Aflaki Ali_Khalili Uraz_Seddigh 
 *
 */
public class GUILoginPanel extends JPanel  {

	private static final long serialVersionUID = 1L;
	
	private JPanel credentialsPane;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton loginButton;
	
	private String usernameValue;
	private String passwordValue;
	private String validUser;
	
	private GUIContainerPanel containerPane;
	
	/**
	 * @param containerPane Container Panel.
	 */
	public GUILoginPanel(GUIContainerPanel containerPane) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.containerPane = containerPane;
		
		credentialsPane = new JPanel(new GridLayout(2, 2));
		usernameLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");
		usernameField = new JTextField(15);
		passwordField = new JPasswordField(15);
		credentialsPane.add(usernameLabel);
		credentialsPane.add(usernameField);
		credentialsPane.add(passwordLabel);
		credentialsPane.add(passwordField);
		add(credentialsPane);
		
		loginButton = new JButton("Login");
		loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginButton.addActionListener(new ButtonListener());
		loginButton.setFocusable(true);
		add(loginButton);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			usernameValue = usernameField.getText();
			if (RWToDatabase.nameExists(usernameValue)) {
				validUser = usernameValue;
				passwordValue = passwordField.getText();
//				System.out.println(passwordValue);
				if (User.checkCredentials(validUser, passwordValue)) {
					containerPane.authenticated(RWToDatabase.getUserID(usernameValue));
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid username or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid username or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
