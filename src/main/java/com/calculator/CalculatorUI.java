package com.calculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CalculatorUI extends JFrame implements ActionListener {

    private JTextField display;

    // --- Aesthetic Color Palette ---
    private final Color backgroundCream = new Color(250, 246, 242);
    private final Color textTaupe = new Color(90, 74, 76);
    private final Color buttonWhite = new Color(255, 255, 255);
    private final Color pastelPink = new Color(244, 219, 224);
    private final Color sageGreen = new Color(209, 226, 209);
    private final Color operatorLavender = new Color(230, 224, 248);

    public CalculatorUI() {
        setTitle("Scientific Calculator");
        setSize(380, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(backgroundCream);

        display = new JTextField();
        display.setFont(new Font("SansSerif", Font.PLAIN, 40));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(backgroundCream);
        display.setForeground(textTaupe);
        display.setBorder(new EmptyBorder(30, 20, 30, 20));
        add(display, BorderLayout.NORTH);

        // --- Button Grid ---
        JPanel buttonPanel = new JPanel();
        // 8 Rows, 4 Columns (Perfect fit for 32 buttons)
        buttonPanel.setLayout(new GridLayout(8, 4, 10, 10));
        buttonPanel.setBackground(backgroundCream);
        buttonPanel.setBorder(new EmptyBorder(10, 20, 30, 20));

        // Reordered to look exactly like a standard modern calculator
        String[] buttons = {
                "sin(", "cos(", "tan(", "pi",
                "log(", "log2(", "sqrt(", "e",
                "(", ")", "^", "%",
                "C", "Del", "/", "*",
                "7", "8", "9", "-",
                "4", "5", "6", "+",
                "1", "2", "3", "=",
                "00", "0", ".", ""
        };

        for (String text : buttons) {
            if (text.isEmpty()) {
                buttonPanel.add(new JLabel("")); // Blank placeholder for alignment
                continue;
            }

            JButton button = new RoundedButton(text);
            button.setFont(new Font("SansSerif", Font.BOLD, 16));
            button.setForeground(textTaupe);