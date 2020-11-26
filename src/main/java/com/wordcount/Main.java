package com.wordcount;

import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordCounterApp;
import com.wordcount.io.ConsoleWriter;
import com.wordcount.io.Writer;
import com.wordcount.io.ui.UIFactory;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        final FileReader fileReader = new FileReader();
        final StopWords stopWords = getStopWords(fileReader);
        final Writer consoleWriter = new ConsoleWriter();

        final WordCounterApp wordCounterApp = new WordCounterApp(
                UIFactory.getFactory(args),
                consoleWriter,
                stopWords);
        wordCounterApp.countWords();
    }

    private static StopWords getStopWords(final FileReader fileReader) {
        StopWords stopWords = new StopWords(fileReader);
        stopWords.fillFrom(STOP_WORDS_FILE);
        return stopWords;
    }
}