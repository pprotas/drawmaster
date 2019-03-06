package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;

/**
 * MoveTool
 */
public class ResizeTool implements Tool {

    private Shape selectedShape;
    private int oldX2;
    private int oldY2;

    public ResizeTool(Shape selectedShape) {
        this.selectedShape = selectedShape;
        oldX2 = selectedShape.getX2();
        oldY2 = selectedShape.getY2();
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

    @Override
    public void undo() {
        selectedShape.setX2(oldX2);
        selectedShape.setY2(oldY2);
    }

    @Override
    public String getType() {
        return "Resize";
    }

}