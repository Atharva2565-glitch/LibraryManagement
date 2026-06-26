/**
 * Book.java
 * Represents one book in the library.
 * Stores details and whether it is currently issued to someone.
 */
class Book {

    // Unique number for each book (e.g. 101, 102)
    int bookId;

    // Title of the book
    String bookName;

    // Writer of the book
    String author;

    // Language the book is written in (e.g. English, Marathi)
    String language;

    // true = someone has borrowed this book; false = available on shelf
    boolean isIssued;

    // Name of student who borrowed the book (empty if not issued)
    String issuedTo;

    // Date when book was issued (empty if not issued)
    String issueDate;

    /**
     * Constructor — creates a new book with given details.
     * New books start as not issued.
     */
    Book(int id, String name, String author, String language) {

        this.bookId = id;
        this.bookName = name;
        this.author = author;
        this.language = language;

        // By default, book is available (not issued)
        this.isIssued = false;
        this.issuedTo = "";
        this.issueDate = "";
    }

    /**
     * Prints all details of this book to the console.
     */
    void displayBook() {

        System.out.println("--------------------------------");
        System.out.println("Book ID      : " + bookId);
        System.out.println("Book Name    : " + bookName);
        System.out.println("Author       : " + author);
        System.out.println("Language     : " + language);
        System.out.println("Issued       : " + (isIssued ? "Yes" : "No"));

        // Show borrower info only if book is currently issued
        if (isIssued) {
            System.out.println("Issued To    : " + issuedTo);
            System.out.println("Issue Date   : " + issueDate);
        }

        System.out.println("--------------------------------");
    }
}
