package com.drawmaster.obj.strategy;
import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;

/**
 * Context
 */
public class Context {

    private Strategy strategy;
    private MouseEvent e;
    public Context(Strategy strategy, MouseEvent e){
        this.strategy = strategy;
        this.e = e;
    }

    public Shape execute() {
        return strategy.getShape(e);
    }
}