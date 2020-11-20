package com.wordcount.domain.processors;

import java.util.List;

public class UniqueCount implements Processor {

    public static final String UNIQUE_TEXT = ", unique: %d";

    @Override
    public String process(final List<String> words) {
        return String.format(UNIQUE_TEXT,
                words.stream()
                        .distinct()
                        .count());
    }
}
