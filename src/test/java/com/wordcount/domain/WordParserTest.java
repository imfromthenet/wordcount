package com.wordcount.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WordParserTest {

    private WordParser sut;

    @BeforeEach
    void initialize() {
        final StopWords stopWordsMock = mock(StopWords.class);
        when(stopWordsMock.contain("a")).thenReturn(true);
        sut = new WordParser(stopWordsMock);
    }

    @Test
    void addsAllWordsToResult() {
        final String input = "word word";

        final List<String> actual = sut.parse(input);

        assertEquals(asList("word", "word"), actual);
    }

    @Test
    void parsesWordsStartingWithAnUppercase() {
        final String input = "Word";

        final List<String> actual = sut.parse(input);

        assertEquals(singletonList("Word"), actual);
    }

    @Test
    void parsesUppercaseWords() {
        final String input = "WORD";

        final List<String> actual = sut.parse(input);

        assertEquals(singletonList("WORD"), actual);
    }

    @Test
    void returnsEmptyListIfGivenAnEmptyString() {
        final String input = "";

        final List<String> actual = sut.parse(input);

        assertEquals(emptyList(), actual);
    }

    @Test
    void returnsEmptyListIfGivenASpaceString() {
        final String input = " ";

        final List<String> actual = sut.parse(input);

        assertEquals(emptyList(), actual);
    }

    @Test
    void returnsZeroWhenInputIsSpecialCharacter() {
        stream("*-+/=!@#$%^&*()_`~?][|\\".split(""))
                .forEach(symbol -> {
                    final List<String> actual = sut.parse(symbol);
                    assertEquals(emptyList(), actual);
                });
    }

    @Test
    void splitsStringIntoWordsByNonLetter() {
        final String input = "word2word-word_word";

        final List<String> actual = sut.parse(input);

        assertEquals(Arrays.asList("word","word-word","word"), actual);
    }

    @Test
    void thowsNullpointerExceptionIfParameterIsNull() {
        assertThrows(NullPointerException.class, () -> sut.parse(null));
    }

    @ParameterizedTest
    @CsvSource({".", "!", "?", ":", ";"})
    void parsesWordsEndingWithAPunctuationMark(final String punctuationMark) {
        final String input = "word".concat(punctuationMark);

        final List<String> actual = sut.parse(input);

        assertEquals(singletonList("word"), actual);
    }

    @Test
    void filtersOutStopWords() {
        final String input = "word a";

        final List<String> actual = sut.parse(input);

        assertEquals(singletonList("word"), actual);
    }
}