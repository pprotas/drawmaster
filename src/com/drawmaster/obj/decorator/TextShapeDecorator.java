package com.drawmaster.obj.decorator;

import java.awt.Graphics;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.strategy.Strategy;

/**
 * TextShapeDecorator
 */
public class TextShapeDecorator extends ShapeDecorator {
    private String text;
    public TextShapeDecorator(String text) {
        this.text = text;
    }
    
    @Override
    public void draw(Graphics g, Shape shape) {
        updateText(g, shape);
    }

    private void updateText(Graphics g, Shape shape) {
        g.drawString(text, shape.getX(), shape.getY());
    }
}