package com.wordcount.io;

import static java.util.Objects.requireNonNull;

public class ConsoleWriter implements Writer {

    @Override
    public void write(final String text) {
        requireNonNull(text);

        System.out.print(text);
    }
}
