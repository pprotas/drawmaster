package com.drawmaster.obj.strategy;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;

/**
 * OvalDelegate
 */
public class OvalDelegate implements Strategy {
    public void draw(Graphics g, Shape shape) {
        g.drawOval(Math.min(shape.getX(), shape.getX2()), Math.min(shape.getY(), shape.getY2()),
                Math.abs(shape.getX() - shape.getX2()), Math.abs(shape.getY() - shape.getY2()));
    }

    public String toString() {
        return "Oval";
    }

    @Override
    public Shape execute(MouseEvent e) {
        return null;
    }
}