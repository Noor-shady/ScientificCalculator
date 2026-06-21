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
        setFocusPainted(false);      // Removes the dotted line when I click
        setBorderPainted(false);     // Removes the default 3D border

        setMargin(new Insets(10, 15, 10, 15));
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Cast to Graphics2D for advanced drawing features
        Graphics2D g2 = (Graphics2D) g.create();

        // Turn on Antialiasing! This is crucial for smooth, aesthetic curves
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Handle Hover and Click Colors
        if (getModel().isPressed()) {
            // Darken slightly when clicked
            g2.setColor(getBackground().darker());
        } else if (getModel().isRollover()) {
            g2.setColor(getBackground().brighter());
        } else {
            // Normal color
            g2.setColor(getBackground());
        }

        // Draw the filled rounded rectangle
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Always dispose of the Graphics object to save memory!
        g2.dispose();

        super.paintComponent(g);
    }

    // Optional: override paintBorder with nothing so Java NEVER draws a border,
    // ensuring the button stays perfectly soft and minimal.
    @Override
    protected void paintBorder(Graphics g) {
        // Do nothing!
    }
}