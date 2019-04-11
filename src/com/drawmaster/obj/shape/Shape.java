package com.drawmaster.obj.shape;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;

import com.drawmaster.obj.decorator.ShapeDecorator;
import com.drawmaster.obj.decorator.TextShapeDecorator;
import com.drawmaster.obj.strategy.Context;
import com.drawmaster.obj.strategy.Strategy;
import com.drawmaster.obj.visitor.ShapeVisitor;

/**
 * Shape
 */
public class Shape extends JComponent {

    private static final long serialVersionUID = 1L;
    protected int x;
    protected int y;
    protected int x2;
    protected int y2;
    private Strategy delegate;
    private ShapeDecorator decorator;

    public Shape(int x, int y, int x2, int y2, Strategy delegate) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.delegate = delegate;
    }
    public void draw(Graphics g) {
        Context context = new Context(delegate);
        context.draw(g, this);
        if (decorator != null) {
            decorator.draw(g, this);
        }
    } // Allows for dynamic draw() calls for different shapes

    public void addDecorator(ShapeDecorator decorator) {
        this.decorator = decorator;
    }
    public String getType() {
        return delegate.toString();
    }

    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }

    public boolean contains(Point p) {
        if (p.x <= x && p.x >= x2 && p.y <= y && p.y >= y2) {
            return true;
        }
        return false;
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