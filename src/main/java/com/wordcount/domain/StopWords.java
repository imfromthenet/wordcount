package com.wordcount.domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StopWords {
    private List<String> stopWords;

    public StopWords(String stopWordsAsString) {
        this.stopWords = toStopWords(stopWordsAsString);
    }

    public List<String> filter(List<String> words) {
        return words.stream()
                .filter(word -> !stopWords.contains(word))
                .collect(toList());
    }

    private List<String> toStopWords(String stopWordsAsString) {
        return Stream.of(stopWordsAsString.split(" ")).collect(toList());
    }
}
