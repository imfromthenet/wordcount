package com.wordcount.domain;

import com.wordcount.domain.workers.*;
import com.wordcount.io.console.Writer;

import java.util.Arrays;
import java.util.List;

public class WordCounterApp {

    public static final String INDEX_FLAG = "-index";
    private final String input;
    private final StopWords stopWords;
    private final WordCollector wordCollector;
    private final Writer writer;

    public WordCounterApp(final String input, final Writer writer, final StopWords stopWords) {
        this.input = input;
        this.writer = writer;
        this.stopWords = stopWords;
        this.wordCollector =  new WordCollector();
    }

    public void countWords(final String[] args) {
        final Processor processor = new Processor(stopWords, wordCollector);
        processor.process(input);
        List<Worker> workers = getWorkers(args);

        AnswerProvider answerProvider = new AnswerProvider(wordCollector.getWords(), workers);
        writer.write(answerProvider.getAnswer());
    }

    private List<Worker> getWorkers(final String[] args) {
        final List<Worker> workers;
        if (Arrays.asList(args).contains(INDEX_FLAG)) {
            workers = Arrays.asList(new Count(), new UniqueCount(), new AverageLength(), new Index());
        } else {

            workers = Arrays.asList(new Count(), new UniqueCount(), new AverageLength());
        }
        return workers;
    }

}
