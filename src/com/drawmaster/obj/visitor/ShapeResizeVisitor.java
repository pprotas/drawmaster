package com.drawmaster.obj.visitor;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Rectangle;
import com.drawmaster.obj.shape.Shape;

/**
 * ShapeResizeVisitor
 */
public class ShapeResizeVisitor implements ShapeVisitor {

    MouseEvent e;

    public ShapeResizeVisitor(MouseEvent e) {
        this.e = e;
    }

    @Override
    public void visit(Shape shape) {
        shape.setX2(e.getX());
        shape.setY2(e.getY());
    }

}