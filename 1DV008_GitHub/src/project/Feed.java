 package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kamyar_Aflaki Ali_Khalili Uraz_Seddigh 
 *
 */
public class Feed implements Comparable<Feed> {
	private String feedTitle;
	private Path feedPath;
	private Date feedPubDate;
	private List<Article> articles;

	/**
	 * @param title Feed's title.
	 * @param pubDate Feed's published date.
	 * @param path Feed's path
	 * @param articles Feed's article.
	 */
	public Feed(String title, Date pubDate, String path, List<Article> articles) {
		this.feedTitle = title;
		this.feedPubDate = pubDate;
		this.feedPath = Paths.get(path);
		this.articles = new ArrayList<Article>();
		this.articles = articles;
	}
	
	public Feed(){}

	/**
	 * @return Feed's title.
	 */
	public String getFeedTitle() {
		return feedTitle;
	}

	/**
	 * @param title Feed's title.
	 */
	public void setFeedTitle(String title) {
		this.feedTitle = title;
	}

	/**
	 * @return Feed's Path.
	 */
	public Path getFeedPath() {
		return feedPath;
	}

	/**
	 * @param path Feed's Path.
	 */
	public void setFeedPath(Path path) {
		this.feedPath = path;
	}

	/**
	 * @return Feed's published date.
	 */
	public Date getFeedPubDate() {
		return feedPubDate;
	}

	/**
	 * @param date Feed's published date.
	 */
	public void setFeedPubDate(Date date) {
		this.feedPubDate = date;
	}
	@Override
	public String toString() {
		return "Feed [title: " + feedTitle + " Feed Path: " + feedPath.toString() + " Feed date: " + feedPubDate + "]\n" ;
	}
	
	/**
	 * @return All articles in a single string.
	 */
	public String articleToString (){
		StringBuilder allArticles = new StringBuilder();
		for(int i = 0; i < articles.size(); i++){
			allArticles.append(articles.get(i));
//			System.out.println(articles.get(i));
			allArticles.append("\n");
		}
		return allArticles.toString();
	}

	public int compareTo(Feed other) {
		return feedPubDate.compareTo(other.feedPubDate);
	}

}
