package project;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel loginPanel;
	
	public GUIMainFrame() {
		super("RSS Feed Reader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		
		loginPanel = new GUILoginPanel();
		getContentPane().add(loginPanel);
		
	}

}
