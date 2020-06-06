package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;

import java.io.IOException;

public abstract class ASCIICommand implements ASCIICommandExecutor{

    protected ASCIIApp app = null;
    protected String commandCharacter = null;

    protected abstract String getStatusText();
    public  String getHelpText() {
        return "no help information defined.";
    }

    public boolean handle(ASCIIKeyEvent event) {
        app.getCanvas().resetStatusLine();
        app.getCanvas().invalidate();
        return true;
    }

    protected int x1;
    protected int y1;

    public ASCIICommand(ASCIIApp anApp, String aCommandCharacter){
        this.app=anApp;
        this.commandCharacter=aCommandCharacter;
    }

    public String getCommandCharacter() {
        return this.commandCharacter;
    }
    public boolean execute() {
        TerminalPosition tp1 = null;
        try {
            tp1 = app.getCanvas().getTerminal().getCursorPosition();
            x1 = tp1.getColumn();
            y1 = tp1.getRow();
            app.getCanvas().setSTatusLine(getStatusText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
