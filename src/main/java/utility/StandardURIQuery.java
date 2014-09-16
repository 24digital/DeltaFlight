package utility;

import dao.Query;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class StandardURIQuery implements Query {
    public StandardURIQuery() {
    }

    public String getValue(String URI, String query, String object, String nameSpace) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
      //Concatenate to an URI
        String serviceAddress = URI + query + object ;

        URL URL = new URL(serviceAddress);

        //Open a HTTP Connection
        HttpURLConnection connection = (HttpURLConnection) URL.openConnection();

        //Set HTTP Method
        connection.setRequestMethod("GET");

        //Connect to URI
        connection.connect();

        // grab the input stream associated with the content
        InputStream in = connection.getInputStream();

        StringBuffer sb = new StringBuffer();

        // establish an inputStreamReader and tell it the data is in UTF-8
        Reader reader = new InputStreamReader(in, "UTF-8");
        int c;

        //read a character at a time, appending into the StringBuffer
        while ((c = reader.read()) != -1) sb.append((char) c);

        connection.disconnect();

       System.out.println("StandardURI + " +sb);

        // convert the returned data into a DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder parser = factory.newDocumentBuilder();

        InputSource inputSource = new InputSource(new StringReader(sb.toString()));
        Document xmldoc = parser.parse(inputSource);

        XPath xpath = XPathFactory.newInstance().newXPath();
        String namespaceURI = nameSpace;
          xpath.setNamespaceContext(new NameSpaceURImpl( "exist", namespaceURI)  );

        return (String) xpath.evaluate("//exist:value/text()", xmldoc, XPathConstants.STRING);


    }


}