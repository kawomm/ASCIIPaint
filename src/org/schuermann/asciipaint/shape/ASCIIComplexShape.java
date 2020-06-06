package org.schuermann.asciipaint.shape;

import org.schuermann.asciipaint.ASCIICanvas;

import java.util.ArrayList;

public class ASCIIComplexShape extends ASCIIAbstractShape {

    protected ArrayList<ASCIIShape> shapes = null;

    public ASCIIComplexShape(int x, int y) {
        super(x,y);
        shapes = new ArrayList<>();
    }


    public void moveLeft() {
        for (ASCIIShape shape: shapes)
            shape.moveLeft();
    }
    public void moveRight() {
        for (ASCIIShape shape: shapes)
            shape.moveRight();
    }
    public void moveDown(){
        for (ASCIIShape shape: shapes)
            shape.moveDown();
    }
    public void moveUp() {
        for (ASCIIShape shape: shapes)
            shape.moveUp();
    }

    private void paintAll(ASCIICanvas canvas){
        for (ASCIIShape shape: shapes)
            shape.paint(canvas);
    }

    public void paint(ASCIICanvas canvas) {
        super.paint(canvas);
        paintAll(canvas);
    }


    public boolean checkHit(int x, int y) {
        boolean hit = false;
        for (ASCIIShape shape: shapes) {
            hit = shape.checkHit(x, y);
            if (hit)
                break;
        }
        return hit;
    }

    public void add(ASCIIShape shape) {
        shapes.add(shape);
    }

}
