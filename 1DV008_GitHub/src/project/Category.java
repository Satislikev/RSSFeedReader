package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category implements Comparable<Category> {
	private String title;
	public List<Feed> feeds;

	public Category(String title) {
		this.title = title;
		feeds = new ArrayList<Feed>();
	}

	public void addFeed(Feed feed) {
		feeds.add(feed);
	}

	public void removeFeed(Feed feed) {
		if (hasFeed(feed))
			feeds.remove(feed);
		else
			System.out.println("Feed does not exist"); // should be in the form of a popup window 
													   // or something similar in the GUI.
	}

	public boolean hasFeed(Feed feed) {
		if (feeds.contains(feed))
			return true;
		else
			return false;
	}

	public void sortFeeds() {
		Collections.sort(feeds);
	}

	public int compareTo(Category other) {
		return title.compareTo(other.title);
	}
}
