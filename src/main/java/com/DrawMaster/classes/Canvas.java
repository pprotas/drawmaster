package main.java.com.DrawMaster.classes;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import java.util.List;
import java.util.LinkedList;

/**
 * Canvas
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;
    private Graphics g;
    private Shape selectedShape; // Currently handled shape
    private List<Shape> shapes = new LinkedList<Shape>(); // All shapes on the canvas

    private enum Tool {
        RECTANGLE, OVAL
    }

    Tool currentTool = Tool.RECTANGLE; // TODO: Add button for users to change current tool

    public Canvas() {
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
        g = getGraphics(); // Sets the current graphics context to 'g' so you can draw on the canvas

        switch (currentTool) {
        case RECTANGLE:
            selectedShape = new Rectangle(e.getX(), e.getY(), 0, 0);
            break;

        case OVAL:
            selectedShape = new Oval(e.getX(), e.getY(), 0, 0);
            break;

        default:
            break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        selectedShape.x2 = e.getX();
        selectedShape.y2 = e.getY();

        shapes.add(selectedShape);

        g.dispose();
        g = null;

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        repaint();
        selectedShape.x2 = e.getX();
        selectedShape.y2 = e.getY();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        selectedShape.draw(g);

        for (Shape s : shapes) {
            s.draw(g);
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