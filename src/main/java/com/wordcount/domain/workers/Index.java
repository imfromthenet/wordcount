package com.wordcount.domain.workers;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class Index implements Worker {

    public static final String INDEX_TEXT = "\n \nIndex:\n \n%s";

    @Override
    public String process(final List<String> words) {
        String index = words.stream()
                .collect(groupingBy(word -> Character.isUpperCase(word.codePointAt(0))))
                .values().stream()
                .flatMap(strings -> strings.stream().sorted())
                .collect(joining("\n \n"));
        return String.format(INDEX_TEXT, index);
    }
}
