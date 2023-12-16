import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringWriter;

public class XmlParser {
  public static void main(String[] args)
      throws ParserConfigurationException, SAXException, IOException, TransformerException {
    try {
      // Parse the XML document
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse("books.xml");

      // Print the output of the XML parser
      NodeList books = document.getElementsByTagName("Book");
      for (int i = 0; i < books.getLength(); i++) {
        Element book = (Element) books.item(i);
        String title = book.getElementsByTagName("title").item(0).getTextContent();
        String publishedYear = book.getElementsByTagName("publishedYear").item(0).getTextContent();
        String numberOfPages = book.getElementsByTagName("numberOfPages").item(0).getTextContent();
        String author = book.getElementsByTagName("author").item(0).getTextContent();

        System.out.println("Title: " + title);
        System.out.println("Published Year: " + publishedYear);
        System.out.println("Number of Pages: " + numberOfPages);
        System.out.println("Author: " + author);
      }

      // Add a new book element to the document
      Element newBookElement = document.createElement("book");
      Element titleElement = document.createElement("title");
      titleElement.setTextContent("Moby-Dick");
      newBookElement.appendChild(titleElement);
      Element publishedYearElement = document.createElement("publishedYear");
      publishedYearElement.setTextContent("1851");
      newBookElement.appendChild(publishedYearElement);
      Element numberOfPagesElement = document.createElement("numberOfPages");
      numberOfPagesElement.setTextContent("732");
      newBookElement.appendChild(numberOfPagesElement);
      Element authorElement = document.createElement("author");
      authorElement.setTextContent("Herman Melville");
      newBookElement.appendChild(authorElement);

      if (books.getLength() > 0) {
        Element booksElement = (Element) books.item(0);
        booksElement.appendChild(newBookElement);
      }

      // Convert the Document to a String
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      StringWriter writer = new StringWriter();
      transformer.transform(new DOMSource(document), new StreamResult(writer));
      String xmlString = writer.getBuffer().toString();

      // Print the XML string to the console
      System.out.println(xmlString);

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (TransformerException e) {
      e.printStackTrace();
    }
  }
}
