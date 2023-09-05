/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amisecure.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

/**
 *
 * @author adm
 */
public class SummaryFrame {

    public static JPanel createSummaryPanel() {

        JPanel summaryPanel = new JPanel(new BorderLayout());
        summaryPanel.setBackground(Color.decode("#201D1D"));

        // Create a title label
        JLabel generatePasswordLabel = new JLabel("Information Summary");
        generatePasswordLabel.setFont(new Font("Arial", Font.BOLD, 30));
        generatePasswordLabel.setHorizontalAlignment(JLabel.CENTER);
        generatePasswordLabel.setForeground(Color.decode("#004AAD"));
        // Create a separator
        JSeparator separator = new JSeparator();
        // Create a paragraph label
        JLabel paragraphLabel = new JLabel(
                "<html>This is the information of all the funcstions and explanations of how to use.</html>");
        paragraphLabel.setHorizontalAlignment(JLabel.CENTER);
        paragraphLabel.setForeground(Color.white);

        // Create a list of summaries for functions
        List<String> summaries = new ArrayList<>();
        summaries.add("<html><br>Generate Password: Helps you to generate a strong,and non leaked password "
                + "<br> based on the length you select.Minimum length is 6 and maximun is 50</html>");
        summaries.add("<html><br>Is Password Strong: Helps you to check if your password is strong<br></html>");
        summaries.add("<html><br>Is Password Leaked: Check if your password was leaked<br></html>");

        // Create a JList to display the summaries
        JList<String> summaryList = new JList<>(summaries.toArray(String[]::new));
        summaryList.setForeground(Color.WHITE);
        summaryList.setBackground(Color.decode("#201D1D"));
        

        // Create a scroll pane for the list
        JScrollPane scrollPane = new JScrollPane(summaryList);
        scrollPane.setBackground(Color.decode("#201D1D"));

        // Create a container panel to hold components
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(generatePasswordLabel, BorderLayout.NORTH);
        contentPanel.add(separator, BorderLayout.CENTER);
        contentPanel.add(paragraphLabel, BorderLayout.SOUTH);
        contentPanel.setBackground(Color.decode("#201D1D"));

        // Add components to the summary panel
        summaryPanel.add(contentPanel, BorderLayout.NORTH);
        summaryPanel.add(scrollPane, BorderLayout.CENTER);
        
        return summaryPanel;
    }
}
