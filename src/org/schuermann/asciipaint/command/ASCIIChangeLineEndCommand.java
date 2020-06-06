package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;
import org.schuermann.asciipaint.shape.ASCIILine;
import org.schuermann.asciipaint.shape.ASCIIShape;
import org.schuermann.asciipaint.shape.endings.ASCIILineEnding;
import org.schuermann.asciipaint.shape.endings.AbstractLineEnding;

import java.io.IOException;


public class ASCIIChangeLineEndCommand extends ASCIICommand {

    private int[] lineendings = {
            ASCIILine.NOARROW,
            ASCIILine.FROMARROW,
            ASCIILine.TOARROW,
            ASCIILine.FROMANDTOARROW,
            };

    public ASCIIChangeLineEndCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);
    }

    public String getStatusText() {
        return "Change Line ending with [a] and stop with any other key";
    }

    public String getHelpText() { return "changes the line ending of the currently selected element"; }

    public boolean execute() {

        if (app.getModel().getSelected()==null) {
            TerminalPosition termPos = null;
            try {
                termPos = app.getCanvas().getTerminal().getCursorPosition();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int x = termPos.getColumn();
            int y = termPos.getRow();
            ASCIIShape current = app.getModel().find(x,y);
            if (current!= null && current instanceof ASCIILine) {
                ASCIILine line = (ASCIILine) current;
                ASCIILineEnding ending = line.getNearestEnding(x,y);
                ending = AbstractLineEnding.next(ending);
                app.getCanvas().invalidate();
            }
            return true;
        }
        else
            return super.execute();
    }


        @Override
    public boolean handle(ASCIIKeyEvent event) {
        if (event.getKeyType().equals(KeyType.Character) && event.getKey()== 'a') {

            ASCIIShape current = app.getModel().getSelected();
            if (current!= null && current instanceof ASCIILine) {
                ASCIILine line = (ASCIILine) current;
                //line.nextLineEnding();
                app.getCanvas().invalidate();
            }
            return false;
        }
        else {
            return super.handle(event);
        }
    }
}
