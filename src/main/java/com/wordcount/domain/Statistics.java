package com.wordcount.domain;

public class Statistics {
    private static final String MESSAGE_NUMBER_OF_WORDS_TOTAL_AND_UNIQUE =
            "Number of words: %d, unique: %d; average word length: %.2f characters";
    private final int count;
    private final long countUniqueWords;
    private final double averageWordLength;

    public Statistics(final int count, final long countUniqueWords, final double averageWordLength) {
        this.count = count;
        this.countUniqueWords = countUniqueWords;
        this.averageWordLength = averageWordLength;
    }

    @Override
    public String toString() {
        return String.format(MESSAGE_NUMBER_OF_WORDS_TOTAL_AND_UNIQUE, count, countUniqueWords, averageWordLength);
    }
}
