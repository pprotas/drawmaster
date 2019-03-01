package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Oval;
import com.drawmaster.obj.shape.Shape;
import java.util.List;

/**
 * OvalTool
 */
public class OvalTool extends ShapeTool {
    public OvalTool(List<Shape> shapes) {
        super(shapes);
    }

    public Shape mousePressed(MouseEvent e) {
        shape = new Oval(e.getX(), e.getY(), e.getX(), e.getY());
        return shape;
    }

    public Shape mouseReleased(MouseEvent e) {
        shape.setX(e.getX());
        shape.setY(e.getY());
        shapes.add(shape);
        return shape;
    }

    public Shape mouseDragged(MouseEvent e) {
        shape.setX(e.getX());
        shape.setY(e.getY());
        return shape;
    }
}