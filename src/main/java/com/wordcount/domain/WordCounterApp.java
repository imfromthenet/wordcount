package com.wordcount.domain;

import com.wordcount.domain.processors.Processors;
import com.wordcount.domain.processors.ProcessorsFactory;
import com.wordcount.io.console.Writer;

public class WordCounterApp {

    public static final String INDEX_FLAG = "-index";
    public static final String DICT_FLAG = "-dict=";
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
        /*
        * We will need a filereader to read from dict file, if it is available. Unless we do it in the main where we were reading the stopwords and then pass those as.... an optional??
        *
        * consider making Reader and Writer Static
        * */
        final Processors processors = new ProcessorsFactory().getProcessors(args);
        final String answer = processors.process(wordCollector.getWords());
        writer.write(answer);
    }
}
