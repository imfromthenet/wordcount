package com.wordcount.domain.processors;

import java.util.List;

public class AverageLengthProcessor implements Processor {

    public static final String AVERAGE_LENGTH_TEXT = "; average word length: %.2f characters";

    @Override
    public String process(final List<String> words) {
        final double averageLength = words.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
        return String.format(AVERAGE_LENGTH_TEXT, averageLength);
    }
}
