package org.schuermann.asciipaint.shape;

import org.schuermann.asciipaint.ASCIICanvas;
import org.schuermann.asciipaint.shape.endings.AbstractLineEnding;

public class ASCIIHorizontalLine extends ASCIILine {

    public ASCIIHorizontalLine(int x, int y, int l) {
        super(x,y,l);

        if (l<0) {
            this.x = x + l-1;
            this.l =2-l;
        }
    }

    public void paint(ASCIICanvas canvas) {
        super.paint(canvas);
        canvas.drawHorizontalLine(x,x+l,y);


        fromEnding.paint(canvas,x,y, AbstractLineEnding.LEFT_END_OF_LINE);
        toEnding.paint(canvas,x+l-1,y, AbstractLineEnding.RIGHT_END_OF_LINE);
/*

        if (selected)
            canvas.putString(x,y,"S");

 */
    }

    public boolean checkHit(int x, int y) {
        if (y==this.y && x>=this.x && x<this.x+l)
            return true;
        else
            return false;
    }
}
