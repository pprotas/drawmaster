package com.drawmaster.obj.visitor;

import com.drawmaster.obj.shape.Shape;

/**
 * ShapeVisitor
 */
public interface ShapeVisitor {

    public void visit(Shape shape);
}