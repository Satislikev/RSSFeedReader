package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project.Article;

public class ArticleTest {
	private String articleTitle;
	private String articleDescription;
	private Date articlePubDate;
	private String articleLink;
	private Article article;
	private Date date;
	
	
	@Before
	public void setUp() throws Exception {
		article = new Article();
	}

	@After
	public void tearDown() throws Exception {
		article = null;
	}

	@Test
	public void testGetTitle() {
		for(int i = 0; i<1000;i++){
			articleTitle = RandomStringUtils.random(10);
			article.setTitle(articleTitle);
			assertEquals(article.getTitle(), articleTitle);
		}
	}

	@Test
	public void testSetTitle() {
		for(int i = 0; i<1000;i++){
			articleTitle = RandomStringUtils.random(10);
			article.setTitle(articleTitle);
			assertEquals(article.getTitle(), articleTitle);
		}
	}

	@Test
	public void testGetDescription() {
		for(int i = 0; i<1000;i++){
			articleDescription = RandomStringUtils.random(10);
			article.setDescription(articleDescription);
			assertEquals(article.getDescription(), articleDescription);
		}
	}

	@Test
	public void testSetDescription() {
		for(int i = 0; i<1000;i++){
			articleDescription = RandomStringUtils.random(10);
			article.setDescription(articleDescription);
			assertEquals(article.getDescription(), articleDescription);
		}
	}

	@Test
	public void testGetpubDate() {
		Random ran =  new  Random();
		for(int i = 0; i<1000;i++){
			date = new Date(ran.nextLong());
			article.setpubDate(date);
			assertEquals(article.getpubDate(), date);
		}
	}

	@Test
	public void testGetArticleLink() {
		for(int i = 0; i<1000;i++){
			articleLink = RandomStringUtils.random(10);
			article.setArticleLink(articleLink);
			assertEquals(article.getArticleLink(), articleLink);
		}
	}

	@Test
	public void testSetArticleLink() {
		for(int i = 0; i<1000;i++){
			articleLink = RandomStringUtils.random(10);
			article.setArticleLink(articleLink);
			assertEquals(article.getArticleLink(), articleLink);
		}
	}

	@Test
	public void testSetpubDate() {
		Random ran =  new  Random();
		for(int i = 0; i<1000;i++){
			date = new Date(ran.nextLong());
			article.setpubDate(date);
			assertEquals(article.getpubDate(), date);
		}
	}


}
