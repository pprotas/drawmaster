package com.drawmaster.main;

import javax.swing.SwingUtilities;

import com.drawmaster.obj.ui.*;

import javax.swing.JFrame;

public class DrawMaster extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        // Programma runnen zodra alles is geladen
        SwingUtilities.invokeLater(() -> new DrawMaster("DrawMaster"));
    }

    DrawMaster(String title) {
        super(title);
        init();
    }

    public void init() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = Canvas.getInstance(); // Singleton instance van Canvas
        add(canvas);
        pack();

        MenuBar menuBar = new MenuBar(this, canvas); // De menubar voor save/load
        this.setJMenuBar(menuBar);

        ToolBar toolPicker = new ToolBar(this, canvas); // Toolbar

        GroupBar groupBar = new GroupBar(this, canvas); // GroupBar voor group functionaliteit

        setLocationRelativeTo(null); // Centers the JFrame
        toolPicker.setLocation(this.getX() + this.getWidth(), this.getY());
        groupBar.setLocation(this.getX() + this.getWidth(), this.getY() + toolPicker.getHeight());

        setVisible(true);
    }
}