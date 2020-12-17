package com.wordcount.domain.handler.individual;

import com.wordcount.domain.handler.Handler;

import java.util.HashSet;
import java.util.List;

public class WordUniqueCountHandler implements Handler {

    private static final String MESSAGE_NUMBER_OF_UNIQUE_WORDS = ", unique: ";

    @Override
    public String handle(List<String> words) {
        return String.format("%s%d", MESSAGE_NUMBER_OF_UNIQUE_WORDS, new HashSet<>(words).size());
    }

}
