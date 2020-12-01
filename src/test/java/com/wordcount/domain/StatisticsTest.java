package com.wordcount.domain;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    @Test
    void providesWordCountUniqueWordCountAndAverageWordCountStatistics() {
        Statistics sut = new Statistics(asList("I", "am", "Grooooot", "am"));

        assertThat(sut.getFormatted()).startsWith("Number of words:")
                .contains("4")
                .contains("unique")
                .contains("3")
                .contains("average word length")
                .contains("3.25");
    }
}