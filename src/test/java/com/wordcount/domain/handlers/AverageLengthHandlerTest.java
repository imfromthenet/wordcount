package com.wordcount.domain.handlers;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class AverageLengthHandlerTest {

    @Test
    void countsAverageWordAndReturnsResult() {
        Handler sut = new AverageLengthHandler();
        String result = sut.handle(asList("one", "sevens"));

        assertThat(result).containsSubsequence("average word length:", "4.50", "characters");
    }

    @Test
    void whenInputIsEmptyAverageLengthReturnedIsEmpty() {
        Handler sut = new AverageLengthHandler();
        String result = sut.handle(emptyList());

        assertThat(result).containsSubsequence("average word length:", "0.00", "characters");
    }
}