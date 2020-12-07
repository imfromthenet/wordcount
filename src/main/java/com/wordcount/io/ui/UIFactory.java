package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.FileInputUI;

public class UIFactory {

    public static UI construct(String[] consoleParameter) {
        if (consoleParameter.length == 1) {
            return new ConsoleOutputFileInputUI(new ConsoleUI(), new FileInputUI(consoleParameter[0]));
        }
        return new ConsoleUI();
    }
}
