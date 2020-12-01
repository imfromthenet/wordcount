package com.wordcount;

import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordCounterApp;
import com.wordcount.io.FileReader;
import com.wordcount.io.Reader;
import com.wordcount.io.ui.UIFactory;

public class Main {
    private static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        WordCounterApp wordCounterApp = new WordCounterApp(UIFactory.construct(args), getStopWords(), args);
        wordCounterApp.countWords();
    }

    private static StopWords getStopWords() {
        Reader reader = new FileReader(STOP_WORDS_FILE);
        return new StopWords(reader.read());
    }
}