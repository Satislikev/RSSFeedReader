package test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project.Category;
import project.Feed;

public class CategoryTest {

	private String title;
	private List<Feed> feeds;
	private Category category;
	
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
		for(int i = 0; i<1000;i++){
			
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
