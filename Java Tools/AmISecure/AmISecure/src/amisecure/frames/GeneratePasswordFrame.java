/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amisecure.frames;

import amisecure.functions.GeneratePasswordFunction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author adm
 */
public class GeneratePasswordFrame {

    public static JPanel createGeneratePasswordPanel() {

        JPanel generatePasswordPanel = new JPanel(new BorderLayout());
        generatePasswordPanel.setBackground(Color.decode("#201D1D"));

        // Create a title label
        JLabel generatePasswordLabel = new JLabel("Generate Password");
        generatePasswordLabel.setFont(new Font("Arial", Font.BOLD, 30));
        generatePasswordLabel.setHorizontalAlignment(JLabel.CENTER);
        generatePasswordLabel.setForeground(Color.decode("#004AAD"));
        // Create a separator
        JSeparator separator = new JSeparator();
        // Create a paragraph label
        JLabel paragraphLabel = new JLabel(
                "<html>To generate a safe password select the length and click on generate<br><br></html>");
        paragraphLabel.setHorizontalAlignment(JLabel.CENTER);
        paragraphLabel.setForeground(Color.white);

        // Create a container panel to hold components
        JPanel contentPanel = new JPanel(new BorderLayout());

        contentPanel.add(generatePasswordLabel, BorderLayout.NORTH);
        contentPanel.add(separator, BorderLayout.CENTER);
        contentPanel.add(paragraphLabel, BorderLayout.SOUTH);
        contentPanel.setBackground(Color.decode("#201D1D"));

        //----------------------------------------------------------------------
        // Create a label for the user input
        JLabel lengthLabel = new JLabel("Length:");
        lengthLabel.setHorizontalAlignment(JLabel.LEFT);
        lengthLabel.setForeground(Color.WHITE);

        // Create a text input field
        JTextField lengthInput = new JTextField(2); // Adjust width as needed
        lengthInput.setForeground(Color.decode("#004AAD"));

        // Create a button
        JButton generateButton = new JButton("Generate");
        generateButton.setHorizontalAlignment(JButton.LEFT); // Align button to the left

        // ActionListener for the input field
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = lengthInput.getText();
                if (!inputText.isEmpty()) {
                    try {
                        int passwordLength = Integer.parseInt(inputText);
                        
                        if (passwordLength < 6) {
                            JOptionPane.showMessageDialog(null, "Password must have at lest 6 characters", "INVALID LENGTH", JOptionPane.ERROR_MESSAGE);
                        } else if (passwordLength > 50) {
                            JOptionPane.showMessageDialog(null, "Password should be less then 50 characters", "INVALID LENGTH", JOptionPane.ERROR_MESSAGE);
                        } else {
                            String passwordGen = GeneratePasswordFunction.generatePassword(passwordLength);
                            
                            JPanel messagePanel = new JPanel(new BorderLayout());
                            JTextArea password = new JTextArea(passwordGen);
                            password.setEditable(false);
                            messagePanel.add(password);
                            messagePanel.add(new JScrollPane(password), BorderLayout.CENTER);
                            
                            JOptionPane.showMessageDialog(null, messagePanel, "Password Generated", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter with a valid number.", "INVALID SIZE", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
                    } catch (NoSuchAlgorithmException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "NoSuchAlgorithmException", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a password length.", "EMPTY DATA", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Create a panel to hold the label, text input, and button
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5); // Adjust spacing as needed
        inputPanel.add(lengthLabel, gbc);

        gbc.gridx = 1;
        inputPanel.add(lengthInput, gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(generateButton, gbc);

        inputPanel.setBackground(Color.decode("#201D1D"));

        // Add components to the content panel
        contentPanel.add(generatePasswordLabel, BorderLayout.NORTH);
        contentPanel.add(separator, BorderLayout.CENTER);
        contentPanel.add(paragraphLabel, BorderLayout.CENTER);
        contentPanel.add(inputPanel, BorderLayout.SOUTH);

        // Add components to the summary panel
        generatePasswordPanel.add(contentPanel, BorderLayout.NORTH);

        return generatePasswordPanel;
    }
}
