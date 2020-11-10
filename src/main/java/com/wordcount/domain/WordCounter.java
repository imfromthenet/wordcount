package com.wordcount.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private final Pattern pattern = Pattern.compile("(?<!\\S)[a-zA-Z]++(?=\\s|$|[^a-z\\d\\s]++(?!\\S))");
    private final StopWords stopWords;

    public WordCounter(final StopWords stopWords) {
        this.stopWords = Objects.requireNonNull(stopWords);
    }

    public int count(final String input) {
        Objects.requireNonNull(input);
        if (input.equals("")) {
            return 0;
        }
        final Matcher matcher = pattern.matcher(input);

        int counter = 0;
        while (matcher.find()) {
            if (!stopWords.contain(matcher.group())) {
                counter++;
            }
        }
        return counter;
    }

}
