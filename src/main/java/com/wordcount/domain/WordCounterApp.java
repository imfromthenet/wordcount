package com.wordcount.domain;

import com.wordcount.domain.handlers.ChainOfHandlers;

import java.util.List;
import java.util.Objects;

public class WordCounterApp {

    private UI ui;
    private StopWords stopWords;
    private ChainOfHandlers chainOfHandlers;

    public WordCounterApp(UI ui, StopWords stopWords, ChainOfHandlers chainOfHandlers) {
        Objects.requireNonNull(this.ui = ui);
        Objects.requireNonNull(this.stopWords = stopWords);
        Objects.requireNonNull(this.chainOfHandlers = chainOfHandlers);
    }

    public void countWords() {
        String userInput = ui.getUserInput();
        WordParser parser = new WordParser(stopWords);
        List<String> wordsFiltered = parser.parse(userInput);
        ui.show(chainOfHandlers.handle(wordsFiltered));
    }
}
