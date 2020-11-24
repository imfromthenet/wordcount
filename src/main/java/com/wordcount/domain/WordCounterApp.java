package com.wordcount.domain;

import com.wordcount.io.UI;
import com.wordcount.io.console.Writer;

public class WordCounterApp {

    private final UI ui;
    private final StopWords stopWords;
    private final WordCounter wordCounter;
    private final Writer writer;

    public WordCounterApp(final UI ui, final Writer writer, final StopWords stopWords) {
        this.ui = ui;
        this.writer = writer;
        this.stopWords = stopWords;
        this.wordCounter =  new WordCounter();
    }

    public void countWords() {
        final String userInput = ui.getInput();
        final Processor processor = new Processor(stopWords, wordCounter);
        processor.process(userInput);
        final Answer answer = wordCounter.getAnswer();
        writer.write(answer.toString());
    }

}
