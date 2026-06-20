package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame implements ActionListener {

    private JTextField display;

    public CalculatorUI() {
        // --- Frame Setup ---
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centers the window on your screen
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());