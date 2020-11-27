package com.wordcount.domain;

import com.wordcount.io.ui.UI;

import java.util.List;

public class WordCounterApp {

    private final UI ui;
    private final StopWords stopWords;

    public WordCounterApp(final UI ui, final StopWords stopWords) {
        this.ui = ui;
        this.stopWords = stopWords;
    }

    public void countWords() {
        final String userInput = ui.getInput();
        final WordParser parser = new WordParser(stopWords);
        final List<String> wordsFiltered = parser.parse(userInput);
        final Statistics statistics = new Statistics(wordsFiltered);
        ui.write(statistics.getAsString());
    }
}
