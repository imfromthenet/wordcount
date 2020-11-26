package com.wordcount.domain;

public class Result {
    private static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    private final int count;

    public Result(final int count) {
        this.count = count;
    }

    String getFormatted() {
        return String.format("%s%d", MESSAGE_NUMBER_OF_WORDS, count);
    }
}
