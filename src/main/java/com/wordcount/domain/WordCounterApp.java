package com.wordcount.domain;

import com.wordcount.domain.processors.Processors;
import com.wordcount.domain.processors.ProcessorsFactory;
import com.wordcount.io.console.Writer;

public class WordCounterApp {

    public static final String INDEX_FLAG = "-index";
    public static final String DICTIONARY_FLAG = "-dictionary=";
    private final String input;
    private final MyDictionary stopWords;
    private final MyDictionary knownWords;
    private final WordCollector wordCollector;
    private final Writer writer;

    public WordCounterApp(final String input, final Writer writer, final MyDictionary stopWords, final MyDictionary knownWords) {
        this.input = input;
        this.writer = writer;
        this.stopWords = stopWords;
        this.knownWords = knownWords;
        this.wordCollector =  new WordCollector();
    }

    public void countWords(final String[] args) {
        final WordPreparer wordPreparer = new WordPreparer(stopWords, wordCollector);
        wordPreparer.prepare(input);
        final Processors processors = new ProcessorsFactory().getProcessors(args, knownWords);
        final String answer = processors.process(wordCollector.getWords());
        writer.write(answer);
    }
}
