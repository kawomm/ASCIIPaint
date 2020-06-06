package org.schuermann.asciipaint.shape;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import org.schuermann.asciipaint.ASCIICanvas;
import org.w3c.dom.Text;

import java.io.IOException;

public abstract class ASCIIAbstractShape implements ASCIIShape {


    protected int x;
    protected int y;

    TextColor foreground = null;

    boolean selected;

    public ASCIIAbstractShape (int x, int y) {
        this.selected = false;
        this.x = x;
        this.y = y;
        setColor(TextColor.ANSI.WHITE);
    }

    public void paint(ASCIICanvas canvas) {
        try {
            canvas.getTerminal().resetColorAndSGR();
            if (selected)
                canvas.getTerminal().enableSGR(SGR.BLINK);
            canvas.getTerminal().setBackgroundColor(TextColor.ANSI.BLACK);
            if (foreground!=null)
                canvas.getTerminal().setForegroundColor(foreground);
            else
                canvas.getTerminal().setForegroundColor(TextColor.ANSI.WHITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setColor(TextColor color) {
        foreground = color;
    }

    public boolean checkHit(int x, int y) {
        return false;
    }

    public void select() {
        this.selected = true;
    }

    public void unselect() {
        this.selected = false;
    }

    public void moveLeft() {
        x--;
        if (x<0)
            x=0;
    }
    public void moveRight() {
        x++;
    }
    public void moveDown(){
        y++;
    }
    public void moveUp() {
        y--;
        if (y<0)
            y=0;
    }
}
