package com.wordcount;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private final Pattern pattern = Pattern.compile("(?<!\\S)[a-zA-Z]++(?=\\s|$|[^a-z\\d\\s]++(?!\\S))");
    private final List<String> stopWords;

    public WordCounter(final List<String> stopWords) {
        this.stopWords = Objects.requireNonNull(stopWords);
    }

    public int count(final String input) {
        Objects.requireNonNull(input);
        if (input.equals("")){
            return 0;
        }
        final Matcher matcher = pattern.matcher(input);

        return countOccurrences(matcher);
    }

    private int countOccurrences(final Matcher matcher) {
        int counter = 0;
        while (matcher.find()) {
            if (!stopWords.contains(matcher.group())) {
                counter++;
            }
        }
        return counter;
    }

}
