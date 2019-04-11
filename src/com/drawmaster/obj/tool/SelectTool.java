package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Group;
import com.drawmaster.obj.shape.Shape;

/**
 * SelectTool
 */
public class SelectTool implements Tool {
    private Group shapes = new Group();;

    public SelectTool(Group shapes) {
        this.shapes = shapes;
    }

    @Override
    public Shape mousePressed(MouseEvent e) {
        for (Shape s : shapes.getShapes()) {
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

    public String getType() {
        return "Select";
    }

    @Override
    public void undo() {

    }
}