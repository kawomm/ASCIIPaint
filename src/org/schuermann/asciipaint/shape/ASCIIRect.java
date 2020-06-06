package org.schuermann.asciipaint.shape;

import org.schuermann.asciipaint.ASCIICanvas;
import org.schuermann.asciipaint.shape.ASCIIAbstractShape;

public class ASCIIRect extends ASCIIAbstractShape {

    int w = 0;
    int h = 0;

    public ASCIIRect(int x, int y, int w, int h) {
        super(x,y);

        this.w=w;
        this.h=h;

        if (this.w<0) {
            this.x=this.x+this.w-1;
            this.w = -this.w+2;
        }
        if (this.h<0) {
            this.y=this.y+this.h-1;
            this.h = -this.h+2;
        }
    }

    public void paint(ASCIICanvas canvas) {
        super.paint(canvas);

        canvas.drawHorizontalLine(x,x+w,y);
        canvas.drawHorizontalLine(x,x+w,y+h-1);
        canvas.drawVerticallLine(y,y+h,x);
        canvas.drawVerticallLine(y,y+h,x+w-1);
/*
        if (selected)
            canvas.putString(x,y,"S");

 */
    }

    public boolean checkHit(int x, int y) {
       if ( (x==this.x && y>=this.y && y<this.y+h) ||
               (x==this.x+w-1 && y>=this.y && y<this.y+h) ||
               (y==this.y && x>=this.x && x<this.x+w) ||
               (y==this.y+h-1 && x>=this.x && x<this.x+w) )
           return true;
       else
           return false;
    }
}
