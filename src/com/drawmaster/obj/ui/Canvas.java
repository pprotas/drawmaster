package com.drawmaster.obj.ui;

import com.drawmaster.obj.command.*;
import com.drawmaster.obj.decorator.TextShapeDecorator;
import com.drawmaster.obj.shape.*;
import com.drawmaster.obj.strategy.*;
import com.drawmaster.obj.tool.*;
import com.drawmaster.obj.visitor.*;

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
    private Group mainGroup;// All groups on the canvas

    private Invoker commandInvoker;
    private Tool tool; // Currently selected tool
    private static Canvas instance = new Canvas(); // Singleton instance
    private boolean decorator = false;
    private String decoratorText = "Decorator working!";

    private Canvas() {
        super();
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(700, 400));

        commandInvoker = new Invoker();
        mainGroup = new Group();
        tool = new ShapeTool(this, mainGroup, new OvalToolDelegate());
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
            setTool(new ShapeTool(this, mainGroup, new OvalToolDelegate()));
            break;
        case "Rectangle":
            setTool(new ShapeTool(this, mainGroup, new RectangleToolDelegate()));
            break;
        case "Decorator":
            if(decorator){
                decorator = false;
            } else {
                decorator = true;
            }
            break;
        case "Select":
            if (mainGroup != null) {
                setTool(new SelectTool(mainGroup));
            }
            decorator = false;
            break;
        case "Move":
            if (selectedShape != null) {
                setTool(new MoveTool(selectedShape));
            }
            decorator = false;
            break;
        case "Resize":
            if (selectedShape != null) {
                setTool(new ResizeTool(selectedShape));
            }
            decorator = false;
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

        repaint(); // Roept paintComponent() aan

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (tool instanceof MoveTool) {
            selectedShape.accept(new ShapeMoveVisitor(e));
        } else if (tool instanceof ResizeTool) {
            selectedShape.accept(new ShapeResizeVisitor(e));
        } else {
            ToolCommand mUp = new ToolMUp(tool, selectedShape, e);
            commandInvoker.execute(mUp);

            selectedShape = mUp.getShape();
        }

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (tool instanceof MoveTool) {
            selectedShape.accept(new ShapeMoveVisitor(e));
        } else if (tool instanceof ResizeTool) {
            selectedShape.accept(new ShapeResizeVisitor(e));
        } else {
            ToolCommand mDragged = new ToolMDragged(tool, selectedShape, e);
            commandInvoker.execute(mDragged);
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Antialiasing to prevent jagged circles
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Antialiasing
        if (mainGroup != null) {
            mainGroup.draw(g); // Tekent alle mainGroup
        }
        if (selectedShape != null) {
            g.setColor(Color.RED);
            if(decorator) {
                selectedShape.addDecorator(new TextShapeDecorator(decoratorText));
            }
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