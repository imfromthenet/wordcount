package com.wordcount.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StopWordsTest {

    @Test
    void tellsIfAWordIsInStopWords() {
        StopWords sut = new StopWords("a");

        assertTrue(sut.contain("a"));
    }

    @Test
    void tellsIfAWordIsNotInStopWords() {
        StopWords sut = new StopWords("a");

        assertFalse(sut.contain("b"));
    }
}