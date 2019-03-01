package com.drawmaster.obj.shape;

import java.awt.Graphics;

/**
 * Rectangle
 */
public class Rectangle extends Shape {
    private static final long serialVersionUID = 1L;

    public Rectangle(int x, int y, int x2, int y2) {
        super(x, y, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(Math.min(x, x2), Math.min(y, y2), Math.abs(x - x2), Math.abs(y - y2));
    }

    @Override
    public String getType() {
        return "rectangle";
    }

}