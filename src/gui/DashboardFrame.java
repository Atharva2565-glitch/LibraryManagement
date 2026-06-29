package src.gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DashboardFrame extends JFrame {
public DashboardFrame(){
    super("Library Management System - Dashboard");
    setSize(700, 500);
    setLocationRelativeTo(null); // Center the frame on the screen
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null); // Use absolute positioning for components

    JLabel title = new JLabel("Welcome to the Library Management System Dashboard");
    title.setBounds(50, 30, 500, 30);
    add(title);

    JLabel userLabel = new JLabel("Logged in as: Admin");
    userLabel.setBounds(50, 100, 200, 30);
        add(userLabel);

    // Add more components and functionality as needed for the dashboard

   

    JButton addBookButton = new JButton("Add Book");
    addBookButton.setBounds(50, 150, 100, 30);
    add(addBookButton);
   addBookButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        new AddBookFrame();
    }
});

    JButton searchBookButton = new JButton("Search Book");
    searchBookButton.setBounds(50, 200, 100, 30);
    add(searchBookButton);
    searchBookButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new SearchBookFrame();
        }
    });

    JButton viewBooksButton = new JButton("View Books");
    viewBooksButton.setBounds(200, 150, 100, 30);
    add(viewBooksButton);
    viewBooksButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ViewBooksFrame();
        }
    });

    JButton issueBookButton = new JButton("Issue Book");
    issueBookButton.setBounds(200, 200, 100, 30);
    add(issueBookButton);

    JButton returnBookButton = new JButton("Return Book");
    returnBookButton.setBounds(200, 250, 100, 30);
    add(returnBookButton);

    JButton logoutButton = new JButton("Logout");
    logoutButton.setBounds(125, 300, 100, 30);
    add(logoutButton);

    
     setVisible(true);
}
}
