 package project;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * @author Kamyar_Aflaki Ali_Khalili Uraz_Seddigh 
 *
 */
public class XmlWriter {
	private String configFile;

	/**
	 * @param configFile Configuration file.
	 */
	public void setFile(String configFile) {
		this.configFile = configFile;
	}

	/**
	 * @param category Category.
	 * @throws Exception XML exceptions.
	 */
	public void Export(Category category) throws Exception {
		ArrayList<Feed> categoryFeeds = (ArrayList<Feed>) category.getFeed();
		// Create a XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// Create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory
				.createXMLEventWriter(new FileOutputStream(configFile));
		// Create a EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		// Create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);

		// Create config open tag
		StartElement configStartElement = eventFactory.createStartElement("",
				"", "Category");
		eventWriter.add(configStartElement);
		eventWriter.add(end);
		// Write the different nodes
		for (int i = 0; i < category.getFeed().size(); i++) {
			createNode(eventWriter, "Path", categoryFeeds.get(i).getFeedPath()
					.toString());
		}

		eventWriter.add(eventFactory.createEndElement("", "", "Category"));
		eventWriter.add(end);
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
	}

	/**
	 * @param eventWriter Event writer
	 * @param name Node's name.
	 * @param value Value of the node.
	 * @throws XMLStreamException
	 */
	private void createNode(XMLEventWriter eventWriter, String name,
			String value) throws XMLStreamException {

		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// Create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// Create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// Create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);

	}

}