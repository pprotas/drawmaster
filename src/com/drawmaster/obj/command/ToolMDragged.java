package com.drawmaster.obj.command;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.tool.Tool;

/**
 * ToolMDragged
 */
public class ToolMDragged implements Command {
    Tool tool;
    Shape s;
    MouseEvent e;

    public ToolMDragged(Tool tool, Shape s, MouseEvent e) {
        this.tool = tool;
        this.s = s;
        this.e = e;
    }

    @Override
    public void execute() {
        s = tool.mouseDragged(e);
    }

    public void undo() {

    }
}