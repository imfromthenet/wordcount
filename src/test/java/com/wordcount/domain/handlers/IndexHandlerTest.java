package com.wordcount.domain.handlers;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class IndexHandlerTest {

    @Test
    void preparesAndReturnsWordIndexInCorrectOrder() {
        Handler sut = new IndexHandler();
        String result = sut.handle(asList("Anna-Marie", "anna", "borat", "Borat"));

        assertThat(result).containsSubsequence("anna", "borat", "Anna-Marie", "Borat");
    }
}