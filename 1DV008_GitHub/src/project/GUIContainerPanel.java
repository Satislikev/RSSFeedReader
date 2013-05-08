package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GUIContainerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final Dimension PANEL_SIZE = new Dimension(1200, 800);
	private final Color BACKGROUND_COLOR = Color.white;
	private JPanel loginPanel;
	
	public GUIContainerPanel() {
		setPreferredSize(PANEL_SIZE);
		setBackground(BACKGROUND_COLOR);
		setLayout(new BorderLayout());
		
		loginPanel = new GUILoginPanel();
		add(loginPanel, BorderLayout.CENTER);
		
	}

}
