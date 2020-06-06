package org.schuermann.asciipaint.shape;

import org.schuermann.asciipaint.shape.ASCIIAbstractShape;
import org.schuermann.asciipaint.shape.endings.ASCIILineEnding;
import org.schuermann.asciipaint.shape.endings.AbstractLineEnding;

public abstract class ASCIILine extends ASCIIAbstractShape {


    public static final int NOARROW = 0;
    public static final int FROMARROW = 1;
    public static final int TOARROW = 2;
    public static final int FROMANDTOARROW = 3;

    protected ASCIILineEnding fromEnding = AbstractLineEnding.NO_ENDING;
    protected ASCIILineEnding toEnding = AbstractLineEnding.NO_ENDING;

    int l = 0;

    public ASCIILine(int x, int y, int l) {
        super(x,y);
        this.l=l;
    }

    public void nextFromEnding() {
        fromEnding = AbstractLineEnding.next(fromEnding);
    }

    public void nextToEnding() {
        toEnding = AbstractLineEnding.next(toEnding);
    }


    public ASCIILineEnding getNearestEnding(int x, int y){
        return fromEnding;
    }


}
