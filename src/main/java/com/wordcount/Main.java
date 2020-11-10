package com.wordcount;

import com.wordcount.domain.StopWords;
import com.wordcount.io.ConsoleUI;
import com.wordcount.io.FileReader;
import com.wordcount.io.Readable;
import com.wordcount.domain.WordCounter;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        StopWords stopWords = getStopWords();
        Application application = new Application(new ConsoleUI(), new WordCounter(stopWords));
        application.run();
    }

    private static StopWords getStopWords() {
        Readable fileReader = new FileReader();
        StopWords stopWords = new StopWords(fileReader);
        stopWords.fillFrom(STOP_WORDS_FILE);
        return stopWords;
    }
}