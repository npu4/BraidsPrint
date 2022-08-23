package com.github.npu4.braidpaint.gui;

import com.github.npu4.braidpaint.braid.BraidString;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BraidPanel extends JPanel {
    public static int widthOfPanel = 1000 - 40;
    public static int heightOfPanel = 600 - 40;
    public static boolean flagToContinue = true;

    public static int braidStringPartWidth;
    public static int braidStringHeight;
    public static String xCode;
    public static List<BraidString> braidStrings = new ArrayList<>();


    public BraidPanel(String xCode, List<BraidString> braidStrings) {
        BraidPanel.xCode = xCode;
        BraidPanel.braidStrings = braidStrings;
    }

    public static void setXCode(String xCode) {
        BraidPanel.xCode = xCode;
    }

    public static void creatingPointsForDraw() {
        if (flagToContinue) {
            if (xCode.isEmpty()) {
                braidStringPartWidth = widthOfPanel - 20;
                braidStringHeight = (heightOfPanel - 20) / braidStrings.size();
                for (BraidString braidString : braidStrings) {
                    List<Point> points = new ArrayList<>();
                    points.add(new Point(20, 20 + braidStrings.indexOf(braidString) * braidStringHeight));
                    points.add(new Point(20 + braidStringPartWidth, 20 + braidStrings.indexOf(braidString) * braidStringHeight));
                    braidString.setPoints(points);
                }

            } else {
                for (BraidString braidString : braidStrings) {
                    braidString.getPoints().clear();
                }
            }
            flagToContinue = false;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        creatingPointsForDraw();
        for (BraidString braidString : braidStrings) {
            for (int i = 0; i < braidString.getPoints().size() - 1; i++) {
                Point currentPoint = braidString.getPoints().get(i);
                Point nextPoint = braidString.getPoints().get(i + 1);
                g.drawLine((int) currentPoint.getX(), (int) currentPoint.getY(), (int) nextPoint.getX(), (int) nextPoint.getY());
            }
        }
        repaint();
    }
}
