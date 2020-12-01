package com.wordcount.domain;

import java.util.Arrays;
import java.util.List;

public class WordCounterApp {

    private UI ui;
    private StopWords stopWords;
    private String[] args;

    public WordCounterApp(UI ui, StopWords stopWords, String[] args) {
        this.ui = ui;
        this.stopWords = stopWords;
        this.args = args;
    }

    public void countWords() {
        String userInput = ui.getUserInput();
        WordParser parser = new WordParser(stopWords);
        List<String> wordsFiltered = parser.parse(userInput);
        Statistics statistics = new Statistics(wordsFiltered);
        if (Arrays.asList(args).contains("-index")){
            ui.show(statistics.getFormattedWithIndex());
        } else {
            ui.show(statistics.getFormatted());
        }
    }
}
