package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Group;
import com.drawmaster.obj.shape.Oval;
import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.ui.Canvas;

/**
 * OvalTool
 */
public class OvalTool extends ShapeTool {
    public OvalTool(Canvas canvas, Group shapes) {
        super(canvas, shapes);
    }

    public Shape mousePressed(MouseEvent e) {
        shape = new Oval(e.getX(), e.getY(), e.getX(), e.getY());
        return shape;
    }

    @Override
    public String getType() {
        return "Oval";
    }

}