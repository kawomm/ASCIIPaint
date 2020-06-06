package org.schuermann.asciipaint.shape.extensions.uml;


import org.schuermann.asciipaint.shape.ASCIIComplexShape;
import org.schuermann.asciipaint.shape.ASCIIRect;


public class ASCIIUMLClass extends ASCIIComplexShape {

    private ASCIIRect clazz;
    private ASCIIRect attribs;
    private ASCIIRect methods;

    private int clazzHeight = 3;
    private int attribsHeight = 5;
    private int methodsHeight = 3;


    public ASCIIUMLClass(int x, int y) {
        super(x,y);
        clazz = new ASCIIRect(x,y,20,clazzHeight);
        add(clazz);
        attribs = new ASCIIRect(x,y+clazzHeight-1,20,attribsHeight);
        add(attribs);
        methods = new ASCIIRect(x,y+clazzHeight+attribsHeight-1,20,methodsHeight);
        add(methods);
    }


}
