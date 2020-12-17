package com.wordcount.domain.handler.individual;

import com.wordcount.domain.handler.Handler;

import java.util.List;

public class WordAverageLengthHandler implements Handler {

    private static final String MESSAGE_AVERAGE_WORD_LENGTH = "; average word length: %.2f characters";

    @Override
    public String handle(List<String> words) {
        return String.format(MESSAGE_AVERAGE_WORD_LENGTH,
                words.stream()
                        .mapToInt(String::length)
                        .average().orElse(0));
    }

}
