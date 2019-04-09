package com.drawmaster.obj.strategy;

import java.awt.event.MouseEvent;
import com.drawmaster.obj.shape.Shape;

/**
 * Strategy
 */
public interface Strategy {

    public Shape getShape(MouseEvent e);
    public String toString();
}