package com.wordcount.domain;

public class Answer {
    private static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    private static final String MESSAGE_NUMBER_OF_UNIQUE_WORDS = ", unique: ";
    public static final String MESSAGE_AVERAGE_LENGTH_OF_WORDS = "; average word length: %.2f characters";

    private int count;
    private int uniqueWordCount;
    private final double averageWordLength;

    public Answer(int count, int uniqueWordCount, double averageWordLength) {
        this.count = count;
        this.uniqueWordCount = uniqueWordCount;
        this.averageWordLength = averageWordLength;
    }

    String getFormatted() {
        return String.format("%s%d%s%d%s",
                MESSAGE_NUMBER_OF_WORDS, count,
                MESSAGE_NUMBER_OF_UNIQUE_WORDS, uniqueWordCount,
                String.format(MESSAGE_AVERAGE_LENGTH_OF_WORDS, averageWordLength));
    }
}
