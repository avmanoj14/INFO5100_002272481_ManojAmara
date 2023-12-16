import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonParser {
    public static void main(String[] args) throws IOException, ParseException {
        try {
            // Parse the JSON file
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(new File("books.json")));
            System.out.println(jsonObject.toString());

            // Retrieve the BookShelf object from the jsonObject
            JSONObject bookShelf = (JSONObject) jsonObject.get("BookShelf");

            // Retrieve the Book array from the BookShelf object
            JSONArray bookArray = (JSONArray) bookShelf.get("Book");

            // Print the output of the JSON parser
            for (int i = 0; i < bookArray.size(); i++) {
                // Use the get(i) method with an integer index to get each book object
                // from the array
                JSONObject book = (JSONObject) bookArray.get(i);
                String title = (String) book.get("title");
                String publishedYear = (String) book.get("publishedYear");
                String numberOfPages = (String) book.get("numberOfPages");
                JSONObject authors = (JSONObject) book.get("authors");
                String author = (String) authors.get("author");

                System.out.println("Title: " + title);

                System.out.println("Published Year: " + publishedYear);
                System.out.println("Number of Pages: " + numberOfPages);
                System.out.println("Author: " + author);
            }

            // Create a new JSONObject representing the book
            JSONObject newBook = new JSONObject();

            // Set the properties of the new book
            newBook.put("title", "Moby-Dick");
            newBook.put("publishedYear", "1851");
            newBook.put("numberOfPages", "732");

            // Create a JSONObject for the authors property
            JSONObject newAuthors = new JSONObject();
            newBook.put("authors", new JSONObject().put("author", "Herman Melville"));

            // Add the authors JSONObject to the book JSONObject
            newBook.put("authors", newAuthors);

            // Add the new book JSONObject to the bookArray
            bookArray.add(newBook);

            // Print the updated bookArray
            // System.out.println("\nBookArray: " + bookArray.toString());

            // Print the updated JSON file
            System.out.println("\nupdated JSON: " + jsonObject.toJSONString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}