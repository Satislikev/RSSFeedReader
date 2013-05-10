package project;

import java.util.Date;

public class Article {

	private String articleTitle;
	private String articleDescription;
	private Date articlePubDate; 

	public Article(String title, String description, Date pubDate) {
		this.articleTitle = title;
		this.articleDescription = description;
		this.articlePubDate = pubDate;
	}

	public String getTitle() {
		return articleTitle;
	}

	public void setTitle(String title) {
		this.articleTitle = title;
	}

	public String getDescription() {
		return articleDescription;
	}

	public void setDescription(String description) {
		this.articleDescription = description;
	}

	public Date getpubDate() {
		return articlePubDate;
	}

	public void setpubDate(Date pubDate) {
		this.articlePubDate = pubDate;
	}

	public String toString() {
		return "ArticleClass[title=" + articleTitle + ", description=" + articleDescription
				+ ", author=" + articlePubDate.toString() + " ]";

	}

}
