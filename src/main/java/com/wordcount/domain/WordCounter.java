package com.wordcount.domain;

import java.util.ArrayList;
import java.util.List;

class WordCounter {
    private Answer answer;
    private final List<String> words = new ArrayList<>();

    void collect(final String candidate) {
        words.add(candidate);
    }

    Answer getAnswer() {
        if (answer == null) {
            answer = new Answer(
                    words.size(),
                    getUniqueCount(),
                    getAverageLength());
            return answer;
        }
        return answer;
    }

    private long getUniqueCount() {
        return words.stream().distinct().count();
    }

    private double getAverageLength() {
        return words.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
    }
}
