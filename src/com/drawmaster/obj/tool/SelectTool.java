package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import java.util.List;
import java.util.LinkedList;

/**
 * SelectTool
 */
public class SelectTool implements Tool {
    List<Shape> shapes = new LinkedList<Shape>();;

    public SelectTool(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public Shape mousePressed(MouseEvent e) {
        for (Shape s : shapes) {
            if (s != null) {
                if (s.contains(e.getPoint())) {
                    return s;
                }
            }
        }
        return null;
    }

    @Override
    public Shape mouseReleased(MouseEvent e) {
        return mousePressed(e);
    }

    @Override
    public Shape mouseDragged(MouseEvent e) {
        return mousePressed(e);
    }

}