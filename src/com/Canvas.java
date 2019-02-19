package com;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.LinkedList;

import javax.swing.*;

/**
 * Canvas
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    Graphics g;
    Shape selectedShape;
    private List<Shape> shapes = new LinkedList<Shape>();

    Canvas() {

        super();
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(250, 200);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        g = getGraphics();
        Rectangle rc = new Rectangle(e.getX(), e.getY(), 0, 0);
        selectedShape = rc;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Rectangle rc = (Rectangle) selectedShape;
        rc.x2 = e.getX();
        rc.y2 = e.getY();

        g.dispose();
        g = null;

        shapes.add(rc);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        Rectangle rc = (Rectangle) selectedShape;
        rc.x2 = e.getX();
        rc.y2 = e.getY();
        repaint();
        rc.draw(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape s : shapes) {
            ((Rectangle) s).draw(g);
        }
    }

    public void mouseEntered(MouseEvent evt) {
    } // Some empty routines.

    public void mouseExited(MouseEvent evt) {
    } // (Required by the MouseListener

    public void mouseClicked(MouseEvent evt) {
    } // and MouseMotionListener

    public void mouseMoved(MouseEvent evt) {
    } // interfaces).

}