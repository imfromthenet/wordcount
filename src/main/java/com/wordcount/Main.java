package com.wordcount;

import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordCounterApp;
import com.wordcount.io.UI;
import com.wordcount.io.UIFactory;
import com.wordcount.io.console.ConsoleWriter;
import com.wordcount.io.console.Writer;
import com.wordcount.io.file.FileReader;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        final FileReader fileReader = FileReader.getInstance();
        final StopWords stopWords = getStopWords(fileReader);
        final Writer consoleWriter = new ConsoleWriter();

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