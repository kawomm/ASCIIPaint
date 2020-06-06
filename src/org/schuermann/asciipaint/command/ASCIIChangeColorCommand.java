package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;
import org.schuermann.asciipaint.shape.ASCIIShape;
import org.schuermann.asciipaint.shape.ASCIIString;


public class ASCIIChangeColorCommand extends ASCIICommand {

    private int colorIndex = 0;

    private TextColor[] colors = {
            TextColor.ANSI.WHITE,
            TextColor.ANSI.RED,
            TextColor.ANSI.BLUE,
            TextColor.ANSI.MAGENTA,
            TextColor.ANSI.GREEN,
            TextColor.ANSI.YELLOW,
            TextColor.ANSI.CYAN,
            TextColor.ANSI.BLACK};


    public ASCIIChangeColorCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);
    }

    public String getStatusText() {
        return "Change color with [c] and stop with any other key";
    }

    public String getHelpText() { return "changes the color of the currently selected element"; }

    public boolean execute() {

        if (app.getModel().getSelected()==null)
            return true;
        else
            return super.execute();
    }


        @Override
    public boolean handle(ASCIIKeyEvent event) {

        if (event.getKeyType().equals(KeyType.Character) && event.getKey()== 'c') {
            colorIndex++;
            if (colorIndex>colors.length-1)
                colorIndex=0;
            app.getModel().getSelected().setColor(colors[colorIndex]);
            app.getCanvas().invalidate();
            return false;
        }
        else {
            return super.handle(event);
        }
    }
}
