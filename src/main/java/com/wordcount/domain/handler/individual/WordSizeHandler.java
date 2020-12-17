package com.wordcount.domain.handler.individual;

import com.wordcount.domain.handler.Handler;

import java.util.List;

public class WordSizeHandler implements Handler {

    private static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";

    @Override
    public String handle(List<String> words) {
        return String.format("%s%d", MESSAGE_NUMBER_OF_WORDS, words.size());
    }
}
