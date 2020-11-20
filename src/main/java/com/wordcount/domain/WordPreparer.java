package com.wordcount.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordPreparer {

    public static final String STANDALONE_HYPHEN = "-";
    private final Pattern pattern = Pattern.compile("[a-zA-Z-]+?[a-zA-Z-]*");
    private final StopWords stopWords;
    private final WordCollector wordCollector;

    public WordPreparer(final StopWords stopWords, final WordCollector wordCollector) {
        this.stopWords = Objects.requireNonNull(stopWords);
        this.wordCollector = Objects.requireNonNull(wordCollector);
    }

    protected void prepare(final String input) {
        Objects.requireNonNull(input);
        final Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            final String candidate = matcher.group();
            if (matchesOtherCriteria(candidate)) {
                wordCollector.collect(candidate);
            }
        }
    }

    private boolean matchesOtherCriteria(final String candidate) {
        return !stopWords.contain(candidate) && !candidate.equals(STANDALONE_HYPHEN);
    }

}
