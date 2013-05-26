 package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;


public class FeedParser {

	private static final String TITLE = "title";
	private static final String DESCRIPTION = "description";
	private static final String ITEM = "item";
	private static final String PUB_DATE = "pubDate";
	private static final String LINK = "link";
	private static final String IMAGE = "image";
	private static List<Article> articles;
	private static Article article;
	private static Feed feed;
	private static String articleTitle = "";
	private static String feedTitle="";
	private static String articleDescription = "";
	private static Date articlePubDate = null;
	private static Date feedPubDate = null;
	private static String articleLink = "";
	private static boolean header;
	private static boolean image;



	public static Feed ParseFeed(File rssfile) {
		header = true;
		 image = false;
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		try {
			Reader fileReader = new FileReader(rssfile);
			XMLEventReader reader = inputFactory
					.createXMLEventReader(fileReader);

			articles = new ArrayList<Article>();
			while (reader.hasNext()) {
				XMLEvent event = reader.nextEvent();
				if (event.isStartElement()) {
					StartElement element = (StartElement) event;
					//					//System.out.println(element.getName().getLocalPart());
					switch (element.getName().getLocalPart()) {
					case TITLE:
						if(header){
							event = reader.nextEvent();
							if (event instanceof Characters) {
								feedTitle = event.asCharacters().getData();
							}
							//System.out.println(element.getName().getLocalPart() +"\n" +feedTitle);
						}else{
							if(image){
								event =reader.nextEvent();
							}else{
								event = reader.nextEvent();
								if (event instanceof Characters) {
									articleTitle = event.asCharacters().getData();
								}
								//System.out.println(element.getName().getLocalPart() +"\n" +articleTitle);
							}
						}
						break;
					case DESCRIPTION:
						if(header){
							event = reader.nextEvent();
						}else{
							if(image){
								event =reader.nextEvent();
							}else{
								event = reader.nextEvent();
								if (event instanceof Characters) {
									articleDescription = event.asCharacters().getData();
								}
								//System.out.println(element.getName().getLocalPart() +"\n" +articleDescription);
							}
						}
						break;
					case PUB_DATE:
						if(header){
							event = reader.nextEvent();
							if (event instanceof Characters) {
								feedPubDate = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").parse(event.asCharacters().getData());
							}
							//System.out.println(element.getName().getLocalPart() +"\n" +feedPubDate.toString()+"\n");
						}else{
							event = reader.nextEvent();
							if (event instanceof Characters) {
								articlePubDate = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").parse(event.asCharacters().getData());
							}
							//System.out.println(element.getName().getLocalPart() +"\n" +articlePubDate.toString()+"\n");
						}
						break;
					case LINK:
						if(header){
							event = reader.nextEvent();
						}else{
							if(image){
								event =reader.nextEvent();
							}else{
								event = reader.nextEvent();
								if (event instanceof Characters) {
									articleLink = event.asCharacters().getData();
								}
								//System.out.println(element.getName().getLocalPart() +"\n" +articleLink);
							}
						}
						break;
					case ITEM:
						header = false;
						break;
					case IMAGE:
						image = true;
						header=false;
					}
				}if(event.isEndElement()){
					EndElement element = (EndElement) event;
					switch(element.getName().getLocalPart()){
					case ITEM:
						article = new Article(articleTitle, articleDescription, articlePubDate, articleLink);
						articles.add(article);
						break;
					case IMAGE:
						image= false;

					}
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		feed = new Feed(feedTitle, feedPubDate, rssfile.getPath(), articles);
					System.out.println(feed.toString());

		return feed;

	}


}




