package com.wordcount.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

class WordParser {

    public static final String STANDALONE_HYPHEN = "-";
    private final Pattern pattern = Pattern.compile("[a-zA-Z-]+?[a-zA-Z-]*");
    private final StopWords stopWords;

    public WordParser(final StopWords stopWords) {
        this.stopWords = requireNonNull(stopWords);
    }

    List<String> parse(final String input) {
        final Matcher matcher = pattern.matcher(requireNonNull(input));
        final List<String> words = new ArrayList<>();

        while (matcher.find()) {
            final String candidate = matcher.group();
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
