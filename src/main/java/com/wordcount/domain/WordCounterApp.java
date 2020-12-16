package com.wordcount.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<String> uniqueWords = new HashSet<>(wordsFiltered);
        Answer answer = new Answer(wordsFiltered.size(), uniqueWords.size());
        ui.show(answer.getFormatted());
    }

}
