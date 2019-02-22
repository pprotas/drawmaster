package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Rectangle;
import com.drawmaster.obj.shape.Shape;
import java.util.List;

/**
 * RectangleTool
 */
public class RectangleTool extends ShapeTool {
    Rectangle rc;

    public RectangleTool(List<Shape> shapes) {
        super(shapes);
    }

    public Shape mousePressed(MouseEvent e) {
        rc = new Rectangle(0, 0, 0, 0);
        return rc.mousePressed(e);
    }

    public Shape mouseReleased(MouseEvent e) {
        rc.mouseReleased(e);
        shapes.add(rc);
        return rc;
    }

    public Shape mouseDragged(MouseEvent e) {
        return rc.mouseDragged(e);
    }
}