package com.wordcount;

import org.junit.jupiter.api.Test;

import static com.wordcount.WordCounter.MESSAGE_ENTER_TEXT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class WordCounterTest {

    @Test
    void callsAllNeededMethodsOfCollaboratorsWhenCorrectlySetup() {
        UIable mock = mock(UIable.class);
        when(mock.getInput()).thenReturn("Mary had a little lamb");
        WordCounter sut = new WordCounter(mock);

        sut.run();

        verify(mock, times(1)).displayMessage(MESSAGE_ENTER_TEXT);
        verify(mock, times(1)).getInput();
        verifyNoMoreInteractions(mock);
    }

    @Test
    void throwsNullpointerIfParameterIsNull() {
        assertThrows(NullPointerException.class, () -> new WordCounter(null));
    }

    @Test
    void countsPlainWordsCorrectly() {
        UIable mock = mock(UIable.class);
        WordCounter sut = new WordCounter(mock);

        final String input = "word word";
        int expected = 2;
        int actual = sut.calculate(input);

        assertEquals(expected, actual);
    }
}