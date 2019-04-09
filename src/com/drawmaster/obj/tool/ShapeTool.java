package com.drawmaster.obj.tool;

import com.drawmaster.obj.shape.Group;
import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.strategy.Context;
import com.drawmaster.obj.strategy.OvalDelegate;
import com.drawmaster.obj.strategy.Strategy;
import com.drawmaster.obj.ui.Canvas;

import java.awt.event.MouseEvent;

/**
 * ShapeTool
 */
public class ShapeTool implements Tool {
    protected Canvas canvas;
    public Group shapes;
    public Shape shape;
    private Strategy delegate;
    
    public ShapeTool(Canvas canvas, Group shapes, Strategy delegate) {
        this.canvas = canvas;
        this.shapes = shapes;
        this.delegate = delegate;
    }

    public Shape mousePressed(MouseEvent e) {
        Context context = new Context(delegate, e);
        shape = context.execute();
        /* shape = new Rectangle(e.getX(), e.getY(), e.getX(), e.getY()); */
        return shape;
    }

    public Shape mouseReleased(MouseEvent e) {
        shape.setX(e.getX());
        shape.setY(e.getY());
        shapes.add(shape);

        canvas.setTool(delegate.toString());
        return shape;
    }

    public Shape mouseDragged(MouseEvent e) {
        shape.setX(e.getX());
        shape.setY(e.getY());
        return shape;
    }

    @Override
    public void undo() {
        shapes.remove(shape);
    }
}