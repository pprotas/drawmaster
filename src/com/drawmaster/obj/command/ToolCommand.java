package com.drawmaster.obj.command;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.tool.Tool;

/**
 * ToolCommand
 */
public abstract class ToolCommand implements Command {
    Tool tool;
    public Shape shape;
    MouseEvent e;

    public ToolCommand(Tool tool, Shape shape, MouseEvent e) {
        this.tool = tool;
        this.shape = shape;
        this.e = e;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
    
}