package com.wordcount;

import java.io.PrintStream;
import java.security.InvalidParameterException;

public class UserInteractor implements UserInteractable {

    private final PrintStream printStream;

    public UserInteractor(final PrintStream printStream) {
        if (printStream == null) {
            throw new InvalidParameterException();
        }
        this.printStream = printStream;
    }

    @Override
    public void displayMessage(final String message) {
        if (message == null) {
            throw new InvalidParameterException();
        }

        printStream.println(message);
    }
}
