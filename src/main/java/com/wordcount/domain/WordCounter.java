package com.wordcount.domain;

import java.util.HashSet;
import java.util.Set;

class WordCounter {
    private int count = 0;
    private Answer answer;
    private final Set<String> uniqueWords = new HashSet<>();

    void collect(final String candidate) {
        uniqueWords.add(candidate);
        count++;
    }

    Answer getAnswer() {
        if (answer == null) {
            answer = new Answer(count, uniqueWords.size());
            return answer;
        }
        return answer;
    }
}
