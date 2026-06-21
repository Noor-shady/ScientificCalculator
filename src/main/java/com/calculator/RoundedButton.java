package com.calculator;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {

    // I can change this number to make the corners more or less round!
    private int radius = 30;

    public RoundedButton(String text) {
        super(text);