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
    private Graphics g;
    private Shape selectedShape;
    private List<Shape> shapes = new LinkedList<Shape>();

    private enum Tool {
        RECTANGLE, OVAL
    }

    Tool currentTool = Tool.OVAL;

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
        Shape s = null;

        switch (currentTool) {
        case RECTANGLE:
            s = new Rectangle(e.getX(), e.getY(), 0, 0);
            break;

        case OVAL:
            s = new Oval(e.getX(), e.getY(), 0, 0);
            break;

        default:
            break;
        }

        selectedShape = s;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        selectedShape.x2 = e.getX();
        selectedShape.y2 = e.getY();

        switch (currentTool) {
        case RECTANGLE:
            shapes.add((Rectangle) selectedShape);
            break;
        case OVAL:
            shapes.add((Oval) selectedShape);
            break;
        }
        g.dispose();
        g = null;

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        selectedShape.x2 = e.getX();
        selectedShape.y2 = e.getY();

        switch (currentTool) {
        case RECTANGLE:
            ((Rectangle) selectedShape).draw(g);
            break;
        case OVAL:
            ((Oval) selectedShape).draw(g);
            break;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape s : shapes) {
            if (s instanceof Rectangle) {
                ((Rectangle) s).draw(g);
            } else {
                ((Oval) s).draw(g);
            }
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