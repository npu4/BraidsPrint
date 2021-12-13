package com.github.npu4.braidpaint.gui;

import javax.swing.*;
import java.awt.*;

public class BraidFrame extends JFrame {
    public static int sizeOfFrame = 600;

    public BraidFrame() {
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem exitItem = new JMenuItem("Выход", new ImageIcon("exit.jpg"));
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
        xCode.setPreferredSize(new Dimension(sizeOfFrame-updateButtonWidth-40, 25));
        xCodePanel.add(xCode);

        JButton updateButton = new JButton("Обновить");
        //updateButton.addActionListener(e -> xCodePanel.flagToContinue = true);
        updateButton.setPreferredSize(new Dimension(updateButtonWidth, 25));
        xCodePanel.add(updateButton);


        BraidPanel braidPanel = new BraidPanel();
        braidPanel.setLayout(new BorderLayout());
        braidPanel.setPreferredSize(new Dimension(sizeOfFrame-40, sizeOfFrame-70));


        braidPanel.add(xCodePanel, BorderLayout.SOUTH);
        Container container = getContentPane();
        container.add(braidPanel, BorderLayout.CENTER);


        setVisible(true);
        setPreferredSize(new Dimension(sizeOfFrame, sizeOfFrame)); // задаем размеры окна
        pack();
    }
}
