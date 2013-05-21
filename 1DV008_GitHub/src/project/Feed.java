package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;




public class Feed implements Comparable<Feed> {
	private String feedTitle;
	private Path feedPath;
	private Date feedPubDate;
	private List<Article> articles;

	public Feed(String title, Date pubDate, String path, List<Article> articles) {
		this.feedTitle = title;
		this.feedPubDate = pubDate;
		this.feedPath = Paths.get(path);
		this.articles = new ArrayList<Article>();
		this.articles = articles;
	}

	public String getFeedTitle() {
		return feedTitle;
	}

	public void setFeedTitle(String title) {
		this.feedTitle = title;
	}

	public Path getFeedPath() {
		return feedPath;
	}

	public void setFeedPath(Path path) {
		this.feedPath = path;
	}

	public Date getFeedPubDate() {
		return feedPubDate;
	}

	public void setFeedPubDate(Date date) {
		this.feedPubDate = date;
	}
	@Override
	public String toString() {
		return "Feed [title: " + feedTitle + " Feed Path: " + feedPath.toString() + " Feed date: " + feedPubDate + "]\n" ;
	}
	
	public String articleToString (){
		StringBuilder allArticles = new StringBuilder();
		for(int i =0;i<articles.size();i++){
			allArticles.append(articles.get(i));
		}
		return allArticles.toString();
	}

	public int compareTo(Feed other) {
		return feedPubDate.compareTo(other.feedPubDate);
	}

}
