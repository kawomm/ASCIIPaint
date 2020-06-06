package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;
import org.schuermann.asciipaint.shape.ASCIIString;

import java.io.IOException;


public class ASCIITextCommand extends ASCIICommand {

    private StringBuffer textString = null;

    public ASCIITextCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);
        textString = new StringBuffer();
    }

    public String getStatusText() {
        return "Please enter text and complete with [ENTER]";
    }


    public String getHelpText() { return "Type text and close with [ENTER]"; }


    @Override
    public boolean handle(ASCIIKeyEvent event) {

        KeyType keyType = event.getKeyType();

        if (keyType.equals(KeyType.Enter)) {
            app.getModel().resetConstituting();
            app.getModel().addString(new ASCIIString(x1, y1, textString.toString()));
            textString = new StringBuffer();
            return super.handle(event);
        } else if (keyType.equals(KeyType.Backspace)) {
            textString = textString.deleteCharAt(textString.length() - 1);
            app.getModel().setConstituting(new ASCIIString(x1, y1, textString.toString()));

            //and move the cursor one back
            try {
                TerminalPosition termPos = app.getCanvas().getTerminal().getCursorPosition();
                app.getCanvas().getTerminal().setCursorPosition(termPos.getColumn()-1, termPos.getRow());
            } catch (IOException e) {
                e.printStackTrace();
            }

            app.getCanvas().invalidate();
            return false;
        } else if (keyType.equals(KeyType.Character)) {
            textString.append(event.getKey());
            app.getModel().setConstituting(new ASCIIString(x1, y1, textString.toString()));
            app.getCanvas().invalidate();

            //move the cursor one to the front
            try {
                TerminalPosition termPos = app.getCanvas().getTerminal().getCursorPosition();
                app.getCanvas().getTerminal().setCursorPosition(termPos.getColumn()+1, termPos.getRow());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        } else
            return false;
    }
}
