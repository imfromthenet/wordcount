package com.wordcount.domain;

public class Answer {
    private static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    private final int count;

    public Answer(final int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("%s%d", MESSAGE_NUMBER_OF_WORDS, count);
    }
}
