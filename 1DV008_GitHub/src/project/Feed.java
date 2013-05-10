package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Feed implements Comparable<Feed> {
	private String feedTitle;
	private String feedDescription;
	private String Copyright;
	private Path path;
	private Date feedPubDate; 

	private List<Article> articles;

	public Feed(String title, Date pubDate, String path,
			List<Article> articles) {
		this.feedTitle = title;
		this.feedPubDate = pubDate;
		this.path = Paths.get(path, null);
		this.articles = articles;
	}

	public String getTitle() {
		return feedTitle;
	}

	public void setTitle(String title) {
		this.feedTitle = title;
	}
	
	public String getDescription() {
		return feedDescription;
	}

	public void setDescription(String description) {
		this.feedDescription = description;
	}
	
	public String getCopyright() {
		return Copyright;
	}

	public void setCopyright(String copyright) {
		Copyright = copyright;
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
		return "Feed Title: " + feedTitle + " Feed Path: " + path + " Feed date: "
				+ feedPubDate;
	}

	public int compareTo(Feed feed) {
		return feedPubDate.compareTo(feed.feedPubDate);
	}

	// public int compareTo(Feed feed) {
	// String othertitle = feed.title;
	// return title.compareTo(othertitle);
	// }
}
