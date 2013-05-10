package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Feed implements Comparable<Feed> {
	private String feedTitle;
	private Path path;
	private Date feedPubDate; 

	private List<Article> articles;

	
	public Feed(String title, Date pubDate, String path,
			List<Article> articles) {
		this.feedTitle = title;
		this.feedPubDate = pubDate;
	}

	public String getTitle() {
		return feedTitle;
	}

	public void setTitle(String title) {
		this.feedTitle = title;
	}
	

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public Date getDate() {
		return feedPubDate;
	}

	public void setDate(Date date) {
		this.feedPubDate = date;
	}

	public String toString() {
		return "Feed [title: " + feedTitle + " Feed Path: " + path + " Feed date: " + feedPubDate;
	}

	public int compareTo(Feed other) {
		return feedPubDate.compareTo(other.feedPubDate);
	}

	// public int compareTo(Feed feed) {
	// String othertitle = feed.title;
	// return title.compareTo(othertitle);
	// }
}
