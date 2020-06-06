package org.schuermann.asciipaint.shape;

import org.schuermann.asciipaint.ASCIICanvas;
import org.schuermann.asciipaint.shape.ASCIILine;
import org.schuermann.asciipaint.shape.endings.AbstractLineEnding;

public class ASCIIVerticalLine extends ASCIILine {

    public ASCIIVerticalLine(int x, int y, int l) {
        super(x,y,l);

        if (l<0) {
            this.y = y + l-1;
            this.l =2-l;
        }
    }

    public void paint(ASCIICanvas canvas) {
        super.paint(canvas);
        canvas.drawVerticallLine(y,y+l,x);

        fromEnding.paint(canvas,x,y, AbstractLineEnding.TOP_END_OF_LINE);
        toEnding.paint(canvas,x,y+l-1, AbstractLineEnding.BOTTOM_END_OF_LINE);
        /*
        if (selected)
            canvas.putString(x,y,"S");

         */
    }

    public boolean checkHit(int x, int y) {
        if (x==this.x && y>=this.y && y<this.y+l)
            return true;
        else
            return false;
    }
}
