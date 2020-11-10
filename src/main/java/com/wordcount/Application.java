package com.wordcount;

import com.wordcount.io.UIable;
import com.wordcount.domain.WordCounter;

import java.util.Objects;

public class Application {
    public static final String MESSAGE_ENTER_TEXT = "Enter text: ";
    public static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    private final UIable ui;
    private final WordCounter wordCounter;

    public Application(final UIable ui, final WordCounter wordCounter) {
        this.ui = Objects.requireNonNull(ui);
        this.wordCounter = Objects.requireNonNull(wordCounter);
    }

    public void run() {
        ui.displayMessage(MESSAGE_ENTER_TEXT);
        String input = ui.getInput();
        int count = wordCounter.count(input);
        String response = String.format("%s%d", MESSAGE_NUMBER_OF_WORDS, count);
        ui.displayMessage(response);
    }

}
