package com.wordcount.domain;

public class Answer {
    private static final String MESSAGE_NUMBER_OF_WORDS_TOTAL_AND_UNIQUE = "Number of words: %d, unique: %d";
    private final int count;
    private final int countUniqueWords;

    public Answer(final int count, final int countUniqueWords) {
        this.count = count;
        this.countUniqueWords = countUniqueWords;
    }

    @Override
    public String toString() {
        return String.format(MESSAGE_NUMBER_OF_WORDS_TOTAL_AND_UNIQUE, count, countUniqueWords);
    }
}
