package com.drawmaster.obj.shape;

import java.awt.Graphics;

/**
 * Oval
 */
public class Oval extends Shape {
    private static final long serialVersionUID = 1L;

    public Oval(int x, int y, int x2, int y2) {
        super(x, y, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(Math.min(x, x2), Math.min(y, y2), Math.abs(x - x2), Math.abs(y - y2));
    }
}