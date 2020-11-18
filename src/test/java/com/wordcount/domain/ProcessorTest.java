package com.wordcount.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ProcessorTest {

    private WordCounter wordCounterMock;

    @BeforeEach
    void initialize() {
        final StopWords stopWordsMock = mock(StopWords.class);
        when(stopWordsMock.contain("a")).thenReturn(true);
        wordCounterMock = mock(WordCounter.class);
        sut = new Processor(stopWordsMock, wordCounterMock);
    }

    private Processor sut;

    @Test
    void countsMultipleWords() {
        final String input = "word word";

        sut.process(input);

        verify(wordCounterMock, times(2)).collect("word");
    }

    @Test
    void countsWordsThatStartWithAnUppercase() {
        final String input = "Word";

        sut.process(input);

        verify(wordCounterMock, times(1)).collect("Word");
    }

    @Test
    void countsUppercaseWords() {
        final String input = "WORD";

        sut.process(input);

        verify(wordCounterMock, times(1)).collect("WORD");
    }

    @Test
    void doesNotCallAnswerCollectorWhenInputIsEmpty() {
        final String input = "";

        sut.process(input);

        verifyNoInteractions(wordCounterMock);
    }

    @Test
    void doesNotCallAnswerCollectorWhenInputIsWhitespace() {
        final String input = " ";

        sut.process(input);

        verifyNoInteractions(wordCounterMock);
    }

    @Test
    void returnsZeroWhenInputIsSpecialCharacter() {
        final String input = "*-+/=!@#$%^&*()_`~?][|\\";

        Arrays.stream(input.split(""))
                .forEach(symbol -> {
                    sut.process(input);
                    verifyNoInteractions(wordCounterMock);
                });
    }

    @Test
    void thowsNullpointerExceptionIfParameterIsNull() {
        assertThrows(NullPointerException.class, () -> sut.process(null));
    }

    @ParameterizedTest
    @CsvSource({".", "!", "?", ":", ";"})
    void countsWordsEndingWithAPunctuationMark(final String punctuationMark) {
        final String input = "word".concat(punctuationMark);

        sut.process(input);

        verify(wordCounterMock, times(1)).collect("word");
    }

    @Test
    void filtersOutStopWords() {
        final String input = "word a";

        sut.process(input);

        verify(wordCounterMock, times(1)).collect("word");
    }
}