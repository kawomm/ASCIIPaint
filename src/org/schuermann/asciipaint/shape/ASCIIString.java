package org.schuermann.asciipaint.shape;

import org.schuermann.asciipaint.ASCIICanvas;

public class ASCIIString extends ASCIIAbstractShape {

    String text;


    public ASCIIString(int x, int y, String text) {
        super(x,y);

        this.text = text;
    }


    public void paint(ASCIICanvas canvas) {
        super.paint(canvas);
        canvas.putString(x, y, text);
        /*
        if (selected)
            canvas.putString(x,y,"S");

         */
    }

    public boolean checkHit(int x, int y) {
        if (y==this.y && x>=this.x && x<this.x+text.length())
            return true;
        else
            return false;
    }

}
