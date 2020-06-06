package org.schuermann.asciipaint.command;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.ASCIIApp;
import org.schuermann.asciipaint.ASCIIKeyEvent;
import org.schuermann.asciipaint.shape.ASCIIShape;

import java.io.IOException;


public class ASCIIMoveCommand extends ASCIICommand {


    public ASCIIMoveCommand(ASCIIApp app, String commandCharacter) {
        super(app, commandCharacter);
    }

    public String getStatusText() {
        if (app.getModel().getSelected()!=null)
            return "move selecte shape, [space] to stop moving";
        else
            return "move all objects on canvas, [space] to stop moving;";
    }


    public String getHelpText() { return "moves selected object or if nothing selected all elements"; }


    public boolean execute() {
        return super.execute();
    }


    @Override
    public boolean handle(ASCIIKeyEvent event) {

        ASCIIShape toMove= null;

        if (app.getModel().getSelected()!=null)
            toMove = app.getModel().getSelected();
        else
            toMove = app.getModel();

        if (event.getKeyType().equals(KeyType.Character) && event.getKey()== ' ') {
            return super.handle(event);
        }
        else if (event.getKeyType().equals(KeyType.ArrowRight)) {
            toMove.moveRight();
            app.getCanvas().invalidate();
        }
        else if (event.getKeyType().equals(KeyType.ArrowLeft)) {
            toMove.moveLeft();
            app.getCanvas().invalidate();
        }
        else  if (event.getKeyType().equals(KeyType.ArrowUp)) {
            toMove.moveUp();
            app.getCanvas().invalidate();
        }
        else if (event.getKeyType().equals(KeyType.ArrowDown)) {
            toMove.moveDown();
            app.getCanvas().invalidate();
        }
        return false;
    }

}
