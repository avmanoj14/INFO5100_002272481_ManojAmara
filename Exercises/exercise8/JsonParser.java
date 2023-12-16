import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
            newBook.put("title", "New Book Title");
            newBook.put("publishedYear", "2023");
            newBook.put("numberOfPages", "300");

            // Create a JSONObject for the authors property
            JSONObject newAuthors = new JSONObject();
            newAuthors.put("author", "New Author");
            newBook.put("authors", newAuthors);

            // Add the new book JSONObject to the bookArray
            bookArray.add(newBook);

            // Print the updated JSON file
            System.out.println("\nUpdated JSON: " + jsonObject.toJSONString());

            // Write the updated JSON back to the file
            try (FileWriter fileWriter = new FileWriter("books.json")) {
                fileWriter.write(jsonObject.toJSONString());
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
