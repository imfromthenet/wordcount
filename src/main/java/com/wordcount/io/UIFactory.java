package com.wordcount.io;

import com.wordcount.domain.UI;

public class UIFactory {

    public static UI construct(String[] consoleParameters) {
        if (consoleParameters.length == 1) {
            return new UIImpl(new ConsoleUI(), new FileInputUI(consoleParameters[0]));
        }
        return new ConsoleUI();
    }
}
