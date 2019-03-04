package com.drawmaster.obj.command;

import java.io.FileWriter;

import javax.swing.JFileChooser;

import com.drawmaster.main.DrawMaster;
import com.drawmaster.obj.shape.Shape;
import com.drawmaster.obj.ui.Canvas;

/**
 * FileSave
 */
public class FileSave extends FileCommand {

    public FileSave(DrawMaster dm, Canvas canvas) {
        super(dm, canvas);
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save file");

        fileChooser.showSaveDialog(dm);

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
    
    @Override
    public void undo() {
    
    }
}