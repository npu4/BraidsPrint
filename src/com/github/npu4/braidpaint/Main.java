package com.github.npu4.braidpaint;

import com.github.npu4.braidpaint.gui.BraidFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            JFrame frame = new BraidFrame();
            frame.setTitle("Конструктивные фракталы");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setResizable(false);
        });
    }
}
