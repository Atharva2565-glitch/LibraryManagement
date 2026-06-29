package src.gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class AddBookFrame extends JFrame { 
    private JTextField idField;
    private JTextField nameField;   
    private JTextField authorField;
    private JTextField languageField;
    public AddBookFrame() {
        super("Library Management System - Add Book");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // Use absolute positioning for components

        JLabel title = new JLabel("Add a New Book");
        title.setBounds(150, 30, 200, 30);
        add(title);

        JLabel idLabel = new JLabel("Book ID:");
        idLabel.setBounds(50, 80, 100, 30);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(150, 80, 200, 30);
        add(idField);

        JLabel nameLabel = new JLabel("Book Name:");
        nameLabel.setBounds(50, 120, 100, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 120, 200, 30);
        add(nameField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(50, 160, 100, 30);
        add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(150, 160, 200, 30);
        add(authorField);

        JLabel languageLabel = new JLabel("Language:");
        languageLabel.setBounds(50, 200, 100, 30);
        add(languageLabel);

        languageField = new JTextField();
        languageField.setBounds(150, 200, 200, 30);
        add(languageField);

        JButton SaveButton = new JButton("Save");
        SaveButton.setBounds(150, 250, 100, 30);
        add(SaveButton);
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the book details from the text fields
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String author = authorField.getText();
                String language = languageField.getText();


                // Show a confirmation message
                JOptionPane.showMessageDialog(AddBookFrame.this, "Book added successfully!");

                // Clear the text fields for new input
                idField.setText("");
                nameField.setText("");
                authorField.setText("");
                languageField.setText("");
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(260, 250, 100, 30);
        add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the AddBookFrame
            }
        });

        setVisible(true);
    }
}
