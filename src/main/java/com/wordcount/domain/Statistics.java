package com.wordcount.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    private static final String MESSAGE_NUMBER_OF_WORDS = "Number of words: ";
    private static final String MESSAGE_NUMBER_OF_UNIQUE_WORDS = ", unique: ";
    private static final String MESSAGE_AVERAGE_LENGTH_OF_WORDS = "; average word length: %.2f characters";
    private static final String MESSAGE_INDEX = "\n \nIndex:\n \n%s";
    private List<String> wordsFiltered;

    Statistics(List<String> wordsFiltered) {
        this.wordsFiltered = wordsFiltered;
    }

    protected String getFormatted() {
        return String.format("%s%d%s%d%s",
                MESSAGE_NUMBER_OF_WORDS, wordsFiltered.size(),
                MESSAGE_NUMBER_OF_UNIQUE_WORDS, getUniqueWordCount(wordsFiltered),
                String.format(MESSAGE_AVERAGE_LENGTH_OF_WORDS, getAverageLength(wordsFiltered)));
    }

    protected String getFormattedWithIndex() {
        return String.format("%s%s",
                getFormatted(),
                String.format(MESSAGE_INDEX, getIndex(wordsFiltered)));
    }

    private int getUniqueWordCount(List<String> wordsFiltered) {
        return new HashSet<>(wordsFiltered).size();
    }

    private double getAverageLength(List<String> wordsFiltered) {
        return wordsFiltered.stream()
                .mapToInt(String::length)
                .average().orElse(0);
    }

    private String getIndex(List<String> wordsFiltered) {
        return wordsFiltered.stream()
                .sorted()
                .collect(Collectors.groupingBy(string -> Character.isUpperCase(string.charAt(0))))
                .values().stream()
                .flatMap(List::stream)
                .collect(Collectors.joining("\n \n"));
    }
}
