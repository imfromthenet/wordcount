package com.wordcount;

import com.wordcount.domain.InputPreparer;
import com.wordcount.domain.Processor;
import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordCounter;
import com.wordcount.io.console.Writer;
import com.wordcount.io.file.IFileReader;
import com.wordcount.io.file.FileReader;
import com.wordcount.io.console.ConsoleReader;
import com.wordcount.io.console.ConsoleUI;
import com.wordcount.io.console.ConsoleWriter;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        IFileReader fileReader = new FileReader();
        StopWords stopWords = getStopWords(fileReader);
        WordCounter wordCounter = WordCounter.getInstance();
        Writer consoleWriter = new ConsoleWriter();
        Application application = new Application(
                new InputPreparer(
                        new ConsoleUI(consoleWriter, new ConsoleReader()),
                        fileReader),
                new Processor(stopWords, wordCounter),
                wordCounter,
                args,
                consoleWriter);
        application.run();
    }

    private static StopWords getStopWords(final IFileReader fileReader) {
        StopWords stopWords = new StopWords(fileReader);
        stopWords.fillFrom(STOP_WORDS_FILE);
        return stopWords;
    }
}