package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;

/**
 * MoveTool
 */
public class ResizeTool implements Tool {

    Shape selectedShape;

    public ResizeTool(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }

    @Override
    public Shape mousePressed(MouseEvent e) {
        if (selectedShape != null) {
            selectedShape.setX2(e.getX());
            selectedShape.setY2(e.getY());

        }
        return selectedShape;
    }

    @Override
    public Shape mouseReleased(MouseEvent e) {
        return selectedShape;
    }

    @Override
    public Shape mouseDragged(MouseEvent e) {
        return mousePressed(e);
    }

}