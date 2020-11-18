package com.wordcount.domain;

import java.util.ArrayList;
import java.util.List;

class StatisticsProvider {
    private Statistics statistics;
    private final List<String> words = new ArrayList<>();

    void collect(final String candidate) {
        words.add(candidate);
    }

    Statistics getStatistics() {
        if (statistics == null) {
            statistics = new Statistics(
                    words.size(),
                    getUniqueCount(),
                    getAverageLength());
            return statistics;
        }
        return statistics;
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
