package oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Register extends JFrame {

    Register() {
        // Set up the frame for the registration window
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Register - Ticketing System");

        // Set the layout and background
        this.setLayout(null);

        // Create and add the "Register" label
        JLabel registerLabel = new JLabel("Register Here");
        registerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        registerLabel.setBounds(150, 30, 200, 30);
        this.add(registerLabel);

        // Username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 80, 100, 30);
        this.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 80, 180, 30);
        this.add(usernameField);

        // Password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 120, 100, 30);
        this.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 120, 180, 30);
        this.add(passwordField);

        // Confirm password label and password field
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(50, 160, 150, 30);
        this.add(confirmPasswordLabel);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(150, 160, 180, 30);
        this.add(confirmPasswordField);

        // Register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 200, 100, 30);
        this.add(registerButton);

        // Action listener for the register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Check if passwords match
                if (password.equals(confirmPassword)) {
                    // Save the username and password to a file
                    saveUserToFile(username, password);

                    // Show success message
                    JOptionPane.showMessageDialog(null, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Close the registration window and open the login screen again
                    dispose();
                    new Frame();
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set the frame visible
        this.setVisible(true);
    }

    // Method to save the username and password to a file
    private void saveUserToFile(String username, String password) {
        // Specify the file path (users.txt)
        File file = new File("Users.txt");

        try {
            // Check if the file exists, create it if not
            if (!file.exists()) {
                file.createNewFile();  // This will create the file if it does not exist
            }

            // Create a FileWriter and BufferedWriter to write to the file
            FileWriter fw = new FileWriter(file, true);  // 'true' to append to the file
            BufferedWriter bw = new BufferedWriter(fw);

            // Write the username and password to the file (separated by a comma)
            bw.write(username + "," + password);
            bw.newLine();  // Add a newline after each entry

            // Close the BufferedWriter
            bw.close();
        } catch (IOException e) {
            // Handle potential IO errors
            e.printStackTrace();
        }
    }
}
