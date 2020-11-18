package com.wordcount.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Processor {

    public static final String STANDALONE_HYPHEN = "-";
    private final Pattern pattern = Pattern.compile("[a-zA-Z-]+?[a-zA-Z-]*");
    private final StopWords stopWords;
    private final StatisticsProvider statisticsProvider;

    public Processor(final StopWords stopWords, final StatisticsProvider statisticsProvider) {
        this.stopWords = Objects.requireNonNull(stopWords);
        this.statisticsProvider = Objects.requireNonNull(statisticsProvider);
    }

    protected void process(final String input) {
        Objects.requireNonNull(input);
        final Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            final String candidate = matcher.group();
            if (matchesOtherCriteria(candidate)) {
                statisticsProvider.collect(candidate);
            }
        }
    }

    private boolean matchesOtherCriteria(final String candidate) {
        return !stopWords.contain(candidate) && !candidate.equals(STANDALONE_HYPHEN);
    }

}
