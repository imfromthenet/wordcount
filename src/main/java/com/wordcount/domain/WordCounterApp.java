package com.wordcount.domain;

import com.wordcount.domain.handler.Handler;

import java.util.List;

public class WordCounterApp {

    private UI ui;
    private StopWords stopWords;
    private Handler handler;

    public WordCounterApp(UI ui, StopWords stopWords, Handler handler) {
        this.ui = ui;
        this.stopWords = stopWords;
        this.handler = handler;
    }

    public void countWords() {
        String userInput = ui.getInput();
        WordParser parser = new WordParser();
        List<String> wordsParsed = parser.parse(userInput);
        List<String> wordsFiltered = stopWords.filter(wordsParsed);
        ui.show(handler.handle(wordsFiltered));
    }


}
