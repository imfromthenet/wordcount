package com.wordcount.domain;

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

    @Test
    void addsAllWordsToResult() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("word word");

        assertEquals(asList("word", "word"), actual);
    }


    @Test
    void parsesWordsStartingWithAnUppercase() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("Word");

        assertEquals(singletonList("Word"), actual);
    }

    @Test
    void parsesUppercaseWords() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("WORD");

        assertEquals(singletonList("WORD"), actual);
    }

    @Test
    void returnsEmptyListIfGivenAnEmptyString() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("");

        assertEquals(emptyList(), actual);
    }

    @Test
    void returnsEmptyListIfGivenASpaceString() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse(" ");

        assertEquals(emptyList(), actual);
    }

    @Test
    void returnsZeroWhenInputIsSpecialCharacter() {
        WordParser sut = setUpWordParser();

        stream("*-+/=!@#$%^&*()_`~?][|\\".split(""))
                .forEach(symbol -> {
                    List<String> actual = sut.parse(symbol);
                    assertEquals(emptyList(), actual);
                });
    }

    @Test
    void splitsStringIntoWordsByNonLetter() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("word2word-word_word");

        assertEquals(Arrays.asList("word","word","word","word"), actual);
    }

    @Test
    void thowsNullpointerExceptionIfParameterIsNull() {
        WordParser sut = setUpWordParser();
        assertThrows(NullPointerException.class, () -> sut.parse(null));
    }

    @ParameterizedTest
    @CsvSource({".", "!", "?", ":", ";"})
    void parsesWordsEndingWithAPunctuationMark(String punctuationMark) {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("word".concat(punctuationMark));

        assertEquals(singletonList("word"), actual);
    }

    @Test
    void filtersOutStopWords() {
        WordParser sut = setUpWordParser();

        List<String> actual = sut.parse("word a");

        assertEquals(singletonList("word"), actual);
    }

    private WordParser setUpWordParser() {
        return new WordParser(getStopWordsMock());
    }

    private StopWords getStopWordsMock() {
        StopWords stopWordsMock = mock(StopWords.class);
        when(stopWordsMock.contain("a")).thenReturn(true);
        return stopWordsMock;
    }
}