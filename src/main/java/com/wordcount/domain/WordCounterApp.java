package com.wordcount.domain;

import com.wordcount.io.console.Writer;

public class WordCounterApp {

    private final String input;
    private final StopWords stopWords;
    private final WordCounter wordCounter;
    private final Writer writer;

    public WordCounterApp(final String input, final Writer writer, final StopWords stopWords) {
        this.input = input;
        this.wordCounter =  WordCounter.getInstance();
        this.writer = writer;
        this.stopWords = stopWords;
    }

    public void countWords() {
        Processor processor = new Processor(stopWords, wordCounter);
        processor.process(input);
        final Answer answer = wordCounter.getAnswer();
        writer.write(answer.toString());
    }

}
