package main.java.com.DrawMaster;

import javax.swing.SwingUtilities;

import main.java.com.DrawMaster.classes.Canvas;

import javax.swing.JFrame;

public class DrawMaster extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DrawMaster("DrawMaster");
            }
        });
    }

    DrawMaster(String title) {
        super(title);
        init();
    }

    public void init() {
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        add(canvas);
        pack();

        setVisible(true);
    }
}