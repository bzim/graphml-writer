import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TestUtils {
	private TestUtils(){}

	public static void formatXMLFile(String file) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(new InputSource(new InputStreamReader(new FileInputStream(
	        file))));
	
	    Transformer xformer = TransformerFactory.newInstance().newTransformer();
	    xformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    xformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    xformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	    Source source = new DOMSource(document);
	    Result result = new StreamResult(new File(file));
	    xformer.transform(source, result);
	  }
}
