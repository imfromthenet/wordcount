package com.wordcount.domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

public class StopWords {
    private String stopWordsAsString;
    private List<String> stopWords;

    public StopWords(String stopWordsAsString) {
        requireNonNull(this.stopWordsAsString = stopWordsAsString);
    }

    boolean contain(String candidate) {
        if (stopWords == null) {
            stopWords = Stream.of(stopWordsAsString.split(" ")).collect(toList());
        }
        return stopWords.contains(candidate);
    }
}
