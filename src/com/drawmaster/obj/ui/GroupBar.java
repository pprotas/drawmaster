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
import javax.swing.JScrollPane;

import com.drawmaster.obj.shape.Group;

/**
 * GroupBar
 */
public class GroupBar extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;

    private Vector<Group> groups;
    private static Vector<String> groupNames;
    private static JList list;

    public GroupBar(Window window) {
        super(window);
        groups = new Vector<Group>();
        groupNames = new Vector<String>();

        for(Group group : Canvas.getInstance().getGroups().getGroups()) {
            groups.add(group);
            groupNames.add(group.getName());
        }

        setPreferredSize(new Dimension(0, 200));

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        // layout.setHgap(2);
        // layout.setVgap(2);

        setLayout(layout);

        list = new JList(groupNames);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(list, c);

        c.weightx = 1;
        c.weighty = 2;
        c.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(list), c);

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
        delBut.addActionListener(this);
        delBut.setActionCommand("Del");
        add(delBut, c);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action == "Add") {
            int index = list.getSelectedIndex();
            //String val = groupNames.get(index);
            
            String val = "";

            if (index != -1) {
                val = groupNames.get(index);
            }

            Group group;
            if (index == -1) {
                int size = Canvas.getInstance().getGroups().getGroups().size();
                group = new Group("group" + (size+1), Canvas.getInstance().getGroups());
            }
            else {
                int size = groups.get(index).getGroups().size();
                group = new Group(val + "." + (size+1), findGroup(Canvas.getInstance().getGroups(), val));
            }
            if (index == -1) {
                Canvas.getInstance().getGroups().add(group);
            }
            else {
                findGroup(Canvas.getInstance().getGroups(), val).add(group);
            }
            groups.add(group);
            groupNames.add(group.getName());
            list.updateUI();
        }
        if (action == "Del") {
            int index = list.getSelectedIndex();
            String val = groupNames.get(index);
            Group g = findGroup(Canvas.getInstance().getGroups(), val);
            g.getParent().remove(g);
            groups.clear();
            groupNames.clear();
            for (Group group : Canvas.getInstance().getGroups().getGroups()) {
                groups.add(g);
                groupNames.add(group.getName());
            }
            Canvas.getInstance().repaint();
            list.clearSelection();
            list.updateUI();
        }
    }

    public static Group findGroup(Group group, String name) {
        for (Group g : group.getGroups()) {
            if (g.getName() == name) {
                return g;
            }
            else {
                return findGroup(g, name);
            }
        }
        return group;
    }

    public static Group selectGroup() {
        int index = list.getSelectedIndex();
        String val = groupNames.get(index);

        return findGroup(Canvas.getInstance().getGroups(), val);
    }
}