package com.drawmaster.obj.canvas;

import com.drawmaster.obj.shape.*;
import com.drawmaster.obj.tool.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;

import javax.swing.*;

import java.util.List;
import java.util.LinkedList;

/**
 * Canvas
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;
    private Shape selectedShape; // Currently handled shape
                                 // TODO: Implement "Group" functionality instead of "Shape" for
                                 // selectedShape(s).
    private List<Shape> shapes = new LinkedList<Shape>(); // All shapes on the canvas

    Tool tool = new OvalTool(); // Currently selected tool
                                // TODO: Implement tool picker screen to switch between tools.
                                // TODO: Implement SelectTool, MoveTool and ResizeTool.

    public Canvas() {
        super();
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(700, 400);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        selectedShape = tool.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        selectedShape = tool.mouseReleased(e);

        shapes.add(selectedShape);

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        selectedShape = tool.mouseDragged(e);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Antialiasing to prevent jagged circles
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (selectedShape != null) {
            selectedShape.draw(g); // TODO: Change this so it works with Group and different tools
        }

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