package com.drawmaster.obj.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.ListModel;

import com.drawmaster.obj.shape.Group;

/**
 * GroupBar
 */
public class GroupBar extends JDialog {

    private static final long serialVersionUID = 1L;

    private Canvas canvas;
    private Vector<Group> groups;

    public GroupBar(Window window, Canvas canvas) {
        super(window);

        this.canvas = canvas;

        groups = new Vector<Group>();

        groups.add(new Group());

        Group group = new Group();
        groups.add(group);

        setPreferredSize(new Dimension(50, 200));

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        //layout.setHgap(2);
        //layout.setVgap(2);

        setLayout(layout);

        JList list = new JList(groups);
        c.gridx = 2;
        c.gridy = 3;
        add(list, c);

        JButton addBut = new JButton();
        c.gridx = 0;
        c.gridy = 1;
        add(addBut, c);

        JButton delBut = new JButton();
        add(delBut, c);

        pack();
        setVisible(true);
    }
}