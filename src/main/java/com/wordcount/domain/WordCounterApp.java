package com.wordcount.domain;

import com.wordcount.domain.handlers.ChainOfHandlers;

import java.util.List;

public class WordCounterApp {

    private UI ui;
    private StopWords stopWords;
    private ChainOfHandlers chainOfHandlers;

    public WordCounterApp(UI ui, StopWords stopWords, ChainOfHandlers chainOfHandlers) {
        this.ui = ui;
        this.stopWords = stopWords;
        this.chainOfHandlers = chainOfHandlers;
    }

    public void countWords() {
        String userInput = ui.getUserInput();
        WordParser parser = new WordParser(stopWords);
        List<String> wordsFiltered = parser.parse(userInput);
        ui.show(chainOfHandlers.handle(wordsFiltered));
    }
}
