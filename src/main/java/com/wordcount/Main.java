package com.wordcount;

import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordCounterApp;
import com.wordcount.io.ConsoleWriter;
import com.wordcount.io.Writer;
import com.wordcount.io.ui.UIFactory;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        final Writer consoleWriter = new ConsoleWriter();

        final WordCounterApp wordCounterApp = new WordCounterApp(
                UIFactory.getFactory(args),
                consoleWriter,
                getStopWords());
        wordCounterApp.countWords();
    }

    private static StopWords getStopWords() {
        String[] array = {STOP_WORDS_FILE};
        return new StopWords(UIFactory.getFactory(array).readAsList());
    }
}