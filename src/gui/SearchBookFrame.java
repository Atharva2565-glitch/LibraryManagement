package src.gui;

import src.Main;
import src.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookFrame extends JFrame {

    private JTable resultTable;

    public SearchBookFrame() {

        super("Library Management System - Search Book");

        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Title
        JLabel title = new JLabel("Search for a Book");
        title.setBounds(220, 10, 200, 30);
        add(title);

        // Search Label
        JLabel searchLabel = new JLabel("Book Name / Author:");
        searchLabel.setBounds(40, 50, 150, 30);
        add(searchLabel);

        // Search Text Field
        JTextField searchField = new JTextField();
        searchField.setBounds(190, 50, 200, 30);
        add(searchField);

        // Search Button
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(410, 50, 100, 30);
        add(searchButton);

        // Table
        String[] columnNames = {
                "Book ID",
                "Book Name",
                "Author",
                "Language",
                "Issued"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        resultTable = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBounds(20, 100, 550, 220);
        add(scrollPane);

        // Search Button Action
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String searchText = searchField.getText().trim().toLowerCase();

                // Clear old results
                model.setRowCount(0);

                // Search books
                for (Book book : Main.books) {

                    if (book.bookName.toLowerCase().contains(searchText)
                            || book.author.toLowerCase().contains(searchText)
                            || book.language.toLowerCase().contains(searchText)
                            || String.valueOf(book.bookId).contains(searchText)) {

                        model.addRow(new Object[]{
                                book.bookId,
                                book.bookName,
                                book.author,
                                book.language,
                                book.isIssued ? "Yes" : "No"
                        });
                    }
                }

                // If nothing found
                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(
                            SearchBookFrame.this,
                            "No matching book found."
                    );
                }
            }
        });

        setVisible(true);
    }
}