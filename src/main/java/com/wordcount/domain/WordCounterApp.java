package com.wordcount.domain;

import java.util.List;

public class WordCounterApp {

    private UI ui;
    private StopWords stopWords;

    public WordCounterApp(UI ui, StopWords stopWords) {
        this.ui = ui;
        this.stopWords = stopWords;
    }

    public void countWords() {
        String userInput = ui.getInput();
        WordParser parser = new WordParser();
        List<String> wordsParsed = parser.parse(userInput);
        List<String> wordsFiltered = stopWords.filter(wordsParsed);
        Answer answer = new Answer(wordsFiltered.size());
        ui.show(answer.getFormatted());
    }

}
