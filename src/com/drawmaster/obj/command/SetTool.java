package com.drawmaster.obj.command;

import com.drawmaster.obj.ui.Canvas;

/**
 * SetTool
 */
public class SetTool implements Command {
    private Canvas canvas;
    private String tool;

    public SetTool(Canvas canvas, String tool) {
        this.canvas = canvas;
        this.tool = tool;
    }

    @Override
    public void execute() {
        canvas.setTool(tool);
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}