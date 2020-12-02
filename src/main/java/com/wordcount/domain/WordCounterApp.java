package com.wordcount.domain;

import com.wordcount.domain.handlers.ChainOfHandlers;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class WordCounterApp {

    private UI ui;
    private StopWords stopWords;
    private ChainOfHandlers chainOfHandlers;

    public WordCounterApp(UI ui, StopWords stopWords, ChainOfHandlers chainOfHandlers) {
        requireNonNull(this.ui = ui);
        requireNonNull(this.stopWords = stopWords);
        requireNonNull(this.chainOfHandlers = chainOfHandlers);
    }

    public void countWords() {
        String userInput = ui.getUserInput();
        WordParser parser = new WordParser(stopWords);
        List<String> wordsFiltered = parser.parse(userInput);
        ui.show(chainOfHandlers.handle(wordsFiltered));
    }
}
