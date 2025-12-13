package com.calculator;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Ensure the UI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(CalculatorUI::new);
    }
}