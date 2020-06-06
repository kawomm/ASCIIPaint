package org.schuermann.asciipaint;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.command.*;
import org.schuermann.asciipaint.shape.ASCIIString;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;

public class ASCIIPaint extends ASCIIApp implements ASCIIKeyEventListener{

    ASCIICommand runningCommand = null;

    HashMap<String, ASCIICommand> commands = null;

    TerminalPosition terminalPosition1 = null;
    TerminalPosition terminalPosition2 = null;

    public ASCIIPaint() throws IOException {
        super();
        event.addKeyEventListener(this);

        commands = new HashMap<>();

        for (ASCIICommands.CommandInfo commandInfo: ASCIICommands.asciiCommands.getCommands() ){
           try {
                ASCIICommand command = (ASCIICommand)commandInfo.getClazz().getDeclaredConstructor(ASCIIApp.class, String.class).newInstance(this, commandInfo.getCommandCharacter());
                commands.put(command.getCommandCharacter(), command);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

/*
        commands.put("q", new ASCIIQuitCommand(this));
        commands.put("r", new ASCIIRectCommand(this));
        commands.put("l", new ASCIILineCommand(this));
        commands.put("t", new ASCIITextCommand(this));
        commands.put("c", new ASCIIChangeColorCommand(this));
        commands.put("s", new ASCIISelectCommand(this));
        commands.put("u", new ASCIIUnselectCommand(this));
        commands.put("m", new ASCIIMoveCommand(this));
        commands.put("h", new ASCIIHelpCommand(this));

 */
    }

    private void handleKeyEventQuit(char key) {
        if (key=='q') {
            try {
                terminal.close();
                stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void listen(ASCIIKeyEvent event) {

        if (runningCommand==null){
            if (!event.getKeyType().equals(KeyType.Character))
                return;
            runningCommand = commands.get(Character.toString(event.getKey()));
            if (runningCommand!=null)
                if (runningCommand.execute() == true) {
                    runningCommand=null;
                }
        } else {
            if (runningCommand.handle(event) == true)
                runningCommand = null;
        }
    }
}
