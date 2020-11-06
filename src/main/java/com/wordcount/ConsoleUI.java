package com.wordcount;

import java.io.PrintStream;
import java.util.Objects;

public class ConsoleUI implements UIable {

    private final PrintStream printStream;

    public ConsoleUI() {
        this.printStream = System.out;
    }

    @Override
    public void displayMessage(final String message) {
        Objects.requireNonNull(message);

        printStream.print(message);
    }
}
