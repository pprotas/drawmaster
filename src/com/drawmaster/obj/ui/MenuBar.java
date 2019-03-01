package com.drawmaster.obj.ui;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.drawmaster.main.*;
import com.drawmaster.obj.shape.*;


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
                openFile();
                break;
            case "Save":
                saveFile();
                break;
        }
    }

    public void openFile() {
        canvas.clearList();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open a file");

        int returnVal = fileChooser.showOpenDialog(dm);

        String content = " ";

        Scanner sc = null;

        try {
        sc = new Scanner(fileChooser.getSelectedFile());
        }
        catch (Exception e){}

        ArrayList<String> words = new ArrayList<String>();

        while (sc.hasNext()) {
            words.add(sc.next());
        }

        

        for (int i = 0; i < words.size(); i++) {
            int x = 0;
            int y = 0;
            int x2 = 0;
            int y2 = 0;
            switch (words.get(i)) {
                case "oval":
                    try{
                        x = Integer.parseInt(words.get(++i));
                        y = Integer.parseInt(words.get(++i));
                        x2 = Integer.parseInt(words.get(++i));
                        y2 = Integer.parseInt(words.get(++i));
                    }
                    catch(Exception e){}
                    canvas.addShape(new Oval(x, y, x2, y2));

                    break;
                case "rectangle":
                    try{
                        x = Integer.parseInt(words.get(++i));
                        y = Integer.parseInt(words.get(++i));
                        x2 = Integer.parseInt(words.get(++i));
                        y2 = Integer.parseInt(words.get(++i));
                    }
                    catch(Exception e){}
                    canvas.addShape(new Rectangle(x, y, x2, y2));
                    break;
            }
            canvas.repaint();
        }
    }

    public void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save file");

        int returnVal = fileChooser.showSaveDialog(dm);

        FileWriter fw = null;
        try{
        fw = new FileWriter(fileChooser.getSelectedFile(), false);
        }
        catch(Exception e){

        }
        for (Shape s: canvas.getShapes()) {
            try{
                if(fw !=null){
                
                fw.write(s.getType() + " " + s.getX() + " " + s.getY() + " " + s.getX2() + " " + s.getY2() + "\r\n");
                }
            }
            catch(Exception e){}
        }
        try {
            fw.close();
        }
        catch(Exception e){}

    }
}