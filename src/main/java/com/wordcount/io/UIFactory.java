package com.wordcount.io;

import com.wordcount.io.console.ConsoleReader;
import com.wordcount.io.console.ConsoleUI;
import com.wordcount.io.console.ConsoleWriter;
import com.wordcount.io.file.FileUI;

public class UIFactory {

    public UI getFactory(final String[] consoleParameter) {
        if (consoleParameter.length == 1) {
            return new FileUI(consoleParameter[0]);
        } else {
            return new ConsoleUI(new ConsoleWriter(), new ConsoleReader());
        }
    }
}
