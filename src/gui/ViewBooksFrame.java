package src.gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
public class ViewBooksFrame extends JFrame {
    public ViewBooksFrame() {
        super("Library Management System - View Books");
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // Use absolute positioning for components

        // Add components to display the list of books here
        // For example, you can use a JTable or JTextArea to show book details
        String[] columnNames = {"Book ID", "Book Name", "Author", "Language", "Issued"};
        Object[][] data = {
            {101, "Book A", "Author A", "English", "No"},
            {102, "Book B", "Author B", "Marathi", "NO"},
            {103, "Book C", "Author C", "English", "Yes"},
            {104, "Book D", "Author D", "Marathi", "No"},
            {105, "Book E", "Author E", "English", "Yes"},
            {106, "Book F", "Author F", "Marathi", "No"},
            {107, "Book G", "Author G", "English", "Yes"},
            {108, "Book H", "Author H", "Marathi", "No"},
            {109, "Book I", "Author I", "English", "Yes"},
            {110, "Book J", "Author J", "Marathi", "No"}
            // Add more book data here
        };
        JLabel title = new JLabel("List of Books in the Library");
        title.setBounds(200, 10, 300, 30);
        add(title);
        JTable bookTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        scrollPane.setBounds(10, 50, 580, 340);
        add(scrollPane);
        setVisible(true);
    }
}
