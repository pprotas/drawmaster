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
        if (!(cmd instanceof ToolMDown || cmd instanceof ToolMDragged || cmd instanceof SetTool)) {
            undoStack.push(cmd);
            redoStack.clear();
        }
        cmd.execute();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
    }

    public void redo() {
        Command cmd = redoStack.pop();
        cmd.execute();
        undoStack.push(cmd);
    }
}