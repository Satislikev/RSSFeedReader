 package project;

import java.util.Date;

/**
 * @author Kamyar_Aflaki Ali_Khalili Uraz_Seddigh 
 *
 */
public class Article {

	private String articleTitle;
	private String articleDescription;
	private Date articlePubDate;
	private String articleLink;

	/**
	 * @param title Article title.
	 * @param description Article description.
	 * @param pubDate Article published date.
	 * @param articleLink Article link.
	 */
	public Article(String title, String description, Date pubDate,
			String articleLink) {
		this.articleTitle = title;
		this.articleDescription = description;
		this.articlePubDate = pubDate;
		this.articleLink = articleLink;
	}
	public Article(){}

	/**
	 * @return Article title.
	 */
	public String getTitle() {
		return articleTitle;
	}

	/**
	 * @param title Article title.
	 */
	public void setTitle(String title) {
		this.articleTitle = title;
	}

	/**
	 * @return Article description.
	 */
	public String getDescription() {
		return articleDescription;
	}

	/**
	 * @param description Article description.
	 */
	public void setDescription(String description) {
		this.articleDescription = description;
	}

	/**
	 * @return Article published date.
	 */
	public Date getpubDate() {
		return articlePubDate;
	}

	/**
	 * @return Article published date.
	 */
	public String getArticleLink() {
		return articleLink;
	}

	/**
	 * @param articleLink Article link.
	 */
	public void setArticleLink(String articleLink) {
		this.articleLink = articleLink;
	}

	/**
	 * @param pubDate Article link.
	 */
	public void setpubDate(Date pubDate) {
		this.articlePubDate = pubDate;
	}

	public String toString() {
		return "\nTitle: " + articleTitle + "\nPub Date: " + articlePubDate
				+ "\nDescription: " + articleDescription + "\nLink: "+ articleLink ;
	}

}
