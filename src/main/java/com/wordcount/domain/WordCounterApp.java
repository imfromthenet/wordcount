package com.wordcount.domain;

import java.util.List;

public class WordCounterApp {

    private UI ui;
    private StopWords stopWords;

    public WordCounterApp(UI ui,StopWords stopWords) {
        this.ui = ui;
        this.stopWords = stopWords;
    }

    public void countWords() {
        String userInput = ui.getUserInput();
        WordParser parser = new WordParser(stopWords);
        List<String> wordsFiltered = parser.parse(userInput);
        Answer answer = new Answer(wordsFiltered.size());
        ui.show(answer.getFormatted());
    }

}
