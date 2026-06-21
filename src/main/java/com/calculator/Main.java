package com.calculator;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {

        // Initialize the modern Look and Feel
        try {
            // FlatLightLaf removes harsh borders and makes everything look native and clean
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf. Defaulting to standard UI.");
        }

        // Safely launch the UI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            CalculatorUI calculator = new CalculatorUI();
            calculator.setVisible(true);
        });
    }
}