package org.schuermann.asciipaint.shape.endings;

import org.schuermann.asciipaint.ASCIICanvas;
import org.schuermann.asciipaint.shape.ASCIILine;

import java.util.ArrayList;

public abstract class AbstractLineEnding implements ASCIILineEnding{

    public static final int RIGHT_END_OF_LINE = 0;
    public static final int TOP_END_OF_LINE = 1;
    public static final int LEFT_END_OF_LINE = 2;
    public static final int BOTTOM_END_OF_LINE = 3;


    public static final AbstractLineEnding NO_ENDING = new NoEnding();
    public static final AbstractLineEnding ARROW_ENDING = new ArrowEnding();
    public static final AbstractLineEnding INTERFACE_ENDING = new InterfaceEnding();
    public static final AbstractLineEnding DEADEND_ENDING = new DeadEndEnding();

    public static ArrayList<AbstractLineEnding> abstractLineEndingsList = null;

    public static ASCIILineEnding next(ASCIILineEnding current) {
        int index = abstractLineEndingsList.indexOf(current);
        index++;
        if (index>abstractLineEndingsList.size()-1)
            index = 0;
        return abstractLineEndingsList.get(index);
    }

    static {
        abstractLineEndingsList = new ArrayList<>();
        abstractLineEndingsList.add(NO_ENDING);
        abstractLineEndingsList.add(ARROW_ENDING);
        abstractLineEndingsList.add(INTERFACE_ENDING);
        abstractLineEndingsList.add(DEADEND_ENDING);
    }



}
