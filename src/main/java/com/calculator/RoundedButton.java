package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

class RoundedButton extends JButton {
    private int radius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        // We paint the background manually
        setContentAreaFilled(false);
        // Remove the ugly focus border
        setFocusPainted(false);
        // Remove the default square border
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Anti-aliasing for smooth curves
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Change color when pressed
        if (getModel().isArmed()) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground());
        }

        // Draw the rounded rectangle background
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));

        // Draw the text
        super.paintComponent(g);
        g2.dispose();
    }

    // Draw the border for specific buttons (optional)
    @Override
    protected void paintBorder(Graphics g) {
        // If you want a border, uncomment below
        // Graphics2D g2 = (Graphics2D) g.create();
        // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // g2.setColor(getForeground());