package com.drawmaster.obj.strategy;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import com.drawmaster.obj.shape.Shape;

/**
 * Strategy
 */
public interface Strategy {

    public Shape execute(MouseEvent e);
    public void draw(Graphics g, Shape shape);
    public String toString();
}