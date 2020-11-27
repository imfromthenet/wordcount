package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.ConsoleReader;
import com.wordcount.io.ConsoleWriter;
import com.wordcount.io.FileReader;

public class UIFactory {

    public static UI construct(String[] consoleParameter) {
        if (consoleParameter.length == 1) {
            return new ConsoleWriterFileReaderUI(new ConsoleWriter(), new FileReader(consoleParameter[0]));
        }
        return new ConsoleUI(new ConsoleWriter(), new ConsoleReader());
    }
}
