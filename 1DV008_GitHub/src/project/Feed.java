package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Feed implements Comparable<Feed> {
	private String feedTitle;
	private Path feedPath;
	private Date feedPubDate;
	private List<Article> articles;

	public Feed(String title, Date pubDate, String path, ArrayList<Article> articles) {
		this.feedTitle = title;
		this.feedPubDate = pubDate;
		this.feedPath = Paths.get(path, null);
		this.articles = new ArrayList<Article>();
		this.articles = articles;
	}

	public String getTitle() {
		return feedTitle;
	}

	public void setTitle(String title) {
		this.feedTitle = title;
	}

	public Path getPath() {
		return feedPath;
	}

	public void setPath(Path path) {
		this.feedPath = path;
	}

	public Date getDate() {
		return feedPubDate;
	}

	public void setDate(Date date) {
		this.feedPubDate = date;
	}

	public String toString() {
		return "Feed [title: " + feedTitle + " Feed Path: " + feedPath + " Feed date: " + feedPubDate;
	}

	public int compareTo(Feed other) {
		return feedPubDate.compareTo(other.feedPubDate);
	}

}
