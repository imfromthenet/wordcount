package com.wordcount;

import org.junit.jupiter.api.Test;

import static com.wordcount.WordCounter.MESSAGE_ENTER_TEXT;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class WordCounterTest {

    @Test
    void callsAllNeededMethodsWhenCorrectlySetup() {
        UIable mock = mock(UIable.class);
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
}