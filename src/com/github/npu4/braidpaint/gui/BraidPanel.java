package com.github.npu4.braidpaint.gui;

import javax.swing.*;
import java.awt.*;

public class BraidPanel extends JPanel {
    public static int sizeOfPanel = 590;

    public static boolean flagToContinue = true;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        repaint();
    }
}
