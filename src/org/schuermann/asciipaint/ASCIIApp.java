package org.schuermann.asciipaint;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.virtual.DefaultVirtualTerminal;

import java.io.IOException;

public class ASCIIApp {


    protected ASCIIModel model;
    protected ASCIIEvent event;
    protected ASCIICanvas canvas;

    protected Terminal terminal;

    private boolean stop;


    public ASCIIApp() throws IOException {

        terminal = new DefaultTerminalFactory().createTerminal();

        model = new ASCIIModel();
        canvas = new ASCIICanvas(terminal, model);
        event = new ASCIIEvent(terminal, model);

        stop = false;
    }

    public ASCIICanvas getCanvas() {
        return canvas;
    }

    public ASCIIModel getModel() {
        return model;
    }

    public void stop() {
        stop=true;
    }

    public void run() {
        while (!stop) {
            try {
                canvas.paint();
                event.handle();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
