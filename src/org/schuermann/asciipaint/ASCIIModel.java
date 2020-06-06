package org.schuermann.asciipaint;

import org.schuermann.asciipaint.shape.*;

public class ASCIIModel extends ASCIIComplexShape {

    private ASCIIShape constituting = null;
    private ASCIIShape selected = null;

    public ASCIIModel() {
        super(0,0);
   }

    public void addRect(ASCIIRect rect) {
        add(rect);
   }

    public void addLine(ASCIILine line) {
        add(line);
   }

    public void addString(ASCIIString text) {
        add(text);
    }


    public ASCIIShape find(int x, int y) {
        ASCIIShape foundShape = null;
        for (ASCIIShape shape: shapes) {
            boolean hit = shape.checkHit(x, y);
            if (hit)
                foundShape = shape;
        }
        return foundShape;
    }

    public void findAndSelect(int x, int y) {
        ASCIIShape foundShape = null;
        for (ASCIIShape shape: shapes) {
            shape.unselect();
            boolean hit = shape.checkHit(x, y);
            if (hit)
                foundShape = shape;
        }
        if (foundShape!=null) {
            foundShape.select();
            selected = foundShape;
        }
    }

    public void deselect() {
        for (ASCIIShape shape: shapes) {
            shape.unselect();
        }
        selected = null;
    }

    public void paint(ASCIICanvas canvas) {
        super.paint(canvas);
        if (constituting!=null)
            constituting.paint(canvas);
    }

    public void setConstituting(ASCIIShape aShape) {
        this.constituting = aShape;
    }

    public ASCIIShape getConstituting() {
        return this.constituting;
    }

    public void resetConstituting(){
        this.constituting=null;
    }

    public ASCIIShape getSelected() {
        return selected;
    }

}
