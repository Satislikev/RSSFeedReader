package project;

import java.io.File;

public class DataPopulatorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File CNN = new File("FeedFiles/CNN.rss");
		File EURONEWS = new File("FeedFiles/EURONEWS.rss");
		File BBC = new File("FeedFiles/BBC.rss");
		File PINKFLOYD = new File("FeedFiles/PinkFloyd.rss");
		
		DataPopulator.createFeed(PINKFLOYD);
		DataPopulator.createFeed(EURONEWS);
		DataPopulator.createFeed(CNN);
		DataPopulator.createFeed(BBC);
	}

}
