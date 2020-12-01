package com.wordcount.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

class WordParser {

    private static final String STANDALONE_HYPHEN = "-";
    private final Pattern pattern = Pattern.compile("[a-zA-Z-]+?[a-zA-Z-]*");
    private StopWords stopWords;

    WordParser(StopWords stopWords) {
        this.stopWords = requireNonNull(stopWords);
    }

    List<String> parse(String input) {
        Matcher matcher = pattern.matcher(requireNonNull(input));
        List<String> words = new ArrayList<>();

        while (matcher.find()) {
            String candidate = matcher.group();
            if (shouldBeAddedToList(candidate)) {
                words.add(candidate);
            }
        }
        return words;
    }

    private boolean shouldBeAddedToList(final String candidate) {
        return !stopWords.contain(candidate) && !candidate.equals(STANDALONE_HYPHEN);
    }
}
