package com.wordcount.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class WordCounterTest {

    StopWords stopWords = initializeMockStopWordsWithOneWord();

    private StopWords initializeMockStopWordsWithOneWord() {
        final StopWords mock = mock(StopWords.class);
        when(mock.contain("a")).thenReturn(true);
        return mock;
    }

    private final WordCounter sut = new WordCounter(stopWords);

    @Test
    void countsMultipleWords() {
        final String input = "word word";
        int expected = 2;

        int actual = sut.count(input);

        assertEquals(expected, actual);
    }

    @Test
    void countsWordsThatStartWithAnUppercase() {
        final String input = "Word";
        int expected = 1;

        int actual = sut.count(input);

        assertEquals(expected, actual);
    }

    @Test
    void countsUppercaseWords() {
        final String input = "WORD";
        int expected = 1;

        int actual = sut.count(input);

        assertEquals(expected, actual);
    }

    @Test
    void returnsZeroWhenInputIsEmpty() {
        final String input = "";
        int expected = 0;

        int actual = sut.count(input);

        assertEquals(expected, actual);
    }

    @Test
    void returnsZeroWhenInputIsWhitespace() {
        final String input = " ";
        int expected = 0;

        int actual = sut.count(input);

        assertEquals(expected, actual);
    }

    @Test
    void returnsZeroWhenInputIsCharacter() {
        final String input = "*-+/=!@#$%^&*()_`~?][|\\";
        int expected = 0;
        Arrays.stream(input.split(""))
                .forEach(symbol -> {
            int actual = sut.count(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    void returnsZeroWhenInputStringDoesNotMeetDefinitionOfAWord() {
        final String input = "w0rd";
        int expected = 0;

        int actual = sut.count(input);

        assertEquals(expected, actual);
    }

    @Test
    void thowsNullpointerExceptionIfParameterIsNull() {
        assertThrows(NullPointerException.class, () -> sut.count(null));
    }

    @ParameterizedTest
    @CsvSource({".", "!", "?", ":", ";"})
    void countsWordsEndingWithAPunctuationMark(final String punctuationMark) {
        final String input = "word".concat(punctuationMark);
        int expected = 1;

        int actual = sut.count(input);

        assertEquals(expected, actual);
    }

    @Test
    void filtersOutStopWords() {
        final String input = "word a";
        int expected = 1;

        int actual = sut.count(input);

        assertEquals(expected, actual);
    }
}