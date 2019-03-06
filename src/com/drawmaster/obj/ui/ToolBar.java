package com.drawmaster.obj.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;

import com.drawmaster.obj.command.Command;
import com.drawmaster.obj.command.SetTool;

/**
 * ToolBar
 */
public class ToolBar extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;

    private Canvas canvas;

    public ToolBar(Window window, Canvas canvas) {
        super(window);

        this.canvas = canvas;

        setPreferredSize(new Dimension(50, 200));

        GridLayout layout = new GridLayout(0, 2);
        layout.setHgap(2);
        layout.setVgap(2);

        setLayout(layout);

        String[] tools = { "Oval", "Rectangle", "Select", "Move", "Resize" };
        for (String t : tools) {
            JButton b = new JButton();
            b.addActionListener(this);
            b.setActionCommand(t);
            add(b);
            // b.setMnemonic(KeyEvent.VK_D);
            // TODO: Possible keyboard shortcuts (For example ALT+R for rectangle tool)
        }

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        Command setTool = new SetTool(canvas, action);
        canvas.commandInvoker.execute(setTool);
    }
}