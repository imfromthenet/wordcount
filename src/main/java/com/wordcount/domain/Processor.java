package com.wordcount.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Processor {

    public static final String STANDALONE_HYPHEN = "-";
    private final Pattern pattern = Pattern.compile("[a-zA-Z-]+?[a-zA-Z-]*");
    private final StopWords stopWords;
    private final WordCounter wordCounter;

    public Processor(final StopWords stopWords, final WordCounter wordCounter) {
        this.stopWords = Objects.requireNonNull(stopWords);
        this.wordCounter = Objects.requireNonNull(wordCounter);
    }

    protected void process(final String input) {
        Objects.requireNonNull(input);
        final Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            final String candidate = matcher.group();
            if (!stopWords.contain(candidate) && !candidate.equals(STANDALONE_HYPHEN)) {
                wordCounter.collect(candidate);
            }
        }
    }

}
