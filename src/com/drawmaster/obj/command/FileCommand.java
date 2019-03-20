package com.drawmaster.obj.command;

import com.drawmaster.main.DrawMaster;
import com.drawmaster.obj.ui.Canvas;

/**
 * FileCommand
 */
public abstract class FileCommand implements Command {

    protected DrawMaster dm;
    protected Canvas canvas;

    // Base class voor file-gerelateerde commands
    FileCommand(DrawMaster dm, Canvas canvas) {
        this.dm = dm;
        this.canvas = canvas;
    }

    @Override
    public void execute() {

    }
}