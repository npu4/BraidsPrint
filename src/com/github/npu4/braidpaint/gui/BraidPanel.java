package com.github.npu4.braidpaint.gui;

import com.github.npu4.braidpaint.braid.BraidString;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BraidPanel extends JPanel {
    public static int widthOfPanel = 1500 - 40;
    public static int heightOfPanel = 300 - 40;
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
                xCode = xCode.toLowerCase();

                int indexOfX = 0;
                while (indexOfX != -1 && indexOfX < xCode.length()) {
                    indexOfX = xCode.indexOf("x", indexOfX + 1);
                    if (indexOfX != -1) {
                        xCode = xCode.substring(0, indexOfX) + "." + xCode.substring(indexOfX);
                        indexOfX++;
                    }
                }

                /*int indexOfLeftBracket = 0;
                while (indexOfLeftBracket != -1 && indexOfLeftBracket < xCode.length()) {
                    indexOfLeftBracket = xCode.indexOf("(", indexOfLeftBracket + 1);
                    if (indexOfLeftBracket != -1) {
                        xCode = xCode.substring(0, indexOfLeftBracket) + "." + xCode.substring(indexOfLeftBracket);
                        indexOfLeftBracket++;
                    }
                }

                int indexOfRightBracket = 0;
                while (indexOfRightBracket != -1 && indexOfRightBracket < xCode.length()) {
                    indexOfRightBracket = xCode.indexOf(")", indexOfRightBracket + 1);
                    if (indexOfRightBracket != -1) {
                        xCode = xCode.substring(0, indexOfRightBracket) + "." + xCode.substring(indexOfRightBracket);
                        indexOfRightBracket++;
                    }
                }*/

                String[] braidElements = xCode.split("\\.");

                braidStringPartWidth = (widthOfPanel - 20) / (2 * braidElements.length + 1);
                braidStringHeight = (heightOfPanel - 20) / braidStrings.size();

                for (BraidString braidString : braidStrings) {
                    List<Point> points = new ArrayList<>();
                    points.add(new Point(20, 20 + braidStrings.indexOf(braidString) * braidStringHeight));
                    points.add(new Point(20 + braidStringPartWidth, 20 + braidStrings.indexOf(braidString) * braidStringHeight));
                    braidString.setPoints(points);
                    braidString.setIndex(braidStrings.indexOf(braidString));
                }

                for (int i = 0; i < braidElements.length; i++) {
                    for (BraidString braidString : braidStrings) {
                        List<Point> points = braidString.getPoints();
                        if (Integer.parseInt(braidElements[i].substring(1)) - 1 == braidString.getIndex()) {
                            points.add(new Point(20 + braidStringPartWidth * (2*i+2), 20 + (braidString.getIndex() + 1) * braidStringHeight));
                            braidString.setIndex(braidString.getIndex() + 1);
                        } else if (Integer.parseInt(braidElements[i].substring(1)) - 1 == braidString.getIndex() - 1) {
                            points.add(new Point(20 + braidStringPartWidth * (2*i+2), 20 + (braidString.getIndex() - 1) * braidStringHeight));
                            braidString.setIndex(braidString.getIndex() - 1);
                        } else {
                            points.add(new Point(20 + braidStringPartWidth * (2*i+2), 20 + braidString.getIndex() * braidStringHeight));
                        }
                        braidString.setPoints(points);
                    }

                    for (BraidString braidString : braidStrings) {
                        List<Point> points = braidString.getPoints();
                        points.add(new Point(20 + braidStringPartWidth * (2*i + 3), 20 + braidString.getIndex() * braidStringHeight));
                        braidString.setPoints(points);
                    }
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
