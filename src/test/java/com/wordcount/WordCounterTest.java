package com.wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    @Test
    void countsPlainWordsCorrectly() {
        WordCounter sut = new WordCounter();
        final String input = "word word";
        int expected = 2;

        int actual = sut.count(input);

        assertEquals(expected, actual);
    }
}