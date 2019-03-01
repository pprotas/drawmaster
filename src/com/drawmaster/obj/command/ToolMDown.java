package com.drawmaster.obj.command;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.tool.Tool;

/**
 * ToolMDown
 */
public class ToolMDown extends ToolCommand {
    public ToolMDown(Tool tool, Shape shape, MouseEvent e) {
        super(tool, shape, e);
    }

    @Override
    public void execute() {
        shape = tool.mousePressed(e);
    }

    public void undo() {

    }
}