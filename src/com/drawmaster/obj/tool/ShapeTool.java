package com.drawmaster.obj.tool;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.ui.Canvas;

import java.util.List;
import java.util.LinkedList;

/**
 * ShapeTool
 */
public abstract class ShapeTool implements Tool {
    protected Canvas canvas;
    public List<Shape> shapes = new LinkedList<Shape>();;
    public Shape shape;

    public ShapeTool(Canvas canvas, List<Shape> shapes) {
        this.canvas = canvas;
        this.shapes = shapes;
    }

    @Override
    public void undo() {
        shapes.remove(shape);
    }
}