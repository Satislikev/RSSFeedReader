package project;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUICategoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JScrollPane categoryListScroll;
	private JList<String> categoryList;
	private String[] categoryListArray;
	
	private GUIContainerPanel containerPane;
	private int userID;
	private int index;
	private String selectedValue;
	
	public GUICategoryPanel(GUIContainerPanel containerPane, int userID) {
		this.containerPane = containerPane;
		this.userID = userID;
		
		categoryListArray = RWToDatabase.getUsersCategoryList(this.userID);
		categoryList = new JList<String>(categoryListArray);
		categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryListScroll = new JScrollPane(categoryList);
		categoryList.addListSelectionListener(new ListListener());
		add(categoryListScroll);
	}
	
	public void addCategory(String categoryName) {
		
	}
	
	public void renameCategory(String oldCategoryName, String newCategoryName) {
		
	}
	
	public void removeCategory(String categoryName) {
		
	}
	
	class ListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			selectedValue = categoryList.getSelectedValue();
			containerPane.showFeeds(RWToDatabase.getCategoryID(selectedValue));
		}
		
	}

}
