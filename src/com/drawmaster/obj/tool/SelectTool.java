package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.ui.Canvas;

import java.util.List;
import java.util.LinkedList;

/**
 * SelectTool
 */
public class SelectTool implements Tool {
    private Canvas canvas;
    private List<Shape> shapes = new LinkedList<Shape>();;
    private Shape oldShape;

    public SelectTool(Canvas canvas, List<Shape> shapes) {
        this.canvas = canvas;
        this.shapes = shapes;
    }

    @Override
    public Shape mousePressed(MouseEvent e) {
        for (Shape s : shapes) {
            if (s != null) {
                if (s.contains(e.getPoint())) {
                    oldShape = canvas.getSelectedShape();
                    return s;
                }
            }
        }
        return null;
    }

    @Override
    public Shape mouseReleased(MouseEvent e) {
        return mousePressed(e);
    }

    @Override
    public Shape mouseDragged(MouseEvent e) {
        return mousePressed(e);
    }

    @Override
    public void undo() {
        canvas.setSelectedShape(oldShape); // TODO: Select tool undo is buggy
    }

    @Override
    public String getType() {
        return "Select";
    }
}