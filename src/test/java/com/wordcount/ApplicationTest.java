package com.wordcount;

import org.junit.jupiter.api.Test;

import static com.wordcount.Application.MESSAGE_ENTER_TEXT;
import static com.wordcount.Application.MESSAGE_NUMBER_OF_WORDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ApplicationTest {

    @Test
    void callsAllNeededMethodsOfCollaboratorsWhenCorrectlySetup() {
        UIable mock = mock(UIable.class);
        when(mock.getInput()).thenReturn("Mary had a little lamb");
        Application sut = new Application(mock);

        sut.run();

        verify(mock, times(1)).displayMessage(MESSAGE_ENTER_TEXT);
        verify(mock, times(1)).getInput();
        verify(mock, times(1)).displayMessage(MESSAGE_NUMBER_OF_WORDS + 5);
        verifyNoMoreInteractions(mock);
    }

    @Test
    void throwsNullpointerIfParameterIsNull() {
        assertThrows(NullPointerException.class, () -> new Application(null));
    }

    @Test
    void countsPlainWordsCorrectly() {
        UIable mock = mock(UIable.class);
        Application sut = new Application(mock);

        final String input = "word word";
        int expected = 2;
        int actual = sut.calculate(input);

        assertEquals(expected, actual);
    }
}