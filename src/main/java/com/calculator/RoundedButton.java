package com.calculator;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {

    // I can change this number to make the corners more or less round!
    private int radius = 30;

    public RoundedButton(String text) {
        super(text);

        setOpaque(false);
        setContentAreaFilled(false); // Stops Java from drawing a harsh rectangle background
        setFocusPainted(false);      // Removes the dotted line when you click
        setBorderPainted(false);     // Removes the default 3D border