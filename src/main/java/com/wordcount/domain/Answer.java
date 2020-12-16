package com.wordcount.domain;

import java.util.HashSet;
import java.util.List;

public class Answer {
    private static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    private static final String MESSAGE_NUMBER_OF_UNIQUE_WORDS = ", unique: ";
    private static final String MESSAGE_AVERAGE_WORD_LENGTH = "; average word length: %.2f characters";

    private final List<String> wordsFiltered;

    public Answer(List<String> wordsFiltered) {
        this.wordsFiltered = wordsFiltered;
    }

    public String getFormatted() {
        return String.format("%s%d%s%d%s",
                MESSAGE_NUMBER_OF_WORDS, wordsFiltered.size(),
                MESSAGE_NUMBER_OF_UNIQUE_WORDS, getUniqueWordCount(),
                String.format(MESSAGE_AVERAGE_WORD_LENGTH, getAverageWordLength()));
    }

    private int getUniqueWordCount() {
        return new HashSet<>(wordsFiltered).size();
    }

    private double getAverageWordLength() {
        return wordsFiltered.stream()
                .mapToInt(String::length)
                .average().orElse(0);
    }
}
