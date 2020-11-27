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
        StopWords stopWordsMock = mock(StopWords.class);
        when(stopWordsMock.contain("a")).thenReturn(true);
        sut = new WordParser(stopWordsMock);
    }

    @Test
    void addsAllWordsToResult() {
        String input = "word word";

        List<String> actual = sut.parse(input);

        assertEquals(asList("word", "word"), actual);
    }

    @Test
    void parsesWordsStartingWithAnUppercase() {
        String input = "Word";

        List<String> actual = sut.parse(input);

        assertEquals(singletonList("Word"), actual);
    }

    @Test
    void parsesUppercaseWords() {
        String input = "WORD";

        List<String> actual = sut.parse(input);

        assertEquals(singletonList("WORD"), actual);
    }

    @Test
    void returnsEmptyListIfGivenAnEmptyString() {
        String input = "";

        List<String> actual = sut.parse(input);

        assertEquals(emptyList(), actual);
    }

    @Test
    void returnsEmptyListIfGivenASpaceString() {
        String input = " ";

        List<String> actual = sut.parse(input);

        assertEquals(emptyList(), actual);
    }

    @Test
    void returnsZeroWhenInputIsSpecialCharacter() {
        stream("*-+/=!@#$%^&*()_`~?][|\\".split(""))
                .forEach(symbol -> {
                    List<String> actual = sut.parse(symbol);
                    assertEquals(emptyList(), actual);
                });
    }

    @Test
    void splitsStringIntoWordsByNonLetter() {
        String input = "word2word-word_word";

        List<String> actual = sut.parse(input);

        assertEquals(Arrays.asList("word","word","word","word"), actual);
    }

    @Test
    void thowsNullpointerExceptionIfParameterIsNull() {
        assertThrows(NullPointerException.class, () -> sut.parse(null));
    }

    @ParameterizedTest
    @CsvSource({".", "!", "?", ":", ";"})
    void parsesWordsEndingWithAPunctuationMark(String punctuationMark) {
        String input = "word".concat(punctuationMark);

        List<String> actual = sut.parse(input);

        assertEquals(singletonList("word"), actual);
    }

    @Test
    void filtersOutStopWords() {
        String input = "word a";

        List<String> actual = sut.parse(input);

        assertEquals(singletonList("word"), actual);
    }
}