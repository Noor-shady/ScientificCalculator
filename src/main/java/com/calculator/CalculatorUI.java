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

        display.setBackground(BLACK_BG);
        // Input text will be Pink
        display.setForeground(PINK_COLOR);
        display.setCaretColor(WHITE_TEXT);
        display.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));

        // Buttons Panel (Center)
        JPanel buttonPanel = new JPanel();
        // 15px gap for rounded buttons to look clean
        buttonPanel.setLayout(new GridLayout(6, 4, 15, 15));
        buttonPanel.setBackground(BLACK_BG);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Button Labels
        String[] buttons = {
                "sin", "cos", "tan", "C",
                "log", "ln", "sqrt", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "(", "0", ")", "="
        };

        for (String text : buttons) {
            JButton btn = createStyledButton(text);
            btn.addActionListener(createAction(text));
            buttonPanel.add(btn);
        }

