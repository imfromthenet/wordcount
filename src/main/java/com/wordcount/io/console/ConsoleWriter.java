package com.wordcount.io.console;

import java.util.Objects;

public class ConsoleWriter implements Writer {

    @Override
    public void write(final String text) {
        Objects.requireNonNull(text);

        System.out.print(text);
    }
}
