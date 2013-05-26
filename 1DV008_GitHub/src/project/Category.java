 package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kamyar_Aflaki Ali_Khalili Uraz_Seddigh 
 *
 */
public class Category implements Comparable<Category> {
	private String title;
	private List<Feed> feeds;

	/**
	 * @param title Category's title.
	 */
	public Category(String title) {
		this.title = title;
		feeds = new ArrayList<Feed>();
	}
	public Category(){}

	/**
	 * @param feed Feed to be added.
	 */
	public void addFeed(Feed feed) {
		feeds.add(feed);
	}

	/**
	 * @param feed Feed to be removed.
	 */ 
	public void removeFeed(Feed feed) {
		if (hasFeed(feed))
			feeds.remove(feed);
		else
			System.out.println("Feed does not exist"); // should be in the form
														// of a popup window
														// or something similar
														// in the GUI.
	}

	/**
	 * @param feed Feed to be compared.
	 * @return True if feed exists, False if not.
	 */
	public boolean hasFeed(Feed feed) {
		if (feeds.contains(feed))
			return true;
		else
			return false;
	}

	public void sortFeeds() {
		Collections.sort(feeds);
	}

	/**
	 * @return A list of feeds.
	 */
	public List<Feed> getFeed() {
		return feeds;
	}

	/**
	 * @param feeds Feed's list to be set.
	 */
	public void setFeed(List<Feed> feeds) {
		this.feeds = feeds;
	}

	public int compareTo(Category other) {
		return title.compareTo(other.title);
	}
}
