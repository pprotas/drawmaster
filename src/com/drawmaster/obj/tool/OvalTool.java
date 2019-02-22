package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Oval;
import com.drawmaster.obj.shape.Shape;
import java.util.List;

/**
 * OvalTool
 */
public class OvalTool extends ShapeTool {
    Oval ov;

    public OvalTool(List<Shape> shapes) {
        super(shapes);
    }

    public Shape mousePressed(MouseEvent e) {
        ov = new Oval(0, 0, 0, 0);

        return ov.mousePressed(e);
    }

    public Shape mouseReleased(MouseEvent e) {
        ov.mouseReleased(e);
        shapes.add(ov);
        return ov;
    }

    public Shape mouseDragged(MouseEvent e) {
        return ov.mouseDragged(e);
    }
}