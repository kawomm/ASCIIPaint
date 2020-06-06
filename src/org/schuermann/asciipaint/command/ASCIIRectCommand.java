package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;
import org.schuermann.asciipaint.shape.ASCIIRect;
import org.schuermann.asciipaint.shape.extensions.uml.ASCIIUMLClass;

import java.io.IOException;

public class ASCIIRectCommand extends ASCIICommand  {


    public ASCIIRectCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);

    }

    public String getStatusText() {
        return "Press r again to define opposite corner.";
    }

    public String getHelpText() { return "Draws a Rect, move to the opposite corner and press 'r' again"; }

    @Override
    public boolean handle(ASCIIKeyEvent event) {

        int x2=x1;
        int y2=x1;

        try {
            TerminalPosition tp2 = app.getCanvas().getTerminal().getCursorPosition();

            x2 = tp2.getColumn();
            y2 = tp2.getRow();
            app.getModel().setConstituting(new ASCIIRect(x1, y1, x2 - x1 + 1, y2 - y1 + 1));
            app.getCanvas().invalidate();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!event.getKeyType().equals(KeyType.Character))
            return false;

        app.getModel().resetConstituting();
        char key = event.getKey();

        if (key == 'r') {
            app.getModel().addRect(new ASCIIRect(x1, y1, x2 - x1 + 1, y2 - y1 + 1));
            app.getModel().add(new ASCIIUMLClass(x1+20, y1+5));
        }
        return super.handle(event);
    }
}
