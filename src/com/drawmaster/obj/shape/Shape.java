package com.drawmaster.obj.shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

/**
 * Shape
 */
public abstract class Shape extends JComponent {

    private static final long serialVersionUID = 1L;
    protected int x;
    protected int y;
    protected int x2;
    protected int y2;

    Shape(int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    public abstract void draw(Graphics g); // Allows for dynamic draw() calls for different shapes
    public abstract String getType();
    public boolean contains(Point p) {
        if (!(p.x >= x && p.x <= x2 && p.y >= y && p.y <= y2)) {
            return false;
        }
        return true;
    }

    public Shape mousePressed(MouseEvent e) {
        this.setX(e.getX());
        this.setY(e.getY());
        return this;
    }

    public Shape mouseReleased(MouseEvent e) {
        this.setX2(e.getX());
        this.setY2(e.getY());
        return this;
    }

    public Shape mouseDragged(MouseEvent e) {
        this.setX2(e.getX());
        this.setY2(e.getY());
        return this;
    }

    public int getX() {
        return x;
    }

    public int getX2() {
        return x2;
    }

    public int getY() {
        return y;
    }

    public int getY2() {
        return y2;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

}