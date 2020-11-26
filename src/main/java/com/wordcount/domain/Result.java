package com.wordcount.domain;

public class Result {
    public static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    public static final String MESSAGE_UNIQUE_WORDS = ", unique: ";
    private final int wordCount;
    private final int uniqueWordsCount;

    public Result(final int wordCount, final int uniqueWordsCount) {
        this.wordCount = wordCount;
        this.uniqueWordsCount = uniqueWordsCount;
    }

    String getFormatted() {
        return String.format("%s%d%s%d", MESSAGE_NUMBER_OF_WORDS, wordCount, MESSAGE_UNIQUE_WORDS, uniqueWordsCount);
    }
}
