package com.wordcount.domain.handlers;

import java.util.List;

public class WordCountHandler implements Handler {

    private static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: %s";

    @Override
    public String handle(List<String> words) {
        return String.format(MESSAGE_NUMBER_OF_WORDS, words.size());
    }
}
