package com.wordcount.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class WordPreparerTest {

    private WordCollector wordCollectorMock;

    private WordPreparer sut;

    @BeforeEach
    void initialize() {
        final StopWords stopWordsMock = mock(StopWords.class);
        when(stopWordsMock.contain("a")).thenReturn(true);
        wordCollectorMock = mock(WordCollector.class);
        sut = new WordPreparer(stopWordsMock, wordCollectorMock);
    }

    @Test
    void countsMultipleWords() {
        final String input = "word word";

        sut.prepare(input);

        verify(wordCollectorMock, times(2)).collect("word");
    }

    @Test
    void splitsStringIntoWordsByNonLettersExceptAHyphen() {
        final String input = "word2word_word";

        sut.prepare(input);

        verify(wordCollectorMock, times(3)).collect("word");
    }

    @Test
    void countsHyphenSeparatedStringsAsOneWord() {
        final String input = "word-word";

        sut.prepare(input);

        verify(wordCollectorMock, times(1)).collect("word-word");
    }

    @Test
    void countsWordsThatStartWithAnUppercase() {
        final String input = "Word";

        sut.prepare(input);

        verify(wordCollectorMock, times(1)).collect("Word");
    }

    @Test
    void countsUppercaseWords() {
        final String input = "WORD";

        sut.prepare(input);

        verify(wordCollectorMock, times(1)).collect("WORD");
    }

    @Test
    void doesNotCallAnswerCollectorWhenInputIsEmpty() {
        final String input = "";

        sut.prepare(input);

        verifyNoInteractions(wordCollectorMock);
    }

    @Test
    void doesNotCallAnswerCollectorWhenInputIsWhitespace() {
        final String input = " ";

        sut.prepare(input);

        verifyNoInteractions(wordCollectorMock);
    }

    @Test
    void returnsZeroWhenInputIsSpecialCharacter() {
        final String input = "*-+/=!@#$%^&*()_`~?][|\\";

        Arrays.stream(input.split(""))
                .forEach(symbol -> {
                    sut.prepare(input);
                    verifyNoInteractions(wordCollectorMock);
                });
    }

    @Test
    void thowsNullpointerExceptionIfParameterIsNull() {
        assertThrows(NullPointerException.class, () -> sut.prepare(null));
    }

    @ParameterizedTest
    @CsvSource({".", "!", "?", ":", ";"})
    void countsWordsEndingWithAPunctuationMark(final String punctuationMark) {
        final String input = "word".concat(punctuationMark);

        sut.prepare(input);

        verify(wordCollectorMock, times(1)).collect("word");
    }

    @Test
    void filtersOutStopWords() {
        final String input = "word a";

        sut.prepare(input);

        verify(wordCollectorMock, times(1)).collect("word");
    }
}