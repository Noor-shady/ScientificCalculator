package com.calculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame implements ActionListener {

    private JTextField display;

    // --- Aesthetic Color Palette ---
    private final Color backgroundCream = new Color(250, 246, 242); // Warm off-white
    private final Color textTaupe = new Color(90, 74, 76);          // Dusty brown/mauve instead of harsh black
    private final Color buttonWhite = new Color(255, 255, 255);
    private final Color pastelPink = new Color(244, 219, 224);
    private final Color sageGreen = new Color(209, 226, 209);
    private final Color operatorLavender = new Color(230, 224, 248);

    public CalculatorUI() {
        setTitle("Scientific Calculator");
        setSize(380, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(backgroundCream); // Set main background

        // --- Display Area ---
        display = new JTextField();
        // Using a clean, rounded font. Quicksand or Avenir are great if I have them installed!
        display.setFont(new Font("SansSerif", Font.PLAIN, 40));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(backgroundCream);
        display.setForeground(textTaupe);
        display.setBorder(new EmptyBorder(30, 20, 30, 20)); // Lots of breathing room
        add(display, BorderLayout.NORTH);

        // --- Button Grid ---
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 4, 10, 10)); // Wider 10px gaps for a modern look
        buttonPanel.setBackground(backgroundCream);
        buttonPanel.setBorder(new EmptyBorder(10, 20, 30, 20));

        String[] buttons = {
                "sin(", "cos(", "tan(", "C",
                "log(", "log2(", "sqrt(", "Del",
                "pi", "e", "^", "/",
                "(", ")", "%", "*",
                "7", "8", "9", "-",
                "4", "5", "6", "+",
                "1", "2", "3", "=",
                ".", "0", "00", ""
        };

        for (String text : buttons) {
            if (text.isEmpty()) {
                buttonPanel.add(new JLabel(""));
                continue;
            }

            // ASSUMING I use your RoundedButton class here!
            // If RoundedButton extends JButton, this will work perfectly.
            JButton button = new RoundedButton(text);
            button.setFont(new Font("SansSerif", Font.BOLD, 16));
            button.setForeground(textTaupe);
            button.setFocusPainted(false);
            button.setBorderPainted(false); // Removes harsh default borders