package com.wordcount.domain;

import com.wordcount.io.console.Writer;

public class WordCounterApp {

    private final String input;
    private final StopWords stopWords;
    private final StatisticsProvider statisticsProvider;
    private final Writer writer;

    public WordCounterApp(final String input, final Writer writer, final StopWords stopWords) {
        this.input = input;
        this.writer = writer;
        this.stopWords = stopWords;
        this.statisticsProvider =  new StatisticsProvider();
    }

    public void countWords() {
        final Processor processor = new Processor(stopWords, statisticsProvider);
        processor.process(input);
        final Statistics statistics = statisticsProvider.getStatistics();
        writer.write(statistics.toString());
    }

}
