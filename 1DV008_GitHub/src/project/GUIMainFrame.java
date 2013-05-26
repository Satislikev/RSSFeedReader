 package project;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Kamyar_Aflaki Ali_Khalili Uraz_Seddigh 
 *
 */
public class GUIMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel containerPane;
	
	public GUIMainFrame() {
		super("RSS Feed Reader");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100,100);
		
		containerPane = new GUIContainerPanel(this);
		getContentPane().add(containerPane);
		setResizable(false);
		pack();
		
	}

}
