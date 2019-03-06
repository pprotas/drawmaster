package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Oval;
import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.ui.Canvas;

import java.util.List;

/**
 * OvalTool
 */
public class OvalTool extends ShapeTool {
    public OvalTool(Canvas canvas, List<Shape> shapes) {
        super(canvas, shapes);
    }

    public Shape mousePressed(MouseEvent e) {
        shape = new Oval(e.getX(), e.getY(), e.getX(), e.getY());
        return shape;
    }

    public Shape mouseReleased(MouseEvent e) {
        shape.setX(e.getX());
        shape.setY(e.getY());
        shapes.add(shape);

        canvas.setTool("Oval");
        return shape;
    }

    public Shape mouseDragged(MouseEvent e) {
        shape.setX(e.getX());
        shape.setY(e.getY());
        return shape;
    }

}