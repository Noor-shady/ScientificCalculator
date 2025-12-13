package com.calculator;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());

            // Optional i want to force the title bar to match my specific BLACK_BG (18, 18, 18)
            UIManager.put("TitlePane.background", new Color(18, 18, 18));
            UIManager.put("TitlePane.foreground", Color.WHITE);

        } catch (Exception e) {
            System.err.println("Failed to initialize FlatLaf. Falling back to default.");
        }

        // Launch the Application
        // Running on the Event Dispatch Thread (EDT) is best practice for Java Swing
        SwingUtilities.invokeLater(() -> {
            CalculatorUI app = new CalculatorUI();
            app.setVisible(true);
        });
    }
}


