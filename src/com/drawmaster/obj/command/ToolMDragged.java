package com.drawmaster.obj.command;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.tool.Tool;

/**
 * ToolMDragged
 */
public class ToolMDragged implements Command {
    Tool tool;
    Shape shape;
    MouseEvent e;

    public ToolMDragged(Tool tool, Shape shape, MouseEvent e) {
        this.tool = tool;
        this.shape = shape;
        this.e = e;
    }

    @Override
    public void execute() {
        shape = tool.mouseDragged(e);
    }

    public void undo() {

    }
}