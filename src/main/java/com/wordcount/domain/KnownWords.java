package com.wordcount.domain;

import java.util.List;
import java.util.Objects;

public class KnownWords implements MyDictionary {
    private final List<String> knownWords;

    public KnownWords(final List<String> words) {
        this.knownWords = Objects.requireNonNull(words);
    }

    @Override
    public boolean contain(final String candidate) {
        return knownWords.contains(candidate);
    }
}
