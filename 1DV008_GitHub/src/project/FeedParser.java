package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.InputSource;

public class FeedParser {

	private static final String TITLE = "title";
	private static final String DESCRIPTION = "description";
	private static final String ITEM = "item";
	private static final String PUB_DATE = "pubDate";
	private static final String LAST_BUILD_DATE = "lastBuildDate";
	private List<Article> articles;
	private Article article;
	private Feed feed;
	private String articleTitle = "";
	private String feedTitle="";
	private String articleDescription = "";
	private String feedPath = "";
	private Date articlePubDate = null;
	private Date feedPubDate = null;
	private String articleLink = "";

	static final File FILE = null;

	public Feed ParseFeed(File rssfile) {

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		try {
			Reader fileReader = new FileReader("FILEHERE");
			XMLEventReader reader = inputFactory
					.createXMLEventReader(fileReader);

			

			articles = new ArrayList<Article>();

			while (reader.hasNext()) {
				XMLEvent event = reader.nextEvent();
				if (event.isStartElement()) {
					StartElement element = (StartElement) event;
					switch (element.getName().getLocalPart()) {
					case TITLE:
						feed.setTitle(element.asCharacters().getData());
						System.out.println(feed.getTitle());
						break;
					// case DESCRIPTION:
					// feed.setDescription(element.asCharacters().getData());
					// System.out.println(feed.getDescription());
					// break;

					case ITEM:

						break;

					}
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;

	}

}
