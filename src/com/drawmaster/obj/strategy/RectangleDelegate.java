package com.drawmaster.obj.strategy;

import com.drawmaster.obj.shape.*;
import java.awt.event.MouseEvent;

/**
 * RectangleDelegate
 */
public class RectangleDelegate implements Strategy {

    @Override
    public Shape getShape(MouseEvent e) {
        return new Rectangle(e.getX(), e.getY(), e.getX(), e.getY());
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}