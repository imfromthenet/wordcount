package com.wordcount.domain;

import java.util.ArrayList;
import java.util.List;

class WordCollector {
    final List<String> words = new ArrayList<>();

    List<String> getWords() {
        return words;
    }

    void collect(final String candidate) {
        words.add(candidate);
    }
}
