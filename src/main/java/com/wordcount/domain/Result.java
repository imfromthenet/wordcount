package com.wordcount.domain;

public class Result {
    public static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    public static final String MESSAGE_UNIQUE_WORDS = ", unique: ";
    public static final String MESSAGE_AVERAGE_LENGTH_OF_WORDS = "; average word length: %.2f characters";

    private final int wordCount;
    private final int uniqueWordsCount;
    private final double averageLength;

    public Result(final int wordCount, final int uniqueWordsCount, final double averageLength) {
        this.wordCount = wordCount;
        this.uniqueWordsCount = uniqueWordsCount;
        this.averageLength = averageLength;
    }

    String getFormatted() {
        return String.format("%s%d%s%d%s",
                MESSAGE_NUMBER_OF_WORDS, wordCount,
                MESSAGE_UNIQUE_WORDS, uniqueWordsCount,
                String.format(MESSAGE_AVERAGE_LENGTH_OF_WORDS, averageLength));
    }
}
