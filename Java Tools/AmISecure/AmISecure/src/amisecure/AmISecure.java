package amisecure;

import amisecure.frames.GeneratePasswordFrame;
import amisecure.frames.IsPasswordLeakedFrame;
import amisecure.frames.IsPasswordStrongFrame;
import amisecure.frames.SummaryFrame;
import java.awt.*;
import javax.swing.*;


public class AmISecure {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JPanel summaryPanel = SummaryFrame.createSummaryPanel();
            JPanel generatePasswordPanel = GeneratePasswordFrame.createGeneratePasswordPanel();
            JPanel isPasswordStrongFrame = IsPasswordStrongFrame.validatePasswordStrong();
            JPanel isPasswordLeakedFrame = IsPasswordLeakedFrame.validatePasswordLeaked();

            JFrame frame = new JFrame("AmISecure?");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setResizable(false);
            frame.enableInputMethods(true);

            JMenuBar menuBar = new JMenuBar();
            menuBar.setBackground(Color.decode("#201D1D"));

            JMenu homeMenu = new JMenu("Menu");
            homeMenu.setForeground(Color.WHITE);

            JMenuItem summary = new JMenuItem("Summary");
            JMenuItem exit = new JMenuItem("Exit");
            summary.setBackground(Color.decode("#201D1D"));
            summary.setForeground(Color.WHITE);
            exit.setBackground(Color.RED);
            exit.setForeground(Color.WHITE);

            homeMenu.add(summary);
            homeMenu.add(exit);

            JMenu dataSecurityMenu = new JMenu("Security Tools");
            dataSecurityMenu.setForeground(Color.WHITE);

            JMenuItem generatePassword = new JMenuItem("Generate password");
            JMenuItem isPasswordStrong = new JMenuItem("Is password strong?");
            JMenuItem isPasswordLeaked = new JMenuItem("Is password leaked?");
            

            generatePassword.setBackground(Color.decode("#201D1D"));
            generatePassword.setForeground(Color.WHITE);
            isPasswordStrong.setBackground(Color.decode("#201D1D"));
            isPasswordStrong.setForeground(Color.WHITE);
            isPasswordLeaked.setBackground(Color.decode("#201D1D"));
            isPasswordLeaked.setForeground(Color.WHITE);

            dataSecurityMenu.add(generatePassword);
            dataSecurityMenu.add(isPasswordStrong);
            dataSecurityMenu.add(isPasswordLeaked);

            menuBar.add(homeMenu);
            menuBar.add(dataSecurityMenu);

            summary.addActionListener(e -> {
                frame.getContentPane().removeAll(); // Remove all existing components
                frame.add(summaryPanel); // Add the panel
                frame.revalidate(); // Revalidate the frame
                frame.repaint(); // Repaint the frame
            });
            
            exit.addActionListener(e -> {
                System.exit(0); // Exit the application
            });

            generatePassword.addActionListener(e -> {
                frame.getContentPane().removeAll(); // Remove all existing components
                frame.add(generatePasswordPanel); // Add the panel
                frame.revalidate(); // Revalidate the frame
                frame.repaint(); // Repaint the frame
            });

            isPasswordStrong.addActionListener(e -> {
                frame.getContentPane().removeAll(); // Remove all existing components
                frame.add(isPasswordStrongFrame); // Add the panel
                frame.revalidate(); // Revalidate the frame
                frame.repaint(); // Repaint the frame
            });

            isPasswordLeaked.addActionListener(e -> {
                frame.getContentPane().removeAll(); // Remove all existing components
                frame.add(isPasswordLeakedFrame); // Add the panel
                frame.revalidate(); // Revalidate the frame
                frame.repaint(); // Repaint the frame
            });

            frame.setJMenuBar(menuBar);
            frame.add(summaryPanel);
            frame.setVisible(true);
        });
    }
}
