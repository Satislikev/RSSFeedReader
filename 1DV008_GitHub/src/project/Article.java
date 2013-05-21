package project;

import java.util.Date;

public class Article {

	private String articleTitle;
	private String articleDescription;
	private Date articlePubDate;
	private String articleLink;

	public Article(String title, String description, Date pubDate,
			String articleLink) {
		this.articleTitle = title;
		this.articleDescription = description;
		this.articlePubDate = pubDate;
		this.articleLink = articleLink;
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

	public String getArticleLink() {
		return articleLink;
	}

	public void setArticleLink(String articleLink) {
		this.articleLink = articleLink;
	}

	public void setpubDate(Date pubDate) {
		this.articlePubDate = pubDate;
	}

	public String toString() {
		return "Title:" + articleTitle + "\nPub Date:" + articlePubDate
				+ "\nDescription=" + articleDescription + "\nLink="+ articleLink + "]\n";
	}

}
