package com.wordcount.io;

import com.wordcount.domain.UI;

public class UIFactory {

    public static UI construct(String[] consoleParameter) {
        if (consoleParameter.length == 1) {
            return new UIImpl(new ConsoleUI(), new FileInputUI(consoleParameter[0]));
        }
        return new ConsoleUI();
    }
}
