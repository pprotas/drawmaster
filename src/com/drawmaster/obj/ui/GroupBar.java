package com.drawmaster.obj.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;

import com.drawmaster.obj.shape.Group;

/**
 * GroupBar
 */
public class GroupBar extends JDialog implements ActionListener {

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

        setPreferredSize(new Dimension(0, 200));

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        // layout.setHgap(2);
        // layout.setVgap(2);

        setLayout(layout);

        JList list = new JList(groups);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(list, c);

        JButton addBut = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        addBut.addActionListener(this);
        addBut.setActionCommand("Add");
        add(addBut, c);

        JButton delBut = new JButton("Del");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        addBut.addActionListener(this);
        addBut.setActionCommand("Del");
        add(delBut, c);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
    }
}