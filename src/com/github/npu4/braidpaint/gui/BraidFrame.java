package com.github.npu4.braidpaint.gui;

import javax.swing.*;
import java.awt.*;

public class BraidFrame extends JFrame {
    public static int sizeOfFrame = 600;

    public BraidFrame(){
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem exitItem = new JMenuItem("Выход", new ImageIcon("exit.jpg"));
        exitItem.addActionListener(e-> System.exit(0));
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

        BraidPanel panel = new BraidPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().removeAll();
        getContentPane().add(panel);
        JButton updateButton = new JButton("Обновить");
        updateButton.addActionListener(e -> panel.flagToContinue = true);
        panel.add(updateButton, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(sizeOfFrame, sizeOfFrame)); // задаем размеры окна
        pack();
    }
}
