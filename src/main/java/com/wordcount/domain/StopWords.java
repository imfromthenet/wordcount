package com.wordcount.domain;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class StopWords {
    private List<String> stopWords;

    public StopWords(List<String> stopWords) {
        this.stopWords = requireNonNull(stopWords);
    }

    boolean contain(String candidate) {
        return stopWords.contains(candidate);
    }
}
