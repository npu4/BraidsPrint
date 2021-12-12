package com.github.npu4.braidpaint.gui;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog{
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 300;


    private static final String tags =
            "<html>Программа, рисует математические косы "  +
                    "<hr>(c) Пучкова Н.Д., 2021</hr></html>";

    public AboutDialog(JFrame owner){
        super(owner, "О программе", true);
        add(new JLabel(tags), BorderLayout.CENTER);
        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(e-> setVisible(false));
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}