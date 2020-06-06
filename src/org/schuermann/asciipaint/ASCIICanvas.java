package org.schuermann.asciipaint;


import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class ASCIICanvas {

    private final static char HORIZONTAL = '-';
    private final static char VERTICAL = '|';
    private final static char XING = '+';

    private ASCIIModel model = null;
    private Terminal terminal = null;
    private char[][] info = null;
    private boolean valid = false;
    private String statusLine = "";
    private final static String STATUSLINE_DEFAULT = "ASCII Paint v0.2.1 - press h for help";

    public ASCIICanvas(Terminal terminal, ASCIIModel model) {
        this.terminal =  terminal;
        this.info = new char[2000][2000];
        this.model = model;
        statusLine = STATUSLINE_DEFAULT;
    }

    public void invalidate() {
        valid = false;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void drawHorizontalLine(int x1, int x2, int y) {
        TerminalPosition cursor = null;
        try {
            cursor = terminal.getCursorPosition();

            for (int i=0; i<x2-x1 ;i++) {
                moveTo(x1+i,y);
                if (info[x1+i][y] == VERTICAL || info[x1+i][y] == XING) {
                    put(XING);
                    info[x1+i][y] = XING;
                }
                else {
                    put(HORIZONTAL);
                    info[x1+i][y] = HORIZONTAL;
                }
            }
            terminal.setCursorPosition(cursor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawVerticallLine(int y1, int y2, int x) {
        TerminalPosition cursor = null;
        try {
            cursor = terminal.getCursorPosition();
            for (int i=0; i<y2-y1 ;i++) {
                moveTo(x, y1 + i);
                if (info[x][y1+i] == HORIZONTAL || info[x][y1+i] == XING) {
                    put(XING);
                    info[x][y1 + i] = XING;
                }
                else {
                    put(VERTICAL);
                    info[x][y1 + i] = VERTICAL;
                }


            }
            terminal.setCursorPosition(cursor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void putString(int x, int y, String s) {
        TerminalPosition cursor = null;
        try {
            cursor = terminal.getCursorPosition();
            moveTo(x,y);
            for (int i=0; i<s.length();i++)
                put(s.charAt(i));
            terminal.setCursorPosition(cursor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void moveTo(int x, int y) {
        try {
            terminal.setCursorPosition(x,y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void put(char c) {
        try {
            terminal.putCharacter(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSTatusLine(String text) {
        this.statusLine = text;
        invalidate();
    }

    public void resetStatusLine(){
        this.statusLine = STATUSLINE_DEFAULT;
        invalidate();
    }


    public void paint() {
        TerminalPosition cursor = null;

        try {
            cursor = terminal.getCursorPosition();
        } catch (IOException e) {
        }
        if (!valid) {
            this.info = new char[2000][2000];
            try {
                cursor = terminal.getCursorPosition();
                terminal.clearScreen();
                model.paint(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            valid=true;
        }


        try {
            //display status line
            terminal.resetColorAndSGR();
            terminal.enableSGR(SGR.BOLD);
            terminal.setBackgroundColor(TextColor.ANSI.WHITE);
            terminal.setForegroundColor(TextColor.ANSI.BLACK);

            putString(0,0,statusLine+ " - ["+ cursor.getRow()+","+cursor.getColumn()+"]");

            terminal.resetColorAndSGR();

            terminal.setCursorPosition(cursor);

            terminal.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
