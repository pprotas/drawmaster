package com.drawmaster.obj.strategy;

import com.drawmaster.obj.decorator.TextShapeDecorator;
import com.drawmaster.obj.shape.*;
import java.awt.event.MouseEvent;

/**
 * OvalDelegate
 */
public class OvalToolDelegate implements Strategy {

    @Override
    public Shape execute(MouseEvent e) {
        return new Shape(e.getX(), e.getY(), e.getX(), e.getY(), new OvalDelegate());
    }

    @Override
    public String toString() {
        return "Oval";
    }
}