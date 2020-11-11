package com.wordcount;

import com.wordcount.domain.WordCounter;
import com.wordcount.domain.StopWords;
import com.wordcount.domain.Processor;
import com.wordcount.io.ConsoleUI;
import com.wordcount.io.FileReader;
import com.wordcount.io.Readable;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        StopWords stopWords = getStopWords();
        WordCounter wordCounter = WordCounter.getInstance();
        Application application = new Application(
                new ConsoleUI(),
                new Processor(stopWords, wordCounter),
                wordCounter);
        application.run();
    }

    private static StopWords getStopWords() {
        Readable fileReader = new FileReader();
        StopWords stopWords = new StopWords(fileReader);
        stopWords.fillFrom(STOP_WORDS_FILE);
        return stopWords;
    }
}