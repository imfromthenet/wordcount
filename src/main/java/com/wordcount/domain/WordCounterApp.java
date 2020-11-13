package com.wordcount.domain;

import com.wordcount.io.InputPreparer;
import com.wordcount.io.console.Writer;

import java.util.Objects;

public class WordCounterApp {

    private final InputPreparer inputPreparer;
    private final StopWords stopWords;
    private final WordCounter wordCounter;
    private final String[] parameter;
    private final Writer writer;

    public WordCounterApp(final InputPreparer inputPreparer, final String[] parameter, Writer writer, final StopWords stopWords) {
        this.inputPreparer = Objects.requireNonNull(inputPreparer);
        this.wordCounter =  WordCounter.getInstance();
        this.parameter = parameter;
        this.writer = writer;
        this.stopWords = stopWords;
    }

    public void run() {
        String input = inputPreparer.getInput(parameter);
        Processor processor = new Processor(stopWords, wordCounter);
        processor.process(input);
        final Answer answer = wordCounter.getAnswer();
        writer.write(answer.toString());
    }

}
