package dao;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by Marion on 9/15/2014.
 */
public interface Query {
    String getValue(String URI,String query, String object) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException;
}
