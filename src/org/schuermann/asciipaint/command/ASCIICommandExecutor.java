package org.schuermann.asciipaint.command;

import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;

public interface ASCIICommandExecutor {

    public boolean execute();
    public boolean handle(ASCIIKeyEvent event);

    public String getCommandCharacter();
    public  String getHelpText();

}
