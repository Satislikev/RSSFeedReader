package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Feed implements Comparable<Feed> {
	private String title;
	private Path path;
	private String copyright;
	private Date pubDate;
	private List<Article> articles;

	public Feed(String title, String copyright, Date pubDate, String path, ArrayList<Article> articles) {
		this.title = title;
		this.copyright = copyright;
		this.pubDate = pubDate;
		this.path = Paths.get(path, null);
		this.articles = new ArrayList<Article>();
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

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Date getDate() {
		return pubDate;
	}

	public void setDate(Date date) {
		this.pubDate = date;
	}

	public String toString() {
		return "Feed [title: " + title + " Feed Path: " + path + " Feed date: " + pubDate;
	}

	public int compareTo(Feed other) {
		return pubDate.compareTo(other.pubDate);
	}

	// public int compareTo(Feed feed) {
	// String othertitle = feed.title;
	// return title.compareTo(othertitle);
	// }
}
