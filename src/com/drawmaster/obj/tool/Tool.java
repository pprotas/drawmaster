package com.drawmaster.obj.tool;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;

/**
 * Tool
 */
public interface Tool {

    public abstract Shape mousePressed(MouseEvent e);

    public abstract Shape mouseReleased(MouseEvent e);

    public abstract Shape mouseDragged(MouseEvent e);

    public abstract String getType();

    public abstract void undo(); // Redo wordt in de command gedaan

}