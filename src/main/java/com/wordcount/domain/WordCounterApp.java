package com.wordcount.domain;

import com.wordcount.domain.processors.Processors;
import com.wordcount.domain.processors.ProcessorsFactory;
import com.wordcount.util.Writer;

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
        final Processors processors = new ProcessorsFactory().getProcessors(args);
        final String answer = processors.process(wordCollector.getWords());
        writer.write(answer);
    }
}
