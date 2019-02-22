package com.drawmaster.obj.command;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.tool.Tool;

/**
 * ToolMDown
 */
public class ToolMDown implements Command {
    Tool tool;
    public Shape s;
    MouseEvent e;

    public ToolMDown(Tool tool, Shape s, MouseEvent e) {
        this.tool = tool;
        this.s = s;
        this.e = e;
    }

    @Override
    public void execute() {
        s = tool.mousePressed(e);
    }

    public void undo() {

    }
}