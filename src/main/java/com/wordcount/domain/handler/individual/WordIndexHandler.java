package com.wordcount.domain.handler.individual;

import com.wordcount.domain.handler.Handler;

import java.util.Collection;
import java.util.List;

import static java.lang.Character.isUpperCase;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class WordIndexHandler implements Handler {

    private static final String MESSAGE_INDEX = "\nIndex:\n%s";

    @Override
    public String handle(List<String> words) {
        return String.format(MESSAGE_INDEX, toIndex(words));
    }

    private String toIndex(List<String> words) {
        return words.stream()
                .filter(w -> !w.isEmpty())
                .sorted()
                .collect(groupingBy(w -> isUpperCase(w.codePointAt(0))))
                .values().stream()
                .flatMap(Collection::stream)
                .collect(joining("\n"));
    }

}
