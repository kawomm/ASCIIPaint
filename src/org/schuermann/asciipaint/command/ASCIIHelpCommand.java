package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;


public class ASCIIHelpCommand extends ASCIICommand {

    private TerminalPosition termPos = null;

    public ASCIIHelpCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);

    }

    public String getStatusText() {
        return "move over the shape, press s to select";
    }

    public String getHelpText() { return "shows this help page"; }

    public boolean execute() {

        try {
            termPos = app.getCanvas().getTerminal().getCursorPosition();
            app.getCanvas().getTerminal().setCursorVisible(true);
            app.getCanvas().getTerminal().clearScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        app.getCanvas().putString(2,2, "Help");

        int row = 4;

        for (ASCIICommands.CommandInfo commandInfo: ASCIICommands.asciiCommands.getCommands() ){
            try {
                ASCIICommand command = (ASCIICommand)commandInfo.getClazz().getDeclaredConstructor(ASCIIApp.class, String.class).newInstance((ASCIIApp)null,commandInfo.getCommandCharacter());
                String helpText = command.commandCharacter+" - "+command.getHelpText();
                app.getCanvas().putString(2,row, helpText);
                row++;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    @Override
    public boolean handle(ASCIIKeyEvent event) {
        app.getCanvas().invalidate();
        try {
            app.getCanvas().getTerminal().setCursorVisible(true);
            app.getCanvas().getTerminal().setCursorPosition(termPos.getColumn(), termPos.getRow());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
