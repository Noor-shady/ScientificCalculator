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