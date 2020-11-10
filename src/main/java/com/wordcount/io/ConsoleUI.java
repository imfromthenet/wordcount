package com.wordcount.io;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements UIable {

    @Override
    public void displayMessage(final String message) {
        Objects.requireNonNull(message);

        System.out.print(message);
    }

    @Override
    public String getInput() {
        return new Scanner(System.in).nextLine();
    }
}
