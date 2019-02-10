package com;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawMaster extends JFrame {

    private static final long serialVersionUID = 1L; // Default serialization ID to prevent error

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            DrawMaster dm = new DrawMaster();
            dm.setVisible(true);
        });
    }

    public DrawMaster() {

        initUI();
    }

    private class Canvas extends JComponent {
        private static final long serialVersionUID = 1L;

        public void paint(Graphics g) {
            Graphics2D graph2 = (Graphics2D) g;

            graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
    }

    private void initUI() {

        setTitle("Draw Master");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new Canvas(), BorderLayout.CENTER);
    }

}