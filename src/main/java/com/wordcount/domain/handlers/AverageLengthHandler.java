package com.wordcount.domain.handlers;

import java.util.List;

public class AverageLengthHandler implements Handler {

    private static final String MESSAGE_AVERAGE_LENGTH_OF_WORDS = "; average word length: %.2f characters";

    @Override
    public String handle(List<String> words) {
        return String.format(MESSAGE_AVERAGE_LENGTH_OF_WORDS, getAverageLength(words));
    }

    private double getAverageLength(List<String> words) {
        return words.stream()
                .mapToInt(String::length)
                .average().orElse(0);
    }
}
