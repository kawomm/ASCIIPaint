package org.schuermann.asciipaint.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ASCIICommands {

    static public ASCIICommands asciiCommands  = new ASCIICommands();

    ArrayList<CommandInfo> commands = null;

    public class CommandInfo {

        private Class clazz;
        private String commandCharacter;

        CommandInfo( String commandCharacter, Class clazz) {
            this.clazz = clazz;
            this.commandCharacter = commandCharacter;
        }

        public Class getClazz() {
            return clazz;
        }

        public String getCommandCharacter() {
            return commandCharacter;
        }
    }


    public ASCIICommands() {
        commands = new ArrayList<>();
        commands.add(new CommandInfo("q", ASCIIQuitCommand.class));
        commands.add(new CommandInfo("r", ASCIIRectCommand.class));
        commands.add(new CommandInfo("l", ASCIILineCommand.class));
        commands.add(new CommandInfo("t", ASCIITextCommand.class));
        commands.add(new CommandInfo("c", ASCIIChangeColorCommand.class));
        commands.add(new CommandInfo("s", ASCIISelectCommand.class));
        commands.add(new CommandInfo("u", ASCIIUnselectCommand.class));
        commands.add(new CommandInfo("m", ASCIIMoveCommand.class));
        commands.add(new CommandInfo("h", ASCIIHelpCommand.class));
        commands.add(new CommandInfo("a", ASCIIChangeLineEndCommand.class));
        commands.add(new CommandInfo("e", ASCIIExtensionsCommand.class));
    }



    public ArrayList<CommandInfo> getCommands() {
        return commands;
    }

}
