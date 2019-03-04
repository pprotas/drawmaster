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
        JMenuItem menuItem;
        JMenuItem menuItem2;

        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Open or save a file");
        this.add(menu);

        menuItem = new JMenuItem("Open File", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Open a file");
        menuItem.setActionCommand("Open");
        menuItem.addActionListener(this);
        menu.add(menuItem);


        menuItem2 = new JMenuItem("Save File", KeyEvent.VK_B);
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItem2.getAccessibleContext().setAccessibleDescription("Save a file");
        menuItem2.addActionListener(this);
        menuItem2.setActionCommand("Save");
        
        menu.add(menuItem2);
        


        this.add(menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        performAction(command);
    }

    public void performAction(String action){
        switch(action){
            case "Open":
                canvas.commandInvoker.setCommand(new FileOpen(dm, canvas));
                canvas.commandInvoker.executeCommand();
                break;
            case "Save":
                canvas.commandInvoker.setCommand(new FileSave(dm, canvas));
                canvas.commandInvoker.executeCommand();
                break;
        }
    }
}