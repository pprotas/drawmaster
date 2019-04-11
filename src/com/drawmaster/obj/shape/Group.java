package com.drawmaster.obj.shape;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Group
 */
public class Group {

    private String groupName;
    private List<Shape> shapes;
    private List<Group> subGroups;
    private Group parent;

    public Group() {
        shapes = new LinkedList<Shape>();
        subGroups = new LinkedList<Group>();
    }

    public Group(String groupName, Group parent) {
        this.groupName = groupName;
        shapes = new LinkedList<Shape>();
        subGroups = new LinkedList<Group>();
        this.parent = parent;
    }

    public void draw(Graphics g) {
        if (subGroups != null) {
            for (Group group : subGroups) {
                group.draw(g);
            }
        }

        if(shapes != null) {
            for (Shape shape : shapes) {
                shape.draw(g);
            }
        }  
    }

    public String getName() {
        return groupName;
    }

    public List<Shape> getShapes() {
        List<Shape> shapes = new LinkedList<Shape>();

        for (Shape shape : this.shapes) {
            shapes.add(shape);
        }

        //for (Group group : subGroups) {
        //    shapes.addAll(group.getShapes());
        //}

        return shapes;
    }

    public List<Group> getGroups() {
        return subGroups;
    }

    public Group getParent() {
        return parent;
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
        shapes = new LinkedList<Shape>();
        subGroups = new LinkedList<Group>();
    }
}