package com.wordcount;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private final Pattern pattern = Pattern.compile("(?<!\\S)[a-z]++(?=\\s|$|[^a-z\\d\\s]++(?!\\S))");

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
            counter++;
        }
        return counter;
    }

}
