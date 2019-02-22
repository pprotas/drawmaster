package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;

/**
 * MoveTool
 */
public class MoveTool extends Tool {

    Shape selectedShape;

    public MoveTool(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }

    @Override
    public Shape mousePressed(MouseEvent e) {
        if (selectedShape != null) {
            int oldX = selectedShape.getX();
            int oldY = selectedShape.getY();
            selectedShape.setX(e.getX());
            selectedShape.setY(e.getY());
            int newX = selectedShape.getX();
            int newY = selectedShape.getY();
            selectedShape.setX2(selectedShape.getX2() + (newX - oldX));
            selectedShape.setY2(selectedShape.getY2() + (newY - oldY));
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