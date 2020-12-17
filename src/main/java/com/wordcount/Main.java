package com.wordcount;

import com.wordcount.domain.InputUI;
import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordCounterApp;
import com.wordcount.domain.handler.HandlerFactory;
import com.wordcount.io.FileInputUI;
import com.wordcount.io.UIFactory;

import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    private static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        List<String> consoleArgs = asList(args);
        WordCounterApp wordCounterApp = new WordCounterApp(UIFactory.construct(consoleArgs), getStopWords(), HandlerFactory.construct(consoleArgs));
        wordCounterApp.countWords();
    }

    private static StopWords getStopWords() {
        InputUI inputUI = new FileInputUI(STOP_WORDS_FILE);
        return new StopWords(inputUI.getInput());
    }

}