 package project;

import java.awt.Color;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

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
		
		jTextArea = new JTextArea(33, 31);
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
		jTextArea.setBackground(new Color(164, 157, 208));
		articleListScroll = new JScrollPane(jTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(articleListScroll);
		setBackground(new Color(115, 110, 144));
		setBorder(new TitledBorder(new EtchedBorder(), "Articles"));
	}

	public void updateArticles(int feedID) {
		file = new File(RWToDatabase.getFeedPath(feedID));
		String contents = FeedParser.ParseFeed(file).articleToString();
		jTextArea.setText(contents);
		this.revalidate();
	}

}
