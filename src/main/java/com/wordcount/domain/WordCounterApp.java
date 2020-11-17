package com.wordcount.domain;

import com.wordcount.io.console.Writer;

public class WordCounterApp {

    private final String input;
    private final StopWords stopWords;
    private final WordCounter wordCounter;
    private final Writer writer;

    public WordCounterApp(final String input, final Writer writer, final StopWords stopWords) {
        this.input = input;
        this.writer = writer;
        this.stopWords = stopWords;
        this.wordCounter =  new WordCounter();
    }

    public void countWords() {
        final Processor processor = new Processor(stopWords, wordCounter);
        processor.process(input);
        final Answer answer = wordCounter.getAnswer();
        writer.write(answer.toString());
    }

}
