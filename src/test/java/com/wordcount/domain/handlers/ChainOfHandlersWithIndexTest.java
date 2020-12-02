package com.wordcount.domain.handlers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class ChainOfHandlersWithIndexTest {

    @Test
    void callsAllHandlerNecessaryInCorrectOrderAndReturnsResult() {
        ChainOfHandlers sut = new ChainOfHandlersWithIndex();
        List<String> wordForProcessing = asList("number allowed words in this sentence is 16 of which 14 are unique and average length is".split(" "));
        String result = sut.handle(wordForProcessing);

        assertThat(result)
                .containsSubsequence("Number of words", "unique", "average", "characters", "Index");
    }

    @Test
    void handlesEmptyListCorrectly() {
        ChainOfHandlers sut = new ChainOfHandlersWithIndex();
        String result = sut.handle(emptyList());

        assertThat(result)
                .containsSubsequence("Number of words", "0", "unique", "0", "average", "0.00", "characters", "Index");
    }
}