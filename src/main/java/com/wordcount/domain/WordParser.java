package com.wordcount.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordParser {

    private final Pattern pattern = Pattern.compile("(?<!\\S)[a-zA-Z]++(?=\\s|$|[^a-z\\d\\s]++(?!\\S))");
    private final StopWords stopWords;
    private final WordCounter wordCounter;

    public WordParser(final StopWords stopWords, final WordCounter wordCounter) {
        this.stopWords = Objects.requireNonNull(stopWords);
        this.wordCounter = Objects.requireNonNull(wordCounter);
    }

    protected void parse(final String input) {
        Objects.requireNonNull(input);
        final Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            final String candidate = matcher.group();
            if (!stopWords.contain(candidate)) {
                wordCounter.collect(candidate);
            }
        }
    }

}
