import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
	
	public static void main(String argv[]) {
		
		File xmlFile = new File("NewFile.xml");
		DomXMLParser domParser = new DomXMLParser();
		DomXMLParser domInner = new DomXMLParser();
		domParser.parseFile(xmlFile);

		List<String> resultList = new ArrayList<String>();
		int recordsNumber = domParser.getValues("Artist").size();
		
		for(int i=0; i<recordsNumber; i++){
			domInner.parseString(domParser.getValues("Artist").get(i));
			resultList.add(domInner.getAttributes("Name", "Text") + " " + domInner.getAttributes("Surname", "Text"));
			resultList.addAll(domInner.getAttributes("Origin", "Text"));
		}
		
		for(String s: resultList){
			System.out.println(s);
		}
	}
}