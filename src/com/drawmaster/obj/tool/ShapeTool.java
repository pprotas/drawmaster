package com.drawmaster.obj.tool;

import com.drawmaster.obj.shape.Shape;
import java.util.List;
import java.util.LinkedList;

/**
 * ShapeTool
 */
public abstract class ShapeTool implements Tool {
    public List<Shape> shapes = new LinkedList<Shape>();;
    public Shape shape;

    public ShapeTool(List<Shape> shapes) {
        this.shapes = shapes;
    }

}