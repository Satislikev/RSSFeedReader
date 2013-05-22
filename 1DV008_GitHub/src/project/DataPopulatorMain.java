package project;

import java.io.File;

public class DataPopulatorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File CNN = new File("/Users/Kami/Desktop/CNN.rss");
		DataPopulator.createUsers("Ray","Manzarek");
		DataPopulator.createFeed(CNN);
	}

}
