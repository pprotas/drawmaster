package com.drawmaster.obj.shape;

import java.util.List;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Group
 */
public class Group {

    private List<Shape> shapes;
    private List<Group> subGroups;

    public Group() {
        shapes = new LinkedList<Shape>();
        subGroups = new LinkedList<Group>();
    }

    public void draw(Graphics g) {
        for (Group group : subGroups) {
            group.draw(g);
        }

        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public List<Shape> getShapes() {
        List<Shape> shapes = new LinkedList<Shape>();

        for (Shape shape : this.shapes) {
            shapes.add(shape);
        }

        for (Group group : subGroups) {
            shapes.addAll(group.getShapes());
        }

        return shapes;
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void remove(Shape shape) {
        shapes.remove(shape);
    }

    public void add(Group group) {
        subGroups.add(group);
    }

    public void remove(Group group) {
        subGroups.remove(group);
    }

    public void clear() {
        shapes = null;
        subGroups = null;
    }
}