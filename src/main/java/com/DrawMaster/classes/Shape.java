package main.java.com.DrawMaster.classes;

import java.awt.Graphics;

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

    public void draw() {
        Graphics g = getGraphics();
        draw(g);
    }

    public void setX(int x) {
        this.x = x;
        draw();
    }

    public void setY(int y) {
        this.y = y;
        draw();
    }

    public void setX2(int x2) {
        this.x2 = x2;
        draw();
    }

    public void setY2(int y2) {
        this.y2 = y2;
        draw();
    }

}