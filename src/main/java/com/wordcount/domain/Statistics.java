package com.wordcount.domain;

import java.util.HashSet;
import java.util.List;

public class Statistics {
    public static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    public static final String MESSAGE_UNIQUE_WORDS = ", unique: ";
    public static final String MESSAGE_AVERAGE_LENGTH_OF_WORDS = "; average word length: %.2f characters";
    private final List<String> words;

    public Statistics(final List<String> words) {
        this.words = words;
    }

    protected String getAsString() {
        return String.format("%s%d%s%d%s",
                MESSAGE_NUMBER_OF_WORDS, words.size(),
                MESSAGE_UNIQUE_WORDS, getUniqueWordsCount(words),
                String.format(MESSAGE_AVERAGE_LENGTH_OF_WORDS, getAverageLength(words)));
    }
    private int getUniqueWordsCount(final List<String> wordsWithoutStopWords) {
        return new HashSet<>(wordsWithoutStopWords).size();
    }

    private double getAverageLength(final List<String> wordsFiltered) {
        return wordsFiltered.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
    }
}
