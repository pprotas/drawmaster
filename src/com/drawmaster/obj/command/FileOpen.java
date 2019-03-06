package com.drawmaster.obj.command;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

import com.drawmaster.main.DrawMaster;
import com.drawmaster.obj.shape.Oval;
import com.drawmaster.obj.shape.Rectangle;
import com.drawmaster.obj.ui.Canvas;

/**
 * FileOpen
 */
public class FileOpen extends FileCommand {

    public FileOpen(DrawMaster dm, Canvas canvas) {
        super(dm, canvas);
    }

    @Override
    public void execute() {
        canvas.clearList();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open a file");

        fileChooser.showOpenDialog(dm);

        Scanner sc = null;

        try {
            sc = new Scanner(fileChooser.getSelectedFile());
        } catch (Exception e) {
        }

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
                try {
                    x = Integer.parseInt(words.get(++i));
                    y = Integer.parseInt(words.get(++i));
                    x2 = Integer.parseInt(words.get(++i));
                    y2 = Integer.parseInt(words.get(++i));
                } catch (Exception e) {
                }
                canvas.addShape(new Oval(x, y, x2, y2));

                break;
            case "rectangle":
                try {
                    x = Integer.parseInt(words.get(++i));
                    y = Integer.parseInt(words.get(++i));
                    x2 = Integer.parseInt(words.get(++i));
                    y2 = Integer.parseInt(words.get(++i));
                } catch (Exception e) {
                }
                canvas.addShape(new Rectangle(x, y, x2, y2));
                break;
            }
            canvas.repaint();
        }
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}