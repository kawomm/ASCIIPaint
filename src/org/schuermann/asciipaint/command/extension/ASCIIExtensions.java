package org.schuermann.asciipaint.command.extension;

import org.schuermann.asciipaint.command.*;

import java.util.ArrayList;

public class ASCIIExtensions {

    static public ASCIIExtensions asciiCExtensions = new ASCIIExtensions();

    ArrayList<ExstensionInfo> extensions = null;

    public class ExstensionInfo {

        private Class clazz;
        private String extensionCharacter;

        ExstensionInfo( String commandCharacter, Class clazz) {
            this.clazz = clazz;
            this.extensionCharacter = commandCharacter;
        }

        public Class getClazz() {
            return clazz;
        }

        public String getExtensionCharacter() {
            return extensionCharacter;
        }
    }


    public ASCIIExtensions() {
        extensions = new ArrayList<>();
        extensions.add(new ExstensionInfo("1", ASCIIUMLExtension.class));

    }


    public ArrayList<ExstensionInfo> getExtensions() {
        return extensions;
    }

}
