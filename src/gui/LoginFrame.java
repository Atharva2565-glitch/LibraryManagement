package src.gui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.color.ColorSpace;

public class LoginFrame extends JFrame {

    public  LoginFrame() {

        super("Library Management System");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Use absolute positioning for components
       
        JLabel title = new JLabel("Welcome to the Library Management System");
        title.setBounds(100,30,500,30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(java.awt.Color.BLUE);
        title.setBackground(Color.PINK);
        title.setOpaque(true);
        add(title);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 100, 100, 30);
        add(userLabel);
      
        JTextField userField = new JTextField();
        userField.setBounds(150, 100, 200, 30);
        add(userField);
      
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 150, 100, 30);
        add(passLabel);
      
        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 150, 200, 30);
        add(passField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 200, 100, 30);
        add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String username = userField.getText();
                char[] passwordChars = passField.getPassword();
                String password = new String(passwordChars);

                if (username.equalsIgnoreCase("admin")&& password.equals("admin123")) {
                    JOptionPane.showMessageDialog (LoginFrame.this, "Login successful! Welcome, " + username + "!");
                    dispose(); // Close the login frame
                    new DashboardFrame(); // Open the dashboard frame
                }else{
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password. Please try again.");
                    
                }
            }
        });
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(260, 200, 100, 30);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        setVisible(true);
    }
}
