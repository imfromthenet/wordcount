package com.wordcount.domain;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class StopWords {
    private final List<String> stopWords;

    public StopWords(List<String> stopWords) {
        this.stopWords = requireNonNull(stopWords);
    }

    boolean contain(final String candidate) {
        return stopWords.contains(candidate);
    }
}
