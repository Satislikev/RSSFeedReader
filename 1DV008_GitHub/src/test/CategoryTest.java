package test;

import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project.Category;
import project.Feed;
import project.FeedParser;

public class CategoryTest {

	private String title;
	private List<Feed> feeds= new ArrayList<Feed>();
	private Category category;
	private File file = new File("/Users/Kami/Desktop/CNN.rss");
	private Feed feed;
	
	@Before
	public void setUp() throws Exception {
		category = new Category();
	}

	@After
	public void tearDown() throws Exception {
		category = null;
	}

	@Test
	public void testAddFeed() {
		for(int i = 0; i<10;i++){
			category.addFeed(FeedParser.ParseFeed(file));
		} 
		assertEquals(category.getFeed().size(),10);
	}

	@Test
	public void testHasFeed() {
		feed = FeedParser.ParseFeed(file);
		category.addFeed(feed);
		assertTrue(category.hasFeed(feed));
	}

	@Test
	public void testGetFeed() {
		for(int i = 0; i<10;i++){
			feed = FeedParser.ParseFeed(file);
			feeds.add(feed);
			category.addFeed(feed);
			assertEquals(category.getFeed(),feeds);
		} 
	}

	@Test
	public void testSetFeed() {
		for(int i = 0; i<10;i++){
			feed = FeedParser.ParseFeed(file);
			feeds.add(feed);
			category.setFeed(feeds);
			assertEquals(category.getFeed(),feeds);
		} 
	}

}
