// Scanner — read input from keyboard (menu choice, book details, login)
import java.util.ArrayList;
import java.util.Scanner;

// FileReader, FileWriter, etc. — save and load books from books.txt
import java.io.*;

// LocalDate — store today's date when a book is issued
import java.time.LocalDate;

/**
 * Main.java
 * Library Management System — console menu to add, search, issue, and return books.
 */
public class Main {

    // List of all books in the library (loaded from file + sample data)
    static ArrayList<Book> books = new ArrayList<>();

    // Single Scanner used everywhere for user input
    static Scanner sc = new Scanner(System.in);

    // File where book data is stored (comma-separated lines)
    static final String BOOKS_FILE = "books.txt";

    /**
     * Program entry point — shows title, login, loads books, then main menu loop.
     */
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" LIBRARY MANAGEMENT SYSTEM ");
        System.out.println("=================================");

        // Must enter correct username/password before using the system
        login();

        // Try to read saved books from books.txt
        loadBooks();

        // If file was empty or missing, add sample books once and save them
        if (books.isEmpty()) {
            addSampleBooks();
            saveBooks();
        }

        int choice;

        // Repeat menu until user chooses 9 (Exit)
        do {
            showMenu();
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            // Run the action matching the user's menu number
            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    searchBookByName();
                    break;

                case 4:
                    searchBookById();
                    break;

                case 5:
                    issueBook();
                    break;

                case 6:
                    returnBook();
                    break;

                case 7:
                    searchByAuthor();
                    break;

                case 8:
                    displayBooksByLanguage();
                    break;

                case 9:
                    saveBooks();
                    System.out.println("Thank You For Using Library Management System");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 9);
    }

    /** Prints the main menu options (1–9). */
    static void showMenu() {
        System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
        System.out.println("1. Add Book");
        System.out.println("2. Display Books");
        System.out.println("3. Search Book By Name");
        System.out.println("4. Search Book By ID");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Search By Author");
        System.out.println("8. Search Book By Language");
        System.out.println("9. Exit");
    }

    /**
     * Adds default sample books when the library file has no data yet.
     */
    static void addSampleBooks() {
        books.add(new Book(101, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "English"));
        books.add(new Book(102, "The Lord of the Rings", "J.R.R. Tolkien", "English"));
        books.add(new Book(103, "The Hobbit", "J.R.R. Tolkien", "English"));
        books.add(new Book(104, "Pride and Prejudice", "Jane Austen", "English"));
        books.add(new Book(105, "To Kill a Mockingbird", "Harper Lee", "English"));
        books.add(new Book(106, "The Alchemist", "Paulo Coelho", "English"));
        books.add(new Book(107, "The Da Vinci Code", "Dan Brown", "English"));
        books.add(new Book(108, "1984", "George Orwell", "English"));
        books.add(new Book(109, "Animal Farm", "George Orwell", "English"));
        books.add(new Book(110, "The Great Gatsby", "F. Scott Fitzgerald", "English"));

        books.add(new Book(201, "Ramayana", "Valmiki", "Sanskrit"));
        books.add(new Book(202, "Mahabharata", "Vyasa", "Sanskrit"));
        books.add(new Book(203, "Bhagavad Gita", "Vyasa", "Sanskrit"));
        books.add(new Book(204, "Wings of Fire", "A.P.J. Abdul Kalam", "English"));
        books.add(new Book(205, "The Discovery of India", "Jawaharlal Nehru", "English"));
        books.add(new Book(206, "Train to Pakistan", "Khushwant Singh", "English"));

        books.add(new Book(301, "Shyamchi Aai", "Sane Guruji", "Marathi"));
        books.add(new Book(302, "Mrityunjay", "Shivaji Sawant", "Marathi"));
        books.add(new Book(303, "Yayati", "V. S. Khandekar", "Marathi"));
        books.add(new Book(304, "Batatyachi Chaal", "P. L. Deshpande", "Marathi"));
        books.add(new Book(305, "Kosala", "Bhalchandra Nemade", "Marathi"));

        books.add(new Book(401, "Don Quixote", "Miguel de Cervantes", "Spanish"));
        books.add(new Book(402, "Les Miserables", "Victor Hugo", "French"));
        books.add(new Book(403, "The Little Prince", "Antoine de Saint-Exupery", "French"));
        books.add(new Book(404, "War and Peace", "Leo Tolstoy", "Russian"));
        books.add(new Book(405, "Crime and Punishment", "Fyodor Dostoevsky", "Russian"));

        books.add(new Book(501, "Journey to the West", "Wu Cheng'en", "Chinese"));
        books.add(new Book(502, "The Art of War", "Sun Tzu", "Chinese"));
        books.add(new Book(503, "Norwegian Wood", "Haruki Murakami", "Japanese"));
        books.add(new Book(504, "Kafka on the Shore", "Haruki Murakami", "Japanese"));
        books.add(new Book(505, "The Tale of Genji", "Murasaki Shikibu", "Japanese"));
    }

    /**
     * Simple login — only admin / 1234 is allowed.
     * Wrong credentials end the program.
     */
    static void login() {

        System.out.println("=========== LOGIN ===========");
        System.out.print("Enter Username : ");
        String username = sc.next();

        System.out.print("Enter Password : ");
        String password = sc.next();

        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Username or Password");
            System.exit(0); // Stop program if login fails
        }
    }

    /**
     * Menu option 1 — ask user for book details and add to the list.
     */
    static void addBook() {

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();
        sc.nextLine(); // consume leftover newline after nextInt()

        System.out.print("Enter Book Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name : ");
        String author = sc.nextLine();

        System.out.print("Enter Language : ");
        String language = sc.nextLine();

        books.add(new Book(id, name, author, language));
        saveBooks(); // persist to file immediately

        System.out.println("Book Added Successfully!");
    }

    /**
     * Menu option 2 — print every book in the library.
     */
    static void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available!");
            return;
        }

        for (Book b : books) {
            b.displayBook();
        }
    }

    /**
     * Menu option 3 — find books whose title contains the search text (case-insensitive).
     */
    static void searchBookByName() {

        sc.nextLine(); // clear buffer before reading a full line
        System.out.print("Enter Book Name (or part of name) : ");
        String searchName = sc.nextLine().trim();

        boolean found = false;

        for (Book b : books) {
            if (b.bookName.toLowerCase().contains(searchName.toLowerCase())) {
                b.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book Not Found!");
        }
    }

    /**
     * Menu option 4 — find one book by exact ID number.
     */
    static void searchBookById() {

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.bookId == id) {
                b.displayBook();
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    /**
     * Menu option 5 — mark book as issued to a student and record today's date.
     */
    static void issueBook() {

        System.out.print("Enter Book ID to Issue : ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : books) {
            if (b.bookId == id) {

                if (!b.isIssued) {
                    System.out.print("Enter Student Name : ");
                    String student = sc.nextLine();

                    b.isIssued = true;
                    b.issuedTo = student;
                    b.issueDate = LocalDate.now().toString();

                    saveBooks();
                    System.out.println("Book Issued Successfully!");
                } else {
                    System.out.println("Book Already Issued!");
                    System.out.println("Issued To : " + b.issuedTo);
                }
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    /**
     * Menu option 6 — return book, calculate fine if late more than 7 days (₹10 per extra day).
     */
    static void returnBook() {

        System.out.print("Enter Book ID to Return : ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.bookId == id) {

                if (b.isIssued) {

                    System.out.print("Enter Days Late : ");
                    int days = sc.nextInt();

                    int fine = 0;
                    // Fine only if returned after 7 days
                    if (days > 7) {
                        fine = (days - 7) * 10;
                    }

                    System.out.println("Fine Amount : Rs." + fine);

                    // Clear issue status so book is available again
                    b.isIssued = false;
                    b.issuedTo = "";
                    b.issueDate = "";

                    saveBooks();
                    System.out.println("Book Returned Successfully!");
                } else {
                    System.out.println("Book Was Not Issued!");
                }
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    /**
     * Menu option 7 — list all books by a given author (case-insensitive match).
     */
    static void searchByAuthor() {

        sc.nextLine();
        System.out.print("Enter Author Name : ");
        String author = sc.nextLine();

        boolean found = false;

        for (Book b : books) {
            if (b.author.equalsIgnoreCase(author)) {
                b.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Books Found!");
        }
    }

    /**
     * Menu option 8 — list all books in a given language (case-insensitive).
     */
    static void displayBooksByLanguage() {

        sc.nextLine();
        System.out.print("Enter Language : ");
        String lang = sc.nextLine();

        boolean found = false;

        for (Book b : books) {
            if (b.language.equalsIgnoreCase(lang)) {
                b.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Books Found In This Language!");
        }
    }

    /**
     * Writes all books to books.txt.
     * Format per line: id,name,author,language,isIssued,issuedTo,issueDate
     */
    static void saveBooks() {

        try {
            FileWriter fw = new FileWriter(BOOKS_FILE);

            for (Book b : books) {
                fw.write(
                    b.bookId + "," +
                    b.bookName + "," +
                    b.author + "," +
                    b.language + "," +
                    b.isIssued + "," +
                    b.issuedTo + "," +
                    b.issueDate + "\n"
                );
            }

            fw.close();
        } catch (Exception e) {
            System.out.println("Error Saving File!");
        }
    }

    /**
     * Reads books from books.txt into the books list.
     * Skips quietly if file does not exist yet.
     */
    static void loadBooks() {

        try {
            File file = new File(BOOKS_FILE);

            if (!file.exists()) {
                return; // First run — no file yet
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue; // skip blank lines
                }

                String[] data = line.split(",", -1); // -1 keeps empty trailing fields

                // Need at least id, name, author
                if (data.length < 3) {
                    continue;
                }

                Book b;

                // New format: id, name, author, language, isIssued, issuedTo, issueDate
                if (data.length >= 4 && !data[3].equalsIgnoreCase("true")
                        && !data[3].equalsIgnoreCase("false")) {
                    b = new Book(
                        Integer.parseInt(data[0].trim()),
                        data[1].trim(),
                        data[2].trim(),
                        data[3].trim()
                    );
                } else {
                    // Old format without language: id, name, author, isIssued, ...
                    b = new Book(
                        Integer.parseInt(data[0].trim()),
                        data[1].trim(),
                        data[2].trim(),
                        "Unknown"
                    );
                }

                // Parse issued flag and borrower fields depending on column count
                if (data.length >= 7) {
                    b.isIssued = Boolean.parseBoolean(data[4].trim());
                    b.issuedTo = data[5].trim();
                    b.issueDate = data[6].trim();
                } else if (data.length >= 6) {
                    // Old 6-field file: no language column
                    b.isIssued = Boolean.parseBoolean(data[3].trim());
                    b.issuedTo = data[4].trim();
                    b.issueDate = data[5].trim();
                } else if (data.length >= 4) {
                    b.isIssued = Boolean.parseBoolean(data[3].trim());
                }

                books.add(b);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Error Loading File!");
        }
    }
}
