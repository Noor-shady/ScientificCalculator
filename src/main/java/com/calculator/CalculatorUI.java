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