package org.schuermann.asciipaint.shape;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;
import org.schuermann.asciipaint.ASCIICanvas;

public interface ASCIIShape {

    public void setColor(TextColor color);

    public void paint(ASCIICanvas canvas);
    public boolean checkHit(int x, int y);

    public void select();
    public void unselect();

    public void moveLeft();
    public void moveRight();
    public void moveDown();
    public void moveUp();
}
