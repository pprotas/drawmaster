package com.drawmaster.obj.visitor;

import com.drawmaster.main.DrawMaster;

/**
 * ShapeVisitor
 */
public interface DrawMasterVisitor {

    public void visit(DrawMaster dm);
}