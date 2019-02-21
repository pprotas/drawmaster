package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Oval;
import com.drawmaster.obj.shape.Shape;

/**
 * OvalTool
 */
public class OvalTool extends Tool {
    Oval ov;

    public Shape mousePressed(MouseEvent e) {
        ov = new Oval(0, 0, 0, 0);
        return ov.mousePressed(e);
    }

    public Shape mouseReleased(MouseEvent e) {
        return ov.mouseReleased(e);
    }

    public Shape mouseDragged(MouseEvent e) {
        return ov.mouseDragged(e);
    }
}