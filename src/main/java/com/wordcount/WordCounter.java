package com.wordcount;

import java.util.Objects;

public class WordCounter {
    public static final String MESSAGE_ENTER_TEXT = "Enter text: ";
    private final UIable ui;

    public WordCounter(final UIable ui) {
        Objects.requireNonNull(ui);
        this.ui = ui;
    }

    public void run() {
        ui.displayMessage(MESSAGE_ENTER_TEXT);
        String input = ui.getInput();
//        calculate(input);
    }

    public int calculate(String input) {
        return input.split(" ").length;
    }
}
