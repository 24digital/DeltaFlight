package dao;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import utility.StandardURIQuery;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;

@Service
public class QueryDB implements Query {

    private final StandardURIQuery standardURIQuery = new StandardURIQuery();

    public String getValue(String URI,String query, String object, String nm) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {

        // grab the input stream associated with the content

        // establish an inputStreamReader and tell it the data is in UTF-8

        //read a character at a time, appending into the StringBuffer

        // convert the returned data into a DOM

        //   xpath.setNamespaceContext(  "exist", namespaceURI  );


        return standardURIQuery.getValue(URI, query, object, nm);
    }

    public static class Twitter implements Query
    {

        @Override
        public String getValue(String URI, String query, String object, String nm) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
            StandardURIQuery query1 = new StandardURIQuery();
            return query1.getValue(URI, query,object, nm);
        }
    }
    public static void main(String args[]) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        Twitter twitter = new Twitter();
        System.out.println(twitter.getValue("http://twitter.com/search","?q=8&src=typd "," ",""));
        System.out.println("Hi");
    }
}
