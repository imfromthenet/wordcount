package com.wordcount.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

public class WordParser {

    private Pattern pattern = Pattern.compile("[a-zA-Z]+?[a-zA-Z]*");
    private StopWords stopWords;

    public WordParser(StopWords stopWords) {
        this.stopWords = requireNonNull(stopWords);
    }

    public List<String> parse(String input) {
        Matcher matcher = pattern.matcher(requireNonNull(input));
        List<String> words = new ArrayList<>();

        while (matcher.find()) {
            String candidate = matcher.group();
            if (!stopWords.contain(candidate)) {
                words.add(candidate);
            }
        }
        return words;
    }

}
