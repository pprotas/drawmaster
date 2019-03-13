package com.drawmaster.obj.shape;

import java.awt.Graphics;
import java.util.List;
import java.util.LinkedList;

/**
 * Group
 */
public class Group extends Shape {

    private static final long serialVersionUID = 1L;

    private List<Shape> shapes = new LinkedList<Shape>();

    public Group() {
        super(0, 0, 0, 0);
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public String getType() {
        return "group";
    }

    public void addShape(Shape s) {
        shapes.add(s);
    }

    public void removeShape(Shape s) {
        shapes.remove(s);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    
}