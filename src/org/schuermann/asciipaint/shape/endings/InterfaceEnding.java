package org.schuermann.asciipaint.shape.endings;

import org.schuermann.asciipaint.ASCIICanvas;

public class InterfaceEnding extends AbstractLineEnding {

    char[]ending ={'o', 'o', 'o', 'o'};

    @Override
    public void paint(ASCIICanvas canvas, int x, int y, int ending_direction) {
        canvas.putString(x,y ,  String.valueOf(ending[ending_direction]));
    }
}