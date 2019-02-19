package com;

import javax.swing.*;

public class DrawMaster {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                init();
            }
        });

    }

    public static void init() {
        JFrame f = new JFrame("DrawMaster");
        f.setLocation(100, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        f.add(canvas);
        f.pack();

        f.setVisible(true);
    }
}