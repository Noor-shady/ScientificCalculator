package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorUI extends JFrame {

    private JTextField display;
    private final MathService mathService;
    private boolean isResultDisplayed = false;


