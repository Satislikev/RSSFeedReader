 package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class ImportParser {

	private static final String PATH = "Path";
	private static List<Feed> feeds;
	private static String feedPath = "";
	private static File file = null;

	/**
	 * @param ExportedFile Gets a exported file.
	 * @return List of feeds.
	 */
	public static List<Feed> parseExportedFile(File ExportedFile) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		try {
			Reader fileReader = new FileReader(ExportedFile);
			XMLEventReader reader = inputFactory.createXMLEventReader(fileReader);

			feeds = new ArrayList<Feed>();
			while (reader.hasNext()) {
				XMLEvent event = reader.nextEvent();
				if (event.isStartElement()) {
					StartElement element = (StartElement) event;
					// //System.out.println(element.getName().getLocalPart());
					switch (element.getName().getLocalPart()) {
					/*If element = path then*/
					case PATH:
						event = reader.nextEvent();
						if (event instanceof Characters) {
							feedPath = event.asCharacters().getData();
						}
						file = new File(feedPath);
						feeds.add(FeedParser.ParseFeed(file));
						// System.out.println(element.getName().getLocalPart()
						// +"\n" +feedTitle);

					}
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return feeds;

	}

}
