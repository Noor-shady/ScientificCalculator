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