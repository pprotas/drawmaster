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

/**
 * Canvas
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;
    private Shape selectedShape; // Currently handled shape
                                 // TODO: Implement "Group" functionality instead of "Shape" for
                                 // selectedShape(s).
    private Group mainGroup = new Group(); // All groups on the canvas

    private Invoker commandInvoker = new Invoker();
    private Tool tool = new OvalTool(this, mainGroup); // Currently selected tool
    private static Canvas instance = new Canvas(); // Singleton instance

    private Canvas() {
        super();
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(700, 400));
    }

    public static Canvas getInstance() {
        return instance;
    }

    public Group getGroups() {
        return mainGroup;
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
        mainGroup.add(shape);
    }

    public void clearList() {
        selectedShape = null;
        mainGroup.clear();
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public void setTool(String tool) {
        switch (tool) {
        case "Oval":
            setTool(new OvalTool(this, mainGroup));
            break;
        case "Rectangle":
            setTool(new RectangleTool(this, mainGroup));
            break;
        case "Select":
            setTool(new SelectTool(mainGroup));
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
        commandInvoker.execute(mDown); // Command pattern

        selectedShape = mDown.getShape();
        selectedShape.repaint(); // Roept paintComponent() aan
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
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Antialiasing

        mainGroup.draw(g); // Tekent alle shapes

        if (selectedShape != null) {
            g.setColor(Color.RED);
            selectedShape.draw(g); // Maakt de huidige shape rood en tekent hem
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