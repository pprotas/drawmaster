package com.drawmaster.obj.command;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.tool.Tool;

/**
 * ToolMUp
 */
public class ToolMUp implements Command {
    Tool tool;
    public Shape s;
    MouseEvent e;

    public ToolMUp(Tool tool, Shape s, MouseEvent e) {
        this.tool = tool;
        this.s = s;
        this.e = e;
    }

    @Override
    public void execute() {
        s = tool.mouseReleased(e);
    }

    public void undo() {

    }
}