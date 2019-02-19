package com;

import java.awt.Graphics;

/**
 * Rectangle
 */
public class Rectangle extends Shape {

    Rectangle(int x, int y, int x2, int y2) {
        super(x, y, x2, y2);
    }

    public void draw(Graphics g) {

        g.drawRect(Math.min(x, x2), Math.min(y, y2), Math.abs(x - x2), Math.abs(y - y2));
    }

}