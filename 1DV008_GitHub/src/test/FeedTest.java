package test;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project.Article;
import project.Feed;

public class FeedTest {

	private String feedTitle;
	private Path feedPath;
	private Date feedPubDate;
	private List<Article> articles;
	private Feed feed;
	private Date date;
	
	
	@Before
	public void setUp() throws Exception {
		feed = new Feed();
	}

	@After
	public void tearDown() throws Exception {
		feed = null;
	}

	@Test
	public void testGetFeedTitle() {
		for(int i = 0; i<1000;i++){
			feedTitle = RandomStringUtils.random(10);
			feed.setFeedTitle(feedTitle);
			assertEquals(feed.getFeedTitle(), feedTitle);
		}
	}

	@Test
	public void testSetFeedTitle() {
		for(int i = 0; i<1000;i++){
			feedTitle = RandomStringUtils.random(10);
			feed.setFeedTitle(feedTitle);
			assertEquals(feed.getFeedTitle(), feedTitle);
		}
	}

	@Test
	public void testGetFeedPath() {
		for(int i = 0; i<1000;i++){
			feedPath = Paths.get(RandomStringUtils.randomAlphanumeric(10));
			feed.setFeedPath(feedPath);
			assertEquals(feed.getFeedPath(), feedPath);
		}
	}

	@Test
	public void testSetFeedPath() {
		for(int i = 0; i<1000;i++){
			feedPath = Paths.get(RandomStringUtils.randomAlphanumeric(10));
			feed.setFeedPath(feedPath);
			assertEquals(feed.getFeedPath(), feedPath);
		}
	}

	@Test
	public void testGetFeedPubDate() {
		Random ran =  new  Random();
		for(int i = 0; i<1000;i++){
			date = new Date(ran.nextLong());
			feed.setFeedPubDate(date);
			assertEquals(feed.getFeedPubDate(), date);
		}
	}

	@Test
	public void testSetFeedPubDate() {
		Random ran =  new  Random();
		for(int i = 0; i<1000;i++){
			date = new Date(ran.nextLong());
			feed.setFeedPubDate(date);
			assertEquals(feed.getFeedPubDate(), date);
		}
	}

}
