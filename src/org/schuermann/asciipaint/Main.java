package org.schuermann.asciipaint;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.TextInputDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {

    static Terminal terminal = null;

    public static void main(String[] args) throws IOException {
        // Setup terminal and screen layers
        // Setup terminal and screen layers
        ASCIIPaint paint  = new ASCIIPaint();
        paint.run();
    }
}
