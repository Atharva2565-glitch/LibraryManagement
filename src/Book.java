package src;

/**
 * Book.java
 * Represents one book in the library.
 */
public class Book {

    // Book Details
   public int bookId;
    public String bookName;
    public String author;
    public String language;

    // Issue Details
    public boolean isIssued;
    public String issuedTo;
    public String issueDate;

    // Constructor
    public Book(int id, String name, String author, String language) {

        this.bookId = id;
        this.bookName = name;
        this.author = author;
        this.language = language;

        this.isIssued = false;
        this.issuedTo = "";
        this.issueDate = "";
    }

    // Display Book Details
    public void displayBook() {

        System.out.println("--------------------------------");
        System.out.println("Book ID      : " + bookId);
        System.out.println("Book Name    : " + bookName);
        System.out.println("Author       : " + author);
        System.out.println("Language     : " + language);
        System.out.println("Issued       : " + (isIssued ? "Yes" : "No"));

        if (isIssued) {
            System.out.println("Issued To    : " + issuedTo);
            System.out.println("Issue Date   : " + issueDate);
        }

        System.out.println("--------------------------------");
    }
}