package oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    Frame() {
        this.setSize(800, 600);
        this.setTitle("Ticketing System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Load your images here (replace with valid file paths)
        ImageIcon image = new ImageIcon("Logo(1).jpg");
        this.setIconImage(image.getImage());

        ImageIcon backgroundimage = new ImageIcon("Back.jpg");
        JLabel backgroundimage_label = new JLabel(backgroundimage);
        backgroundimage_label.setBounds(0, 0, this.getWidth(), this.getHeight());

        ImageIcon logo = new ImageIcon("2.png");
        JLabel logo1 = new JLabel(logo);
        logo1.setBounds(10, 10, logo.getIconWidth(), logo.getIconHeight());

        // Set up a layered pane to manage multiple layers
        JLayeredPane layeredimage = new JLayeredPane();
        layeredimage.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(layeredimage);

        // Add the background image and logo
        layeredimage.add(backgroundimage_label, Integer.valueOf(0));
        layeredimage.add(logo1, Integer.valueOf(1));

        // Welcome message
        JLabel intro = new JLabel("Welcome to Help Tech");
        intro.setForeground(new Color(255, 127, 80));
        intro.setBounds(235, 50, 400, 50);
        Font font = new Font("Arial", Font.BOLD, 30);
        intro.setFont(font);
        layeredimage.add(intro, Integer.valueOf(2));

        JLabel intro2 = new JLabel("Ticketing System");
        intro2.setForeground(new Color(183, 65, 14));
        intro2.setBounds(340, 80, 400, 50);
        Font font2 = new Font("Arial", Font.BOLD, 16);
        intro2.setFont(font2);
        layeredimage.add(intro2, Integer.valueOf(10));

        // Panel for login form
        JPanel LoginPanel = new JPanel();
        LoginPanel.setBackground(Color.BLACK);
        LoginPanel.setBounds(250, 180, 300, 310);
        LoginPanel.setBackground(new Color(0, 0, 0, 128));
        this.add(LoginPanel);
        layeredimage.add(LoginPanel, Integer.valueOf(3));

        // Username label and text field
        JLabel username = new JLabel("Username:");
        username.setForeground(Color.white);
        username.setBounds(280, 275, 100, 30);
        this.add(username);
        layeredimage.add(username, Integer.valueOf(4));

        JTextField Username = new JTextField();
        Username.setBounds(280, 300, 240, 25);
        this.add(Username);
        layeredimage.add(Username, Integer.valueOf(7));

        // Password label and password field
        JLabel password = new JLabel("Password:");
        password.setForeground(Color.white);
        password.setBounds(280, 335, 120, 30);
        this.add(password);
        layeredimage.add(password, Integer.valueOf(5));

        JPasswordField Password = new JPasswordField();
        Password.setBounds(280, 360, 240, 25);
        this.add(Password);
        layeredimage.add(Password, Integer.valueOf(8));

        // Login label
        JLabel Login = new JLabel("LOGIN");
        Login.setForeground(Color.LIGHT_GRAY);
        Login.setBounds(350, 200, 400, 50);
        Font font1 = new Font("Arial", Font.BOLD, 30);
        Login.setFont(font1);
        this.add(Login);
        layeredimage.add(Login, Integer.valueOf(6));

        // Login button
        JButton Loginbutton = new JButton("Login");
        Loginbutton.setBounds(420, 425, 70, 30);
        this.add(Loginbutton);
        layeredimage.add(Loginbutton, Integer.valueOf(9));

        // Register button
        JButton Registerbutton = new JButton("Register");
        Registerbutton.setBounds(300, 425, 90, 30);
        this.add(Registerbutton);
        layeredimage.add(Registerbutton, Integer.valueOf(9));

        // Action listener for the Register button
        Registerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When Register button is clicked, open the registration screen
                new Register();  // Show the registration screen
                dispose(); // Close the login screen (frame) when opening registration screen
            }
        });

        this.setVisible(true);
    }
}
