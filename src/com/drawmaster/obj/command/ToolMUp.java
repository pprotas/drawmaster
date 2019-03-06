package com.drawmaster.obj.command;

import java.awt.event.MouseEvent;

import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.tool.Tool;

/**
 * ToolMUp
 */
public class ToolMUp extends ToolCommand {
    public ToolMUp(Tool tool, Shape shape, MouseEvent e) {
        super(tool, shape, e);
    }

    @Override
    public void execute() {
        shape = tool.mouseReleased(e);
    }

    public void undo() {
        tool.undo();
    }

    @Override
    public void redo() {

    }
}