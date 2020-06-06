package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;

import java.io.IOException;


public class ASCIIUnselectCommand extends ASCIICommand {


    public ASCIIUnselectCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);
    }

    public String getStatusText() {
        return "unselect";
    }

    public String getHelpText() { return "unselects all"; }


    public boolean execute() {
        app.getModel().deselect();
        app.getCanvas().invalidate();
        return true;
    }
}
