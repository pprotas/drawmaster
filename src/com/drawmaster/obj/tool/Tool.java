package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;

/**
 * Tool
 */
public abstract class Tool {

    public abstract Shape mousePressed(MouseEvent e);

    public abstract Shape mouseReleased(MouseEvent e);

    public abstract Shape mouseDragged(MouseEvent e);
}