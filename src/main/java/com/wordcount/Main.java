package com.wordcount;

import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordCounterApp;
import com.wordcount.io.InputPreparer;
import com.wordcount.io.console.ConsoleReader;
import com.wordcount.io.console.ConsoleUI;
import com.wordcount.io.console.ConsoleWriter;
import com.wordcount.io.console.Writer;
import com.wordcount.io.file.FileReader;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        StopWords stopWords = getStopWords(fileReader);
        Writer consoleWriter = new ConsoleWriter();
        WordCounterApp wordCounterApp = new WordCounterApp(
                new InputPreparer(
                        new ConsoleUI(consoleWriter, new ConsoleReader()),
                        fileReader),
                args,
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