package com.wordcount;

import java.util.Objects;

public class Application {
    public static final String MESSAGE_ENTER_TEXT = "Enter text: ";
    public static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    private final UIable ui;

    public Application(final UIable ui) {
        Objects.requireNonNull(ui);
        this.ui = ui;
    }

    public void run() {
        ui.displayMessage(MESSAGE_ENTER_TEXT);
        String input = ui.getInput();
        String response = getResult(input);
        ui.displayMessage(response);
    }

    private String getResult(String input) {
        int count = calculate(input);
        return String.format("%s%d", MESSAGE_NUMBER_OF_WORDS, count);
    }

    public int calculate(String input) {
        return input.split(" ").length;
    }
}
