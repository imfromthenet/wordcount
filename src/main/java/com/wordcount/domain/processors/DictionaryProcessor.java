package com.wordcount.domain.processors;

import com.wordcount.domain.MyDictionary;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class DictionaryProcessor implements Processor {
    public static final String INDEX_TEXT = "\n \nIndex";
    public static final String UNKNOWN_TEXT = " (unknown: %d):";
    public static final String SPACES_AT_THE_END_OF_FIRST_LINE_AND_THE_PROCESSED_WORDS = "\n \n%s";
    private final MyDictionary knownWords;
    private int numberUnknownWords;

    public DictionaryProcessor(final MyDictionary knownWords) {
        this.knownWords = knownWords;
    }

    @Override
    public String process(final List<String> words) {
        final String indexWithMarkedWords = words.stream()
                .collect(groupingBy(word -> Character.isUpperCase(word.codePointAt(0))))
                .values().stream()
                .flatMap(strings -> strings.stream().sorted())
                .map(this::addAsteriskIfNew)
                .collect(joining("\n \n"));

        return assembleAnswer(indexWithMarkedWords);
    }

    private String assembleAnswer(final String indexWithMarkedWords) {
        final String second = String.format(UNKNOWN_TEXT, numberUnknownWords);
        final String last = String.format(SPACES_AT_THE_END_OF_FIRST_LINE_AND_THE_PROCESSED_WORDS, indexWithMarkedWords);
        return String.format("%s%s%s",INDEX_TEXT, second, last);
    }

    private String addAsteriskIfNew(final String word) {
        if (knownWords.contain(word)) return word;

        numberUnknownWords ++;
        return word + "*";
    }
}
