package org.schuermann.asciipaint;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class ASCIIKeyEvent{

    private char key;
    private KeyType keyType;
    private KeyStroke keyStroke;

    public ASCIIKeyEvent(char key, KeyType keyType ) {
        this.key=key;
        this.keyType = keyType;
        this.keyStroke = null;
    }

    public ASCIIKeyEvent(KeyStroke keyStroke) {
        this.keyStroke = keyStroke;
    }

    public char getKey(){
        return keyStroke.getCharacter();
    }

    public KeyType getKeyType() {
        return keyStroke.getKeyType();
    }
}
