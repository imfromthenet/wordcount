package com.wordcount.domain;

import com.wordcount.io.ui.UI;

public class WordCounterApp {

    private final UI ui;
    private final StopWords stopWords;
    private final WordCounter wordCounter;

    public WordCounterApp(final UI ui, final StopWords stopWords) {
        this.ui = ui;
        this.stopWords = stopWords;
        this.wordCounter =  new WordCounter();
    }

    public void countWords() {
        final String userInput = ui.getInput();
        final Processor processor = new Processor(stopWords, wordCounter);
        processor.process(userInput);
        final Answer answer = wordCounter.getAnswer();
        ui.write(answer.toString());
    }

}
