package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class GUIContainerPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final Dimension PANEL_SIZE = new Dimension(800, 600);
	private final Color BACKGROUND_COLOR = Color.white;
	private GUILoginPanel loginPane;
	private GUICategoryPanel categoryPane;
	private GUIFeedPanel feedPane;
	private GUIArticlePanel articlePane;
	private int userID;

	private JToolBar categoryToolBar;
	//	private JToolBar feedToolBar;

	private JPanel toolbarsPanel;

	private JButton categoryAdd;
	private JButton categoryRemove;
	private JButton feedAdd;
	private JButton feedRemove;

	private GUIMainFrame guiMainFrame;

	private JPanel centerGridContainer;
	private JPanel leftGridContainer;

	public GUIContainerPanel(GUIMainFrame guiMainFrame) {
		setBackground(BACKGROUND_COLOR);
		setLayout(new BorderLayout());
		this.guiMainFrame = guiMainFrame;

		loginPane = new GUILoginPanel(this);
		add(loginPane, BorderLayout.CENTER);
	}

	public void authenticated(int userID) {
		File directory = new File("FeedFiles");
		File[] files = directory.listFiles();
		String feedTitle;
		String feedPath;
		for (File element : files) {
			if (element.getName().endsWith(".rss")) {
				feedTitle = element.getName();
				feedPath = element.getPath();
//				System.out.println(feedTitle + " " + feedPath);
				RWToDatabase.fillFeedTable(feedTitle, feedPath);
			}
		}
		this.userID = userID;
		loginPane.setVisible(false);
		setPreferredSize(PANEL_SIZE);
		guiMainFrame.pack();

		centerGridContainer = new JPanel(new GridLayout(1, 2));
		leftGridContainer = new JPanel(new GridLayout(1, 2));

		categoryPane = new GUICategoryPanel(this, this.userID);
		feedPane = new GUIFeedPanel(this, this.userID);
		articlePane = new GUIArticlePanel(this, this.userID);

		leftGridContainer.add(categoryPane);
		leftGridContainer.add(feedPane);
		centerGridContainer.add(leftGridContainer);
		centerGridContainer.add(articlePane);

		add(centerGridContainer, BorderLayout.CENTER);

		categoryToolBar = new JToolBar("Category Tools");
		categoryToolBar.setBackground(new Color(115, 110, 144));
		//		feedToolBar = new JToolBar("Feed Tools");

		categoryAdd = new JButton("Add Category");
		categoryAdd.setBackground(new Color(164, 157, 208));
		categoryAdd.addActionListener(new ButtonListener());
		categoryRemove = new JButton("Remove Category");
		categoryRemove.setBackground(new Color(164, 157, 208));
		categoryRemove.addActionListener(new ButtonListener());
		feedAdd = new JButton("Add Feed");
		feedAdd.setBackground(new Color(164, 157, 208));
		feedAdd.addActionListener(new ButtonListener());
		feedRemove = new JButton("Remove Feed");
		feedRemove.setBackground(new Color(164, 157, 208));
		feedRemove.addActionListener(new ButtonListener());

		toolbarsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		toolbarsPanel.setBackground(new Color(115, 110, 144));

		categoryToolBar.add(categoryAdd);
		categoryToolBar.add(categoryRemove);
		categoryToolBar.add(feedAdd);
		categoryToolBar.add(feedRemove);

		toolbarsPanel.add(categoryToolBar);
		//		toolbarsPanel.add(feedToolBar);
		add(toolbarsPanel, BorderLayout.PAGE_START);

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
				categoryPane.addCategory(JOptionPane.showInputDialog(null,
						"Enter new category name:",
						"Add Category",
						JOptionPane.PLAIN_MESSAGE));
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
				String[] feeds = RWToDatabase.getFeedList();
				String feedToAdd = (String) JOptionPane.showInputDialog(
						null,
						"Choose feed to add:",
						"Add Feed",
						JOptionPane.PLAIN_MESSAGE,
						null,
						feeds,
						feeds[0]);
				String[] categories = RWToDatabase.getUsersCategoryList(userID);
				String categoryForFeed = (String) JOptionPane.showInputDialog(
						null,
						"Choose the category, which feed will be added to:",
						"Add Feed",
						JOptionPane.PLAIN_MESSAGE,
						null,
						categories,
						categories[0]);
				feedPane.addFeed(feedToAdd, categoryForFeed);
			}

			//			if (event.getSource() == feedRemove) {
			//				
			//			}

		}
	}

}
