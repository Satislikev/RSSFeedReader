package project;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUIFeedPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JScrollPane feedListScroll;
	private JList<String> feedList;
	private DefaultListModel<String> feedListModel;
	private String[] feedListArray;
	
	private GUIContainerPanel containerPane;
	private int userID;
//	private int index;
	private String selectedValue;
	
	public GUIFeedPanel(GUIContainerPanel containerPane, int userID) {
		this.containerPane = containerPane;
		this.userID = userID;
		
		feedList = new JList<String>();
//		feedList.setVisibleRowCount(46);
		feedList.setFixedCellWidth(170);
		feedList.setBackground(new Color(164, 157, 208));
		feedListModel = new DefaultListModel<String>();
		feedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		feedListScroll = new JScrollPane(feedList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		feedListScroll.setPreferredSize(new Dimension(190, 532));
		feedList.addListSelectionListener(new ListListener());
		add(feedListScroll);
		setBackground(new Color(115, 110, 144));
		setBorder(new TitledBorder(new EtchedBorder(), "Feeds"));
	}
	
	public void updateFeedList(int categoryID) {
		feedListArray = RWToDatabase.getCategorysFeedList(this.userID, categoryID);
		feedListModel.removeAllElements();
		int loop = 0;
		while (loop < feedListArray.length){
			feedListModel.addElement(feedListArray[loop]);
	        loop++;
	    }
//		feedList.setListData(feedListArray);
	}
	
	public void addFeed(String feedTitle) {
		RWToDatabase.addFeed(feedTitle, userID);
		feedListModel.addElement(feedTitle);
	}
	
	public void removeFeed(String feedTitle) {
		RWToDatabase.removeFeed(feedTitle, userID);
		feedListModel.removeElement(feedTitle);
	}
	
	class ListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			selectedValue = feedList.getSelectedValue();
			containerPane.showArticles(RWToDatabase.getFeedID(selectedValue));
		}
		
	}

}
