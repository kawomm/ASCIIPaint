package org.schuermann.asciipaint.command.extension;

import com.googlecode.lanterna.input.KeyType;
import org.schuermann.asciipaint.ASCIIKeyEvent;

public class ASCIIDefaultExtension implements ASCIIExtension {

    @Override
    public boolean execute() {
        return false;
    }

    public boolean handle(ASCIIKeyEvent event) {
        if (!event.getKeyType().equals(KeyType.Character))
            return false;
        char key = event.getKey();
        switch (key) {
            case '1':handle1();break;
            case '2':handle2();break;
            case '3':handle3();break;
            case '4':handle4();break;
            case '5':handle5();break;
            case '6':handle6();break;
            case '7':handle7();break;
            case '8':handle8();break;
            case '9':handle9();break;
            case '0':handle0();break;
        }
        return true;
    }
    public void handle1(){}
    public void handle2(){}
    public void handle3(){}
    public void handle4(){}
    public void handle5(){}
    public void handle6(){}
    public void handle7(){}
    public void handle8(){}
    public void handle9(){}
    public void handle0(){}
}
