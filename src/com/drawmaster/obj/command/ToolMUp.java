package com.drawmaster.obj.command;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.tool.Tool;

/**
 * ToolMUp
 */
public class ToolMUp implements Command {
    Tool tool;
    public Shape shape;
    MouseEvent e;

    public ToolMUp(Tool tool, Shape shape, MouseEvent e) {
        this.tool = tool;
        this.shape = shape;
        this.e = e;
    }

    @Override
    public void execute() {
        shape = tool.mouseReleased(e);
    }

    public void undo() {

    }
}