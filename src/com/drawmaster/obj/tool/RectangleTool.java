package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Rectangle;
import com.drawmaster.obj.shape.Shape;
import java.util.List;

/**
 * RectangleTool
 */
public class RectangleTool extends ShapeTool {

    public RectangleTool(List<Shape> shapes) {
        super(shapes);
    }

    public Shape mousePressed(MouseEvent e) {
        shape = new Rectangle(0, 0, 0, 0);
        return shape.mousePressed(e);
    }

    public Shape mouseReleased(MouseEvent e) {
        shape.mouseReleased(e);
        shapes.add(shape);
        return shape;
    }

    public Shape mouseDragged(MouseEvent e) {
        return shape.mouseDragged(e);
    }
}