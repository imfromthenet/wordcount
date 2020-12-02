package com.wordcount.domain.handlers;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class UniqueWordsCountHandlerTest {

    @Test
    void preparesAndReturnsUniqueWordCount() {
        Handler sut = new UniqueWordsCountHandler();
        String result = sut.handle(asList("anna", "anna", "borat"));

        assertThat(result).containsSubsequence("unique", "2");
    }

    @Test
    void returnsCountOfZeroWhenInputIsEmpty() {
        Handler sut = new UniqueWordsCountHandler();
        String result = sut.handle(emptyList());

        assertThat(result).containsSubsequence("unique", "0");
    }
}