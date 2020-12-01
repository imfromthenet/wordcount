package com.wordcount.domain.handlers;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class AverageLengthHandlerTest {

    @Test
    void countsAverageWordAndReturnsResult() {
        Handler sut = new AverageLengthHandler();
        String result = sut.handle(asList("one", "sevens"));

        assertThat(result).containsSubsequence("average word length:", "4.50", "characters");
    }
}