package com.drawmaster.obj.visitor;

import java.io.FileWriter;

import javax.swing.JFileChooser;

import com.drawmaster.main.DrawMaster;
import com.drawmaster.obj.shape.Group;
import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.ui.Canvas;

/**
 * ShapeMoveVisitor
 */
public class DrawMasterSaveVisitor implements DrawMasterVisitor {

    @Override
    public void visit(DrawMaster dm) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save file");

        fileChooser.showSaveDialog(dm);

        FileWriter fw = null;
        try {
            fw = new FileWriter(fileChooser.getSelectedFile(), false);
        } catch (Exception e) {

        }

        Group g = Canvas.getInstance().getGroups();
        try {
            fw.write("group " + g.getShapes().size() + "\r\n");
        } catch (Exception e) {
        }

        for (Shape s : Canvas.getInstance().getGroups().getShapes()) {
            try {
                if (fw != null) {

                    fw.write(
                            "\t" + s.getType() + " " + s.getX() + " " + s.getY() + " " + s.getX2() + " " + s.getY2() + "\r\n");
                }
            } catch (Exception e) {
            }
        }

        try {
            fw.close();
        } catch (Exception e) {
        }
    }

}