package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class GUIContainerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final Dimension PANEL_SIZE = new Dimension(1200, 800);
	private final Color BACKGROUND_COLOR = Color.white;
	private GUILoginPanel loginPane;
	private GUICategoryPanel categoryPane;
	private GUIFeedPanel feedPane;
	private GUIArticlePanel articlePane;
	private int userID;
	
	private JToolBar categoryToolBar;
	private JToolBar feedToolBar;
	
	private JButton categoryAdd;
	private JButton categoryRemove;
	private JButton feedAdd;
	private JButton feedRemove;
	
	public GUIContainerPanel() {
		setBackground(BACKGROUND_COLOR);
		setLayout(new BorderLayout());
		
		loginPane = new GUILoginPanel(this);
		add(loginPane, BorderLayout.CENTER);
	}

	public void authenticated(int userID) {
		this.userID = userID;
		loginPane.setVisible(false);
		setPreferredSize(PANEL_SIZE);
		
		categoryPane = new GUICategoryPanel(this, this.userID);
		feedPane = new GUIFeedPanel(this, this.userID);
		articlePane = new GUIArticlePanel(this, this.userID);
		
		add(categoryPane, BorderLayout.CENTER);
		add(feedPane, BorderLayout.CENTER);
		add(articlePane, BorderLayout.CENTER);
		
		categoryToolBar = new JToolBar("Category Tools");
		feedToolBar = new JToolBar("Feed Tools");
		
		categoryAdd = new JButton("Add Category");
		categoryRemove = new JButton("Remove Category");
		feedAdd = new JButton("Add Feed");
		feedRemove = new JButton("Remove Feed");
		
		categoryToolBar.add(categoryAdd);
		categoryToolBar.add(categoryRemove);
		feedToolBar.add(feedAdd);
		feedToolBar.add(feedRemove);
		
		add(categoryToolBar, BorderLayout.PAGE_START);
		add(feedToolBar, BorderLayout.PAGE_START);
		
	}
	
	public void showFeeds(int categoryID) {
		feedPane.updateFeedList(categoryID);
	}
	
	public void showArticles(int feedID) {
		articlePane.updateArticles(feedID);
	}

}
