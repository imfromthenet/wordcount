package com.wordcount;

import com.wordcount.domain.Answer;
import com.wordcount.domain.WordCounter;
import com.wordcount.domain.Processor;
import com.wordcount.io.UIable;

import java.util.Objects;

public class Application {
    public static final String MESSAGE_ENTER_TEXT = "Enter text: ";
    private final UIable ui;
    private final Processor processor;
    private final WordCounter wordCounter;

    public Application(final UIable ui, final Processor processor, final WordCounter wordCounter) {
        this.ui = Objects.requireNonNull(ui);
        this.processor = Objects.requireNonNull(processor);
        this.wordCounter = Objects.requireNonNull(wordCounter);
    }

    public void run() {
        ui.displayMessage(MESSAGE_ENTER_TEXT);
        final String input = ui.getInput();
        processor.process(input);
        final Answer answer = wordCounter.getAnswer();
        ui.displayMessage(answer.toString());
    }

}
