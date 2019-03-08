package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;

/**
 * MoveTool
 */
public class MoveTool implements Tool {

    private Shape selectedShape;
    private int oldX;
    private int oldX2;
    private int oldY;
    private int oldY2;

    public MoveTool(Shape selectedShape) {
        this.selectedShape = selectedShape;
        oldX = selectedShape.getX();
        oldX2 = selectedShape.getX2();
        oldY = selectedShape.getY();
        oldY2 = selectedShape.getY2();
    }

    @Override
    public Shape mousePressed(MouseEvent e) {
        return selectedShape;
    }

    @Override
    public Shape mouseReleased(MouseEvent e) {
        if (selectedShape != null) {
            int x = selectedShape.getX();
            int y = selectedShape.getY();
            selectedShape.setX(e.getX());
            selectedShape.setY(e.getY());
            int newX = selectedShape.getX();
            int newY = selectedShape.getY();
            selectedShape.setX2(selectedShape.getX2() + (newX - x));
            selectedShape.setY2(selectedShape.getY2() + (newY - y));
        }
        return selectedShape;
    }

    @Override
    public Shape mouseDragged(MouseEvent e) {
        return mouseReleased(e);
    }

    @Override
    public String getType() {
        return "Move";
    }

    @Override
    public void undo() {
        selectedShape.setX(oldX);
        selectedShape.setX2(oldX2);
        selectedShape.setY(oldY);
        selectedShape.setY2(oldY2);
    } 
}