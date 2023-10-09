import java.util.UUID;

//Book Class
public class Book {
    String id;
    String title;
    String author;
    String genre;
    int publicationYear;
    int pages;
    String language;
    String publisher;

    public Book(String title, String author, String genre, int publicationYear, int pages, String language, String publisher) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.language = language;
        this.publisher = publisher;
        System.out.println("Book instance created. Book ID: " + this.id);
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
    }
    public void borrowBook() {
    }
    public void returnBook() {
    }
}