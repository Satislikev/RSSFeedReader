package project;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import project.GUICategoryPanel.ListListener;

public class GUIFeedPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JScrollPane feedListScroll;
	private JList<String> feedList;
	private String[] feedListArray;
	
	private GUIContainerPanel containerPane;
	private int userID;
	private int index;
	private String selectedValue;
	
	public GUIFeedPanel(GUIContainerPanel containerPane, int userID) {
		this.containerPane = containerPane;
		this.userID = userID;
		
		feedListArray = RWToDatabase.getCategorysFeedList(this.userID);
		feedList = new JList<String>(feedListArray);
		feedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		feedListScroll = new JScrollPane(feedList);
		feedList.addListSelectionListener(new ListListener());
		add(feedListScroll);
	}
	
	public void updateFeedList(int categoryID) {
		
	}
	
	class ListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			selectedValue = feedList.getSelectedValue();
			containerPane.showArticles(RWToDatabase.getFeedID(userID, selectedValue));
		}
		
	}

}
