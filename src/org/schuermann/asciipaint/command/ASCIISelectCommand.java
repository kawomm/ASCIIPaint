package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;
import org.schuermann.asciipaint.shape.ASCIIShape;

import java.io.IOException;


public class ASCIISelectCommand extends ASCIICommand {


    public ASCIISelectCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);
    }

    public String getStatusText() {
        return "move over the shape, press s to select";
    }

    public String getHelpText() { return "select an object by moving on it and press 's' again"; }


    public boolean execute() {

        TerminalPosition tp = null;
        try {
            tp = app.getCanvas().getTerminal().getCursorPosition();
            int x = tp.getColumn();
            int y = tp.getRow();
            app.getModel().findAndSelect(x, y);
            app.getCanvas().invalidate();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.execute();
    }


    @Override
    public boolean handle(ASCIIKeyEvent event) {

        if (event.getKeyType().equals(KeyType.Character) && event.getKey()== 's') {
            return super.handle(event);
        } else {
            TerminalPosition tp = null;
            try {
                tp = app.getCanvas().getTerminal().getCursorPosition();
                int x = tp.getColumn();
                int y = tp.getRow();
                app.getModel().findAndSelect(x, y);
                app.getCanvas().invalidate();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

    }

}
