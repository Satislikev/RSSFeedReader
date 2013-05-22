package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
		categoryAdd.addActionListener(new ButtonListener());
		categoryRemove = new JButton("Remove Category");
		categoryRemove.addActionListener(new ButtonListener());
		feedAdd = new JButton("Add Feed");
		feedAdd.addActionListener(new ButtonListener());
		feedRemove = new JButton("Remove Feed");
		feedRemove.addActionListener(new ButtonListener());
		
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
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == categoryAdd) {
				categoryPane.addCategory(JOptionPane.showInputDialog("Input new category name:"));
			}
			
			if (event.getSource() == categoryRemove) {
				String[] categories = RWToDatabase.getUsersCategoryList(userID);
				String categoryToRemove = (String) JOptionPane.showInputDialog(
		                null,
		                "Choose category to remove:",
		                "Remove Category",
		                JOptionPane.PLAIN_MESSAGE,
		                null,
		                categories,
		                categories[0]);
				categoryPane.removeCategory(categoryToRemove);
			}
			
			if (event.getSource() == feedAdd) {
				
			}
			
			if (event.getSource() == feedRemove) {
				
			}
			
		}
	}

}
