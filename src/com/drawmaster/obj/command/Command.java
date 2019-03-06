package com.drawmaster.obj.command;

/**
 * Command
 */
public interface Command {
    public void execute();

    public void undo();

    public void redo();
}