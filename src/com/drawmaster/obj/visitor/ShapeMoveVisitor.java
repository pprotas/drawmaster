package com.drawmaster.obj.visitor;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Rectangle;
import com.drawmaster.obj.shape.Shape;

/**
 * ShapeMoveVisitor
 */
public class ShapeMoveVisitor implements ShapeVisitor {

    MouseEvent e;

    public ShapeMoveVisitor(MouseEvent e) {
        this.e = e;
    }

    @Override
    public void visit(Shape shape) {
        int x = shape.getX();
        int y = shape.getY();
        shape.setX(e.getX());
        shape.setY(e.getY());
        int newX = shape.getX();
        int newY = shape.getY();
        shape.setX2(shape.getX2() + (newX - x));
        shape.setY2(shape.getY2() + (newY - y));
    }

}