package com.wordcount.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordParser {

    private final Pattern pattern = Pattern.compile("(?<!\\S)[a-zA-Z]++(?=\\s|$|[^a-z\\d\\s]++(?!\\S))");
    private final StopWords stopWords;

    public WordParser(final StopWords stopWords) {
        this.stopWords = Objects.requireNonNull(stopWords);
    }

    protected List<String> parse(final String input) {
        Objects.requireNonNull(input);
        final Matcher matcher = pattern.matcher(input);
        List<String> words = new ArrayList<>();

        while (matcher.find()) {
            final String candidate = matcher.group();
            if (!stopWords.contain(candidate)) {
                words.add(candidate);
            }
        }
        return words;
    }

}
