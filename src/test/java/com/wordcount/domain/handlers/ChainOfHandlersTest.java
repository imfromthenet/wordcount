package com.wordcount.domain.handlers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class ChainOfHandlersTest {

    @Test
    void callsAllHandlerNecessaryInCorrectOrderAndReturnsResult() {
        ChainOfHandlers sut = new ChainOfHandlers.Core();
        List<String> wordForProcessing = asList("number allowed words in this sentence is 16 of which 14 are unique and average length is".split(" "));
        String result = sut.handle(wordForProcessing);

        assertThat(result)
                .containsSubsequence("Number of words", "unique", "average", "characters")
                .doesNotContain("Index");
    }
}