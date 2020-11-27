package com.wordcount;

import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordCounterApp;
import com.wordcount.io.ui.UIFactory;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        WordCounterApp wordCounterApp = new WordCounterApp(UIFactory.construct(args), getStopWords());
        wordCounterApp.countWords();
    }

    private static StopWords getStopWords() {
        String[] array = {STOP_WORDS_FILE};
        return new StopWords(UIFactory.construct(array).readAsList());
    }
}