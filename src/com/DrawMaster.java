package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class DrawMaster extends JFrame {

    public DrawMaster() {

        initUI();
    }

    private void initUI() {
        
        setTitle("Draw Master");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            DrawMaster dm = new DrawMaster();
            dm.setVisible(true);
        });
    }
}