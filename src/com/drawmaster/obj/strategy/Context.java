package com.drawmaster.obj.strategy;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;

/**
 * Context
 */
public class Context {

    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public Shape execute(MouseEvent e) {
        return strategy.execute(e);
    }

    public void draw(Graphics g, Shape shape) {
        strategy.draw(g, shape);
    }
}