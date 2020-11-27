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
        return String.format("%s%s%s",
                getWordSizeInAMessage(),
                getUniqueWordsCountInAMessage(),
                getAverageLengthInAMessage());
    }

    private String getWordSizeInAMessage() {
        return String.format("%s%d", MESSAGE_NUMBER_OF_WORDS, words.size());
    }

    private String getUniqueWordsCountInAMessage() {
        return String.format("%s%d", MESSAGE_UNIQUE_WORDS, new HashSet<>(words).size());
    }

    private String getAverageLengthInAMessage() {
        final double averageLength = words.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
        return String.format(MESSAGE_AVERAGE_LENGTH_OF_WORDS, averageLength);
    }
}
