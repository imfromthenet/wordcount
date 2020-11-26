package com.wordcount.io;

import java.util.Objects;

public class ConsoleWriter implements Writer {

    @Override
    public void write(final String text) {
        Objects.requireNonNull(text);

        System.out.print(text);
    }
}
