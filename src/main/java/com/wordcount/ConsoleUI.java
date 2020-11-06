package com.wordcount;

import java.util.Objects;

public class ConsoleUI implements UIable {

    @Override
    public void displayMessage(final String message) {
        Objects.requireNonNull(message);

        System.out.print(message);
    }
}
