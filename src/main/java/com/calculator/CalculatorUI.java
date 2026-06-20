package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame implements ActionListener {

    private JTextField display;

    public CalculatorUI() {
        // --- 1. Frame Setup ---
        setTitle("Scientific Calculator");
        setSize(400, 600);