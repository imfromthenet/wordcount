package com.wordcount.domain;

public class Answer {
    private static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    private static final String MESSAGE_NUMBER_OF_UNIQUE_WORDS = ", unique: ";
    private int count;
    private final int uniqueWordCount;

    public Answer(int count, int uniqueWordCount) {
        this.count = count;
        this.uniqueWordCount = uniqueWordCount;
    }

    public String getFormatted() {
        return String.format("%s%d%s%d",
                MESSAGE_NUMBER_OF_WORDS, count,
                MESSAGE_NUMBER_OF_UNIQUE_WORDS, uniqueWordCount);
    }
}
