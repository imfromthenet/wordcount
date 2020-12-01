package com.wordcount.domain.handlers;

import java.util.HashSet;
import java.util.List;

public class UniqueWordsCountHandler implements Handler {

    private static final String MESSAGE_NUMBER_OF_UNIQUE_WORDS = ", unique: %s";

    @Override
    public String handle(List<String> words) {
        return String.format(MESSAGE_NUMBER_OF_UNIQUE_WORDS, getUniqueWordCount(words));
    }

    private int getUniqueWordCount(List<String> words) {
        return new HashSet<>(words).size();
    }
}
