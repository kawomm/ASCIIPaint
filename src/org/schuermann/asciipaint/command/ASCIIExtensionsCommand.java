package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TerminalPosition;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;
import org.schuermann.asciipaint.command.extension.ASCIIExtension;
import org.schuermann.asciipaint.command.extension.ASCIIExtensions;
import org.schuermann.asciipaint.command.extension.ASCIIUMLExtension;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class ASCIIExtensionsCommand extends ASCIICommand {

    private TerminalPosition termPos = null;

    public ASCIIExtensionsCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);

    }

    public String getStatusText() {
        return "press 1 for UML Extension, any other key to exit";
    }

    public String getHelpText() { return "Defines the extensionspack on keys [0-9]"+" - "+"no extension selected"; }

    public boolean execute() {

        try {
            termPos = app.getCanvas().getTerminal().getCursorPosition();
            app.getCanvas().getTerminal().setCursorVisible(true);
            app.getCanvas().getTerminal().clearScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
        app.getCanvas().putString(2,2, "Extensions");

        int row = 4;

        for (ASCIIExtensions.ExstensionInfo extensionInfo: ASCIIExtensions.asciiCExtensions.getExtensions() ){
            try {
                ASCIIExtension extension = (ASCIIExtension)extensionInfo.getClazz().getDeclaredConstructor(ASCIIApp.class, String.class).newInstance((ASCIIApp)null,extensionInfo.getExtensionCharacter());
                String helpText = extension.commandCharacter+" - "+command.getHelpText();
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
