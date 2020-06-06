package org.schuermann.asciipaint;


import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class ASCIIEvent {

    private Terminal terminal =null;
    private ASCIIModel model = null;

    private ArrayList<ASCIIKeyEventListener> keyEventListeners = null;

    public ASCIIEvent(Terminal terminal, ASCIIModel model) {
        this.terminal=terminal;
        this.model = model;

        this.keyEventListeners = new ArrayList<>();
    }

    public void addKeyEventListener(ASCIIKeyEventListener listener) {
        keyEventListeners.add(listener);
    }

    private void signalKeyEventListener(ASCIIKeyEvent event){
        for (ASCIIKeyEventListener listener: keyEventListeners)
            listener.listen(event);
    }

    public void handle() throws IOException {
        KeyStroke keyStroke = terminal.readInput();  // non-blocking polInput();
        if (keyStroke!=null) {
            KeyType keyType = keyStroke.getKeyType();

            if (keyType.equals(KeyType.ArrowRight)) {
                TerminalPosition cursor = terminal.getCursorPosition();
                int x= cursor.getColumn();
                int y = cursor.getRow();
                terminal.setCursorPosition(x+1,y);
            }
            if (keyType.equals(KeyType.ArrowLeft)) {
                TerminalPosition cursor = terminal.getCursorPosition();
                int x= cursor.getColumn();
                int y = cursor.getRow();
                terminal.setCursorPosition(x-1,y);
            }
            if (keyType.equals(KeyType.ArrowUp)) {
                TerminalPosition cursor = terminal.getCursorPosition();
                int x= cursor.getColumn();
                int y = cursor.getRow();
                terminal.setCursorPosition(x,y-1);
            }
            if (keyType.equals(KeyType.ArrowDown)) {
                TerminalPosition cursor = terminal.getCursorPosition();
                int x= cursor.getColumn();
                int y = cursor.getRow();
                terminal.setCursorPosition(x,y+1);
            }

            //individual command handling
            signalKeyEventListener(new ASCIIKeyEvent(keyStroke));
        }
    }

}
