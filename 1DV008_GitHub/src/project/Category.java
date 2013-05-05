package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category implements Comparable<Category> {
	private String title;
	private List<Feed> feeds;

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
			System.out.println("Feed does not exist");
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

	@Override
	public int compareTo(Category category) {
		return this.title.compareTo(category.title);
	}
}
