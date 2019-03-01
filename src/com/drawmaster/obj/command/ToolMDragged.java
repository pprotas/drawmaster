package com.drawmaster.obj.command;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.tool.Tool;

/**
 * ToolMDragged
 */
public class ToolMDragged extends ToolCommand {
public ToolMDragged(Tool tool, Shape shape, MouseEvent e) {
        super(tool, shape, e);
    }

    @Override
    public void execute() {
        shape = tool.mouseDragged(e);
    }

    public void undo() {

    }
}