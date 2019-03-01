package com.drawmaster.main;

import javax.swing.SwingUtilities;

import com.drawmaster.obj.ui.*;

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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        add(canvas);
        pack();

        MenuBar menuBar = new MenuBar(this, canvas);
        this.setJMenuBar(menuBar);

        ToolBar toolPicker = new ToolBar(this, canvas);

        setLocationRelativeTo(null); // Centers the JFrame
        toolPicker.setLocation(this.getX() + this.getWidth(), this.getY());

        setVisible(true);
    }
}