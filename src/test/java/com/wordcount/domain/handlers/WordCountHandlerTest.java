package com.wordcount.domain.handlers;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class WordCountHandlerTest {

    @Test
    void preparesAndReturnsWordCount() {
        Handler sut = new WordCountHandler();
        String result = sut.handle(asList("anna", "anna", "borat"));

        assertThat(result).containsSubsequence("Number of words:", "3");
    }

    @Test
    void returnsCountOfZeroWhenInputIsEmpty() {
        Handler sut = new WordCountHandler();
        String result = sut.handle(emptyList());

        assertThat(result).containsSubsequence("Number of words:", "0");
    }
}