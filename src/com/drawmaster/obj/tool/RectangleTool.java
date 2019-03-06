package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Rectangle;
import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.ui.Canvas;

import java.util.List;

/**
 * RectangleTool
 */
public class RectangleTool extends ShapeTool {

    public RectangleTool(Canvas canvas, List<Shape> shapes) {
        super(canvas, shapes);
    }

    public Shape mousePressed(MouseEvent e) {
        shape = new Rectangle(e.getX(), e.getY(), e.getX(), e.getY());
        return shape;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

}