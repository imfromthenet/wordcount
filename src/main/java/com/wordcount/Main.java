package com.wordcount;

import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordCounterApp;
import com.wordcount.io.ui.UI;
import com.wordcount.io.ui.UIFactory;
import com.wordcount.io.util.ConsoleWriter;
import com.wordcount.io.util.FileReader;
import com.wordcount.io.util.Writer;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        final FileReader fileReader = FileReader.getInstance();
        final StopWords stopWords = getStopWords(fileReader);
        final Writer consoleWriter = ConsoleWriter.getInstance();

        final UIFactory uiFactory = new UIFactory();
        final UI ui = uiFactory.create(args);
        final String input = ui.getInput();

        final WordCounterApp wordCounterApp = new WordCounterApp(
                input,
                consoleWriter,
                stopWords);
        wordCounterApp.countWords(args);
    }

    private static StopWords getStopWords(final FileReader fileReader) {
        StopWords stopWords = new StopWords(fileReader);
        stopWords.fillFrom(STOP_WORDS_FILE);
        return stopWords;
    }
}