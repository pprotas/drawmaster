package com.drawmaster.obj.command;

import com.drawmaster.main.DrawMaster;
import com.drawmaster.obj.ui.Canvas;
import com.drawmaster.obj.visitor.DrawMasterSaveVisitor;

/**
 * FileSave
 */
public class FileSave extends FileCommand {

    public FileSave(DrawMaster dm, Canvas canvas) {
        super(dm, canvas);
    }

    @Override
    public void execute() {
        dm.accept(new DrawMasterSaveVisitor());
    }
}