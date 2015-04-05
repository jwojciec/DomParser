import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class DomXMLParser {
	DocumentBuilderFactory dbFactory = null;
	private DocumentBuilder dBuilder = null;
	private Document doc = null;

	public void parseFile(File xmlFile) {
		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xmlFile);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public void parseString(String xmlString) {
		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlString));
			doc = dBuilder.parse(is);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public List<String> getAttributes(String elementName, String attributeName) {
		NodeList list = doc.getElementsByTagName(elementName);
		List<String> alist = new ArrayList<String>();
		for (int i = 0; i < list.getLength(); i++) {
			Node nNode = list.item(i);
			Element eElement = (Element) nNode;
			alist.add(eElement.getAttribute(attributeName));
		}
		return alist;
	}
	
	public List<String> getValues(String elementName) {
		NodeList list = doc.getElementsByTagName(elementName);
		List<String> alist = new ArrayList<String>();
		for (int i = 0; i < list.getLength(); i++) {
			alist.add(list.item(i).getTextContent());
		}
		return alist;
	}

}
