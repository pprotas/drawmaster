package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Rectangle;
import com.drawmaster.obj.shape.Shape;

/**
 * RectangleTool
 */
public class RectangleTool extends Tool {
    Rectangle rc;

    public Shape mousePressed(MouseEvent e) {
        rc = new Rectangle(0, 0, 0, 0);
        return rc.mousePressed(e);
    }

    public Shape mouseReleased(MouseEvent e) {
        return rc.mouseReleased(e);
    }

    public Shape mouseDragged(MouseEvent e) {
        return rc.mouseDragged(e);
    }
}