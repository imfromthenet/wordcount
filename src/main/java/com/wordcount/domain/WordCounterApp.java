package com.wordcount.domain;

import com.wordcount.domain.workers.Workers;
import com.wordcount.domain.workers.WorkersFactory;
import com.wordcount.io.console.Writer;

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
        final WordPreparer wordPreparer = new WordPreparer(stopWords, wordCollector);
        wordPreparer.prepare(input);
        final Workers workers = new WorkersFactory().getWorkers(args);
        final String answer = workers.work(wordCollector.getWords());
        writer.write(answer);
    }
}
