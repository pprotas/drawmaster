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
<<<<<<< HEAD
        if (cmd instanceof ToolCommand) { // Alleen tool command moeten undo en redo hebben. De rest (filecommands en change tool commands) niet.
=======
        if (cmd instanceof ToolMUp) {
>>>>>>> 33ca5e1ccadb2595f1da6b4c6f9cd035901faf36
            undoStack.push(cmd);
            redoStack.clear();
        }
        cmd.execute();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            ((ToolCommand) cmd).undo();
            redoStack.push(cmd);
        }
    }

    public void redo() {
        Command cmd = redoStack.pop();
        ((ToolCommand) cmd).redo();
        undoStack.push(cmd);
    }
}