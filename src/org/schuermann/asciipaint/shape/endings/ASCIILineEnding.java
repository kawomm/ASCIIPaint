package org.schuermann.asciipaint.shape.endings;

import org.schuermann.asciipaint.ASCIICanvas;

public interface ASCIILineEnding {

    public abstract void paint(ASCIICanvas canvas, int x, int y, int ending_direction);
}
