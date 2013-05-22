package project;

import java.awt.Font;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class GUIArticlePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextArea jTextArea;
	private JScrollPane articleListScroll;
	
	private GUIContainerPanel containerPane;
	private int userID;
	
	private File file;
	
	public GUIArticlePanel(GUIContainerPanel containerPane, int userID) {
		this.containerPane = containerPane;
		this.userID = userID;
		
		jTextArea = new JTextArea();
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
		articleListScroll = new JScrollPane(jTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(articleListScroll);
	}

	public void updateArticles(int feedID) {
		file = new File(RWToDatabase.getFeedPath(feedID));
		jTextArea.setText(
	}

}
