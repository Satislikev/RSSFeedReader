package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Feed implements Comparable<Feed> {
	private String title;
	private Path path;
	private Date pubDate;
	private List<Article> articles;

	public Feed(String title, Date pubDate, String path,
			ArrayList<Article> articles) {
		this.title = title;
		this.pubDate = pubDate;
		this.path = Paths.get(path, null);
		this.articles = articles;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public Date getDate() {
		return pubDate;
	}

	public void setDate(Date date) {
		this.pubDate = date;
	}

	public String toString() {
		return "Feed Title: " + title + " Feed Path: " + path + " Feed date: "
				+ pubDate;
	}

	public int compareTo(Feed feed) {
		return pubDate.compareTo(feed.pubDate);
	}

	// public int compareTo(Feed feed) {
	// String othertitle = feed.title;
	// return title.compareTo(othertitle);
	// }
}
