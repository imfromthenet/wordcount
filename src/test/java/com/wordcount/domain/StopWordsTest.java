package com.wordcount.domain;

import org.junit.jupiter.api.Test;

import static com.wordcount.TestUtils.throwsNullPointerException;
import static org.assertj.core.api.Assertions.assertThat;

class StopWordsTest {

    @Test
    void tellsIfAWordIsInStopWords() {
        StopWords sut = new StopWords("a");

        assertThat(sut.contain("a")).isTrue();
    }

    @Test
    void tellsIfAWordIsNotInStopWords() {
        StopWords sut = new StopWords("a");

        assertThat(sut.contain("b")).isFalse();
    }

    @Test
    void requiresStopWordsToBeNonNull() {
        throwsNullPointerException(() -> new StopWords(null));
    }
}