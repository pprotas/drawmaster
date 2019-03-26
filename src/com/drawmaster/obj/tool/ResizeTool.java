package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.visitor.ShapeResizeVisitor;

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
        selectedShape.accept(new ShapeResizeVisitor(e));
        return selectedShape;
    }

    @Override
    public Shape mouseReleased(MouseEvent e) {
        selectedShape.accept(new ShapeResizeVisitor(e));
        return selectedShape;

    }

    @Override
    public Shape mouseDragged(MouseEvent e) {
        selectedShape.accept(new ShapeResizeVisitor(e));
        return selectedShape;
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