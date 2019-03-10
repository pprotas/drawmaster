package com.drawmaster.obj.command;

import java.util.Stack;

/**
 * Invoker
 */
public class Invoker {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public Invoker() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void execute(Command cmd) {
        if (cmd instanceof ToolCommand) {
            undoStack.push(cmd);
            redoStack.clear();
        }
        cmd.execute();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            ((ToolCommand)cmd).undo();
            redoStack.push(cmd);
        }
    }

    public void redo() {
        Command cmd = redoStack.pop();
        ((ToolCommand)cmd).redo();
        undoStack.push(cmd);
    }
}