package com.calculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalculatorUI extends JFrame {

    private final Color PINK_COLOR = new Color(255, 130, 253, 255);
    // Black text
    private final Color WHITE_TEXT = new Color(0, 0, 0);
    private final Color BLACK_BG   = new Color(255, 255, 255);
    // Pink numbers
    private final Color GRAY_BTN   = new Color(255, 130, 253);
    // Dark function buttons
    private final Color DARK_BTN   = new Color(28, 28, 28);

    // --- Components ---
    private JTextField display;
    private JTextArea historyArea;
    private JToggleButton degRadToggle;
    private boolean isDegreeMode = true;

    public CalculatorUI() {
        setTitle("Pink Scientific Calculator");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(BLACK_BG);

        initDisplayArea();
        initCenterPanel();
        initHistorySidebar();

        setLocationRelativeTo(null);
        setVisible(true);
        display.requestFocusInWindow();
    }

    private void initDisplayArea() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(BLACK_BG);
        topPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        degRadToggle = new JToggleButton("DEG");
        degRadToggle.setFont(new Font("Arial", Font.BOLD, 12));
        degRadToggle.setBackground(PINK_COLOR);
        degRadToggle.setForeground(WHITE_TEXT);
        degRadToggle.setFocusPainted(false);
        degRadToggle.addActionListener(e -> {
            isDegreeMode = degRadToggle.isSelected();
            degRadToggle.setText(isDegreeMode ? "RAD" : "DEG");
        });

        // Display Field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 32));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(BLACK_BG);
        display.setForeground(WHITE_TEXT);
        display.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, PINK_COLOR));
        display.setCaretColor(PINK_COLOR);

        // Keyboard Support
        display.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    calculateResult();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    display.setText("");
                }
            }
        });

        topPanel.add(degRadToggle, BorderLayout.WEST);
        topPanel.add(display, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
    }

    private void initCenterPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 8, 8));
        buttonPanel.setBackground(BLACK_BG);
        buttonPanel.setBorder(new EmptyBorder(10, 15, 15, 15));

        String[] buttons = {
                "sin", "cos", "tan", "AC",
                "log", "ln",  "(",   ")",
                "7",   "8",   "9",   "/",
                "4",   "5",   "6",   "*",
                "1",   "2",   "3",   "-",
                "0",   ".",   "^",   "="
        };

        for (String text : buttons) {
            Color btnBg;
            Color btnFg;

            // Determine colors based on button type
            if ("0123456789.".contains(text) && text.length() == 1) {
                btnBg = GRAY_BTN;
                btnFg = WHITE_TEXT;
            } else if (text.equals("=")) {
                btnBg = PINK_COLOR;
                btnFg = WHITE_TEXT;
            } else {
                btnBg = DARK_BTN;
                btnFg = Color.WHITE;
            }

            RoundedButton btn = new RoundedButton(text, btnBg, btnFg);
            btn.addActionListener(e -> buttonAction(text));
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void initHistorySidebar() {
        JPanel historyPanel = new JPanel(new BorderLayout());
        historyPanel.setBackground(BLACK_BG);
        historyPanel.setBorder(new EmptyBorder(10, 0, 15, 15));

        JLabel title = new JLabel("History");
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setForeground(WHITE_TEXT);
        title.setBorder(new EmptyBorder(0, 0, 5, 0));
        historyPanel.add(title, BorderLayout.NORTH);

        historyArea = new JTextArea(10, 12);
        historyArea.setEditable(false);
        historyArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        historyArea.setBackground(new Color(245, 245, 245));

        JScrollPane scrollPane = new JScrollPane(historyArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(PINK_COLOR, 1));

        historyPanel.add(scrollPane, BorderLayout.CENTER);
        add(historyPanel, BorderLayout.EAST);
    }

    private void buttonAction(String text) {
        if (text.equals("=")) {
            calculateResult();
        } else if (text.equals("AC")) {
            display.setText("");
        } else if (isFunction(text)) {
            display.setText(display.getText() + text + "(");
        } else {
            display.setText(display.getText() + text);
        }
        display.requestFocus();
    }

    private boolean isFunction(String text) {
        return "sin cos tan log ln".contains(text);
    }

    private void calculateResult() {
        try {
            String input = display.getText();
            if (input.isEmpty()) return;

            double result = MathService.evaluate(input, isDegreeMode);

            String formattedResult;
            if (Math.abs(result) > 10000000 || (Math.abs(result) < 0.0001 && result != 0)) {
                DecimalFormat sciForm = new DecimalFormat("0.###E0");
                formattedResult = sciForm.format(result);
            } else {
                if (result == (long) result) {
                    formattedResult = String.format("%d", (long) result);
                } else {
                    formattedResult = String.format("%s", result);
                }
            }

            display.setText(formattedResult);
            addToHistory(input, formattedResult);

        } catch (Exception e) {
            display.setText("Error");
        }
    }

    private void addToHistory(String expr, String res) {
        historyArea.append(expr + "\n= " + res + "\n\n");
        historyArea.setCaretPosition(historyArea.getDocument().getLength());
    }
}