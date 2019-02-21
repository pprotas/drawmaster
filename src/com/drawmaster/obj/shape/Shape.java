package com.drawmaster.obj.shape;

import java.awt.Graphics;
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