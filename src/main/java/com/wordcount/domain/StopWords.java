package com.wordcount.domain;

import java.util.List;

public class StopWords implements MyDictionary {
    private final List<String> stopWords;

    public StopWords(final List<String> words) {
        this.stopWords = words;
    }

    @Override
    public boolean contain(final String candidate) {
        return stopWords.contains(candidate);
    }
}
