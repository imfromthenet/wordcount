package com.wordcount.domain;

import java.util.List;
import java.util.Objects;

public class StopWords {
    private final List<String> stopWords;

    public StopWords(List<String> stopWords) {
        this.stopWords = Objects.requireNonNull(stopWords);
    }

    public boolean contain(final String candidate) {
        return stopWords.contains(candidate);
    }
}
