package com.drawmaster.obj.command;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.tool.Tool;

/**
 * ToolCommand
 */
public abstract class ToolCommand implements Command {
    protected Tool tool;
    protected Shape shape;
    protected MouseEvent e;

    // Base class voor tool-gerelateerde commands
    public ToolCommand(Tool tool, Shape shape, MouseEvent e) {
        this.tool = tool;
        this.shape = shape;
        this.e = e;
    }

    public Shape getShape(){
        return shape;
    }
    @Override
    public void execute() {

    }

    public abstract void undo();
    
    public abstract void redo();
    
}