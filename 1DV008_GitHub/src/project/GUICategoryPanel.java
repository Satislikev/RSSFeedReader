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

public class GUICategoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JScrollPane categoryListScroll;
	private JList<String> categoryList;
	private DefaultListModel<String> categoryListModel;
	private String[] categoryListArray;
	
	private GUIContainerPanel containerPane;
	private int userID;
//	private int index;
	private String selectedValue;
	
	public GUICategoryPanel(GUIContainerPanel containerPane, int userID) {
		this.containerPane = containerPane;
		this.userID = userID;
		
		categoryListArray = RWToDatabase.getUsersCategoryList(this.userID);
		categoryListModel = new DefaultListModel<String>();
		categoryList = new JList<String>(categoryListModel);
		for (String element : categoryListArray)
			categoryListModel.addElement(element);
//		categoryList.setVisibleRowCount(46);
		categoryList.setFixedCellWidth(170);
		categoryList.setBackground(new Color(164, 157, 208));
		categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryListScroll = new JScrollPane(categoryList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		categoryListScroll.setViewportView(categoryList);
		categoryListScroll.setPreferredSize(new Dimension(190, 532));
		categoryList.addListSelectionListener(new ListListener());
		add(categoryListScroll);
		setBackground(new Color(115, 110, 144));
		setBorder(new TitledBorder(new EtchedBorder(), "Categories"));
	}
	
	public void addCategory(String categoryName) {
		RWToDatabase.addCategory(categoryName, userID);
		categoryListModel.addElement(categoryName);
	}
	
	// Will be implemented in the future.
	public void renameCategory(String oldCategoryName, String newCategoryName) {
		
	}
	
	public void removeCategory(String categoryName) {
		RWToDatabase.removeCategory(categoryName, userID);
		categoryListModel.removeElement(categoryName);
	}
	
	class ListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			selectedValue = categoryList.getSelectedValue();
			containerPane.showFeeds(RWToDatabase.getCategoryID(selectedValue));
		}
		
	}

}
