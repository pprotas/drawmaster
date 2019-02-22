package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import java.util.List;
import java.util.LinkedList;

/**
 * ShapeTool
 */
public abstract class ShapeTool extends Tool {
    List<Shape> shapes = new LinkedList<Shape>();;
    Shape shape;

    public ShapeTool(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public Shape mousePressed(MouseEvent e) {
        return null;
    }

    @Override
    public Shape mouseReleased(MouseEvent e) {
        return null;
    }

    @Override
    public Shape mouseDragged(MouseEvent e) {
        return null;
    }

}