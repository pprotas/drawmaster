package com.drawmaster.obj.ui;

import com.drawmaster.obj.command.*;
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

    private Invoker commandInvoker = new Invoker();
    private Tool tool = new OvalTool(this, shapes); // Currently selected tool

    public Canvas() {
        super();
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(700, 400));
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public Invoker getInvoker() {
        return commandInvoker;
    }

    public Shape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(Shape shape) {
        selectedShape = shape;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void clearList() {
        selectedShape = null;
        shapes.clear();
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public void setTool(String tool) {
        switch (tool) {
        case "Oval":
            setTool(new OvalTool(this, shapes));
            break;
        case "Rectangle":
            setTool(new RectangleTool(this, shapes));
            break;
        case "Select":
            setTool(new SelectTool(shapes));
            break;
        case "Move":
            setTool(new MoveTool(selectedShape));
            break;
        case "Resize":
            setTool(new ResizeTool(selectedShape));
            break;
        }

    }

    public void nullSelectedShape() {
        selectedShape = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ToolCommand mDown = new ToolMDown(tool, selectedShape, e);
        commandInvoker.execute(mDown);

        selectedShape = mDown.getShape();
        selectedShape.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ToolCommand mUp = new ToolMUp(tool, selectedShape, e);
        commandInvoker.execute(mUp);

        selectedShape = mUp.getShape();

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ToolCommand mDragged = new ToolMDragged(tool, selectedShape, e);
        commandInvoker.execute(mDragged);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Antialiasing to prevent jagged circles
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Shape s : shapes) {
            if (s != null) {
                s.draw(g);
            }
        }

        if (selectedShape != null) {
            g.setColor(Color.RED);
            selectedShape.draw(g); // TODO: Change this so it works with Group and different tools
            g.setColor(Color.BLACK);
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