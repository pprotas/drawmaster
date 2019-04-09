package com.drawmaster.obj.strategy;

import com.drawmaster.obj.shape.*;
import java.awt.event.MouseEvent;

/**
 * OvalDelegate
 */
public class OvalDelegate implements Strategy {

    @Override
    public Shape getShape(MouseEvent e) {
        return new Oval(e.getX(), e.getY(), e.getX(), e.getY());
    }

    @Override
    public String toString() {
        return "Oval";
    }
}