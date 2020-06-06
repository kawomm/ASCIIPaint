package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;

import java.io.IOException;

public class ASCIIQuitCommand extends ASCIICommand {

    public ASCIIQuitCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);
    }

    protected String getStatusText() {
        return "Press q again to quit.";
    }


    public String getHelpText() { return "Quits the application (with 2nd press of 'q')"; }


    public boolean handle(ASCIIKeyEvent event) {
        if (!event.getKeyType().equals(KeyType.Character))
            return false;
        if (event.getKey()=='q') {
            try {
                app.getCanvas().getTerminal().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            app.stop();
        }
        return super.handle(event);
    }
}
