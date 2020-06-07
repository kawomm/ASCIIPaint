package org.schuermann.asciipaint.command.extension;

import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;

public class ASCIIUMLExtension extends ASCIIDefaultExtension {

    public ASCIIUMLExtension(ASCIIApp anApp, String aCommandCharacter){
        super(anApp, aCommandCharacter);
    }

    public  String getHelpText() {
        return "Helps you to draw UML diagrams quickly.";
    }

    @Override
    public void handle1() {
        super.handle1();
    }
}
