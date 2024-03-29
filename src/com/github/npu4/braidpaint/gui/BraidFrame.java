package com.github.npu4.braidpaint.gui;

import com.github.npu4.braidpaint.braid.BraidString;
import com.github.npu4.braidpaint.braid.stringCharcteristics.StringType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BraidFrame extends JFrame {
    public static int widthOfFrame = 1500;
    public static int heightOfFrame = 300;

    public BraidFrame() {
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.addActionListener(e -> System.exit(0));
        exitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
        fileMenu.add(exitItem);


        JMenuItem aboutItem = new JMenuItem("О программе");
        aboutItem.addActionListener(e -> {
            JDialog dialog = new AboutDialog(this);
            dialog.setVisible(true);
        });
        JMenu helpMenu = new JMenu("Справка");
        helpMenu.add(aboutItem);


        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);


        JPanel xCodePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        int updateButtonWidth = 100;
        JTextField xCode = new JTextField();
        xCode.setPreferredSize(new Dimension(widthOfFrame-updateButtonWidth-40, 25));

        JButton updateButton = new JButton("Обновить");
        updateButton.setPreferredSize(new Dimension(updateButtonWidth, 25));


        // TO DO: make it selectable
        List<BraidString> braidString = new ArrayList<>();
        braidString.add(new BraidString(StringType.BOLD));
        braidString.add(new BraidString(StringType.TINY));
        braidString.add(new BraidString(StringType.BOLD));
        braidString.add(new BraidString(StringType.BOLD));
        braidString.add(new BraidString(StringType.TINY));
        braidString.add(new BraidString(StringType.BOLD));
        braidString.add(new BraidString(StringType.BOLD));

        BraidPanel braidPanel = new BraidPanel(xCode.getText(), braidString);
        braidPanel.setLayout(new BorderLayout());
        braidPanel.setPreferredSize(new Dimension(widthOfFrame-40, heightOfFrame-40));
        xCodePanel.add(xCode);

        updateButton.addActionListener(e -> {
            BraidPanel.flagToContinue = true;
            BraidPanel.setXCode(xCode.getText());
        });
        xCodePanel.add(updateButton);


        braidPanel.add(xCodePanel, BorderLayout.SOUTH);
        Container container = getContentPane();
        container.add(braidPanel, BorderLayout.CENTER);


        setVisible(true);
        setPreferredSize(new Dimension(widthOfFrame, heightOfFrame));
        pack();
    }
}
