package com.drawmaster.obj.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import com.drawmaster.main.*;
import com.drawmaster.obj.command.FileOpen;
import com.drawmaster.obj.command.FileSave;

/**
 * MenuBar
 */
public class MenuBar extends JMenuBar implements ActionListener {
    private static final long serialVersionUID = 1L;

    private DrawMaster dm;
    private Canvas canvas;

    public MenuBar(DrawMaster dm, Canvas canvas) {
        super();
        this.dm = dm;
        this.canvas = canvas;
        JMenu menu;
        JMenuItem open;
        JMenuItem save;
        JMenuItem undo;
        JMenuItem redo;

        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Open or save a file");
        this.add(menu);

        open = new JMenuItem("Open File", KeyEvent.VK_T);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        open.getAccessibleContext().setAccessibleDescription("Open a file");
        open.setActionCommand("Open");
        open.addActionListener(this);
        menu.add(open);

        save = new JMenuItem("Save File", KeyEvent.VK_B);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        save.getAccessibleContext().setAccessibleDescription("Save a file");
        save.addActionListener(this);
        save.setActionCommand("Save");

        undo = new JMenuItem("Undo", KeyEvent.VK_Z);
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undo.getAccessibleContext().setAccessibleDescription("Undo");
        undo.addActionListener(this);
        undo.setActionCommand("Undo");
        menu.add(undo);

        redo = new JMenuItem("Redo", KeyEvent.VK_Z);
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        redo.getAccessibleContext().setAccessibleDescription("Redo");
        redo.addActionListener(this);
        redo.setActionCommand("Redo");
        menu.add(redo);

        this.add(menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        performAction(command);
    }

    public void performAction(String action) {
        switch (action) {
        case "Open":
            canvas.getInvoker().execute(new FileOpen(dm, canvas));
            break;
        case "Save":
            canvas.getInvoker().execute(new FileSave(dm, canvas));
            break;
        case "Undo":
            canvas.getInvoker().undo();
            canvas.repaint();
            canvas.nullSelectedShape();
            break;
        case "Redo":
            canvas.getInvoker().redo();
            canvas.repaint();
            canvas.nullSelectedShape();
        }
    }
}