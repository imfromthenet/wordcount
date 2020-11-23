package com.wordcount.io.console;

import java.util.Objects;

public class ConsoleWriter implements Writer {

    private static ConsoleWriter instance;

    private ConsoleWriter() {}

    public static ConsoleWriter getInstance() {
        if (instance == null) {
            instance = new ConsoleWriter();
        }
        return instance;
    }

    @Override
    public void write(final String text) {
        Objects.requireNonNull(text);

        System.out.print(text);
    }
}
