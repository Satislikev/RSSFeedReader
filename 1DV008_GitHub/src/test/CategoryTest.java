package test;

import static org.junit.Assert.fail;
import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project.Category;
import project.Feed;
import project.FeedParser;

public class CategoryTest {

	private String title;
	private List<Feed> feeds;
	private Category category;
	private File file;
	
	@Before
	public void setUp() throws Exception {
		category = new Category();
		file = new File("/Users/Kami/Desktop/CNN.rss");
	}

	@After
	public void tearDown() throws Exception {
		category = null;
	}

	@Test
	public void testAddFeed() {
		for(int i = 0; i<1000;i++){
			category.addFeed(FeedParser.ParseFeed(file));
		} 
		
	}

	@Test
	public void testRemoveFeed() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasFeed() {
		fail("Not yet implemented");
	}

	@Test
	public void testSortFeeds() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFeed() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFeed() {
		fail("Not yet implemented");
	}

}
