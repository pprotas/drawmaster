package com.drawmaster.obj.tool;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.ui.Canvas;

import java.util.List;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 * ShapeTool
 */
public abstract class ShapeTool implements Tool {
    protected Canvas canvas;
    public List<Shape> shapes = new LinkedList<Shape>();;
    public Shape shape;

    public ShapeTool(Canvas canvas, List<Shape> shapes) {
        this.canvas = canvas;
        this.shapes = shapes;
    }

    public Shape mouseReleased(MouseEvent e) {
        shape.setX(e.getX());
        shape.setY(e.getY());
        shapes.add(shape);

        canvas.setTool(getType());
        return shape;
    }

    public Shape mouseDragged(MouseEvent e) {
        shape.setX(e.getX());
        shape.setY(e.getY());
        return shape;
    }

    @Override
    public void undo() {
        shapes.remove(shape);
    }
}