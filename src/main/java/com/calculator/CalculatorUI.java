package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame {

    private JTextField display;
    private final MathService mathService;
    private boolean isResultDisplayed = false;

    private final Color PINK_COLOR = new Color(255, 20, 147);
    private final Color BLACK_BG   = new Color(18, 18, 18);
    private final Color WHITE_TEXT = Color.WHITE;
    // Dark Gray for numbers
    private final Color GRAY_BTN   = new Color(45, 45, 45);
    // Almost black for functions
    private final Color DARK_BTN   = new Color(28, 28, 28);

    public CalculatorUI() {
        mathService = new MathService();
        initUI();
    }

    private void initUI() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 680);
        // Center on screen
        setLocationRelativeTo(null);

        // Set the main window background
        getContentPane().setBackground(BLACK_BG);

        display = new JTextField();
        display.setFont(new Font("JetBrains Mono", Font.BOLD, 40));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);