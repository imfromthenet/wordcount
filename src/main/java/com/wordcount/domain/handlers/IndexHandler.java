package com.wordcount.domain.handlers;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class IndexHandler implements Handler {

    private static final String MESSAGE_INDEX = "\n \nIndex:\n \n%s";

    @Override
    public String handle(List<String> words) {
        return String.format(MESSAGE_INDEX, getIndex(words));
    }

    private String getIndex(List<String> words) {
        return words.stream()
                .sorted()
                .collect(groupingBy(string -> Character.isUpperCase(string.charAt(0))))
                .values().stream()
                .flatMap(List::stream)
                .collect(joining("\n \n"));
    }
}
