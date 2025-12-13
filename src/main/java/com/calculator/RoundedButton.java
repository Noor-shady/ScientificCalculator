package com.calculator;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {

    public RoundedButton(String text, Color bgColor, Color fgColor) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 16));
        setBackground(bgColor);
        setForeground(fgColor);
        setFocusPainted(false);
        setBorderPainted(false);
        // Important for custom painting
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Anti-aliasing for smooth rounded corners
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // 20px radius

        // Draw text (handled by super, but we need to ensure it's on top)
        super.paintComponent(g);

        g2.dispose();
    }

    @Override
    public void updateUI() {
        super.updateUI();
        // Ensure formatting persists after UI updates
        setContentAreaFilled(false);
    }
}