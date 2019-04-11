package com.drawmaster.obj.strategy;

import com.drawmaster.obj.shape.*;
import java.awt.event.MouseEvent;

/**
 * RectangleDelegate
 */
public class RectangleToolDelegate implements Strategy {

    @Override
    public Shape execute(MouseEvent e) {
        return new Shape(e.getX(), e.getY(), e.getX(), e.getY(), new RectangleDelegate());
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}