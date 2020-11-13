package com.wordcount.domain;

import com.wordcount.io.file.IFileReader;
import com.wordcount.io.console.ConsoleUI;

import java.util.List;

public class InputPreparer {
    private final ConsoleUI consoleUI;
    private final IFileReader fileReader;

    public InputPreparer(final ConsoleUI consoleUI, final IFileReader reader) {
        this.consoleUI = consoleUI;
        this.fileReader = reader;
    }

    public String getInput(final String[] parameter) {
        String input;

        if (parameter.length == 1) {
            List<String> strings = fileReader.read(parameter[0]);
            input = String.join(" ", strings);
        } else {
            input = consoleUI.getInput();
        }

        return input;
    }
}
