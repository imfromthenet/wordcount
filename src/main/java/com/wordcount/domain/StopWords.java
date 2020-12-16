package com.wordcount.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StopWords {
    private String stopWordsAsString;
    private List<String> stopWords;

    public StopWords(String stopWordsAsString) {
        this.stopWordsAsString = stopWordsAsString;
    }

    public List<String> filter(List<String> words) {
        if (stopWords == null) {
            stopWords = prepareStopWords();
        }
        return words.stream()
                .filter(isNotStopWord())
                .collect(toList());
    }

    private Predicate<String> isNotStopWord() {
        return word -> !stopWords.contains(word);
    }

    private List<String> prepareStopWords() {
        return Stream.of(stopWordsAsString.split(" ")).collect(toList());
    }
}
