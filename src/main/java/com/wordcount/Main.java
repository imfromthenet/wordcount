package com.wordcount;

import com.wordcount.io.ConsoleUI;
import com.wordcount.io.FileReader;
import com.wordcount.io.Readable;

import java.util.List;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        List<String> stopWords = getStopwords();
        Application application = new Application(new ConsoleUI(), new WordCounter(stopWords));
        application.run();
    }

    private static List<String> getStopwords() {
        Readable fileReader = new FileReader();
        return fileReader.readAsLines(STOP_WORDS_FILE);
    }
}