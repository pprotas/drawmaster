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
        shape = new Oval(0, 0, 0, 0);

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