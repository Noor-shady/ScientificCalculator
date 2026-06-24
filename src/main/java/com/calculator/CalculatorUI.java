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

            button.setFocusable(false);
            button.setBorderPainted(false);

            if (text.equals("C") || text.equals("Del")) {
                button.setBackground(pastelPink);
            } else if (text.equals("=")) {
                button.setBackground(sageGreen);
            } else if (text.matches("[\\+\\-\\*/\\^\\%]")) {
                button.setBackground(operatorLavender);
            } else {
                button.setBackground(buttonWhite);
            }

            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setupKeyboardListener();
    }

    private void setupKeyboardListener() {
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_ENTER) {
                    processCommand("=");
                } else if (keyCode == KeyEvent.VK_BACK_SPACE) {
                    processCommand("Del");
                } else if (keyCode == KeyEvent.VK_ESCAPE) {
                    processCommand("C");
                }
                // If the user typed a valid math character, send it to the display
                else if ("0123456789+-*/.%^()".indexOf(key) != -1) {
                    processCommand(String.valueOf(key));
                }
            }
        });
    }

    // --- Event Handling ---
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mouse clicks route here
        processCommand(e.getActionCommand());
    }

    private void processCommand(String command) {
        String currentText = display.getText();

        if (command.equals("C")) {
            display.setText("");
        } else if (command.equals("Del")) {
            if (!currentText.isEmpty() && !currentText.equals("Error")) {
                display.setText(currentText.substring(0, currentText.length() - 1));
            }
        } else if (command.equals("=")) {
            try {
                if(currentText.isEmpty()) return;
                double result = MathService.evaluate(currentText);
                if (result == (long) result) {
                    display.setText(String.format("%d", (long) result));
                } else {
                    display.setText(String.valueOf(result));
                }
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else {
            if (currentText.equals("Error")) {
                display.setText(command);
            } else {
                display.setText(currentText + command);
            }
        }
    }
}