package com.wordcount.domain;

import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StopWordsTest {

    @Test
    void tellsIfAWordIsContainedInTheStopWordsList() {
        final StopWords sut = new StopWords(singletonList("a"));

        assertTrue(sut.contain("a"));
    }
}