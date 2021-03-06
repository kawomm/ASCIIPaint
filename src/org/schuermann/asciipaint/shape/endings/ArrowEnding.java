package org.schuermann.asciipaint.shape.endings;

import org.schuermann.asciipaint.ASCIICanvas;

public class ArrowEnding extends AbstractLineEnding {

    char[]ending ={'>', '^', '<', 'v'};

    @Override
    public void paint(ASCIICanvas canvas, int x, int y, int ending_direction) {
        canvas.putString(x,y ,  String.valueOf(ending[ending_direction]));
    }
}
