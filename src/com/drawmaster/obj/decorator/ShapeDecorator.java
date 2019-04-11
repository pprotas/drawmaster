package com.drawmaster.obj.decorator;

import java.awt.Graphics;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.strategy.Strategy;

/**
 * ShapeDecorator
 */
public abstract class ShapeDecorator {

    public abstract void draw(Graphics g, Shape shape);
}