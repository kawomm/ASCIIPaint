package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.*;
import org.schuermann.asciipaint.shape.ASCIIHorizontalLine;
import org.schuermann.asciipaint.shape.ASCIIVerticalLine;

import java.io.IOException;

public class ASCIILineCommand extends ASCIICommand {

    public ASCIILineCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);
    }

    public String getStatusText() {
        return "Move to endpoint and press h for an horizontal line and v for a vertical one.";
    }


    public String getHelpText() { return "Draws a horizontal or vertical line (press h or v for 2nd point"; }


    @Override
    public boolean handle(ASCIIKeyEvent event) {
        if (!event.getKeyType().equals(KeyType.Character))
            return false;
        char key = event.getKey();
        if (key=='h') {
            try {
                TerminalPosition tp2 = app.getCanvas().getTerminal().getCursorPosition();

                int x2 = tp2.getColumn();
                int y2 = tp2.getRow();

                app.getModel().addLine(new ASCIIHorizontalLine(x1,y1,x2-x1+1));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (key=='v') {
            try {
                TerminalPosition tp2 = app.getCanvas().getTerminal().getCursorPosition();

                int x2 = tp2.getColumn();
                int y2 = tp2.getRow();

                app.getModel().addLine(new ASCIIVerticalLine(x1,y1,y2-y1+1));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return super.handle(event);
    }
}
