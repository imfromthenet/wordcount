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
        Application sut = new Application(mock, new WordCounter());

        sut.run();

        verify(mock, times(1)).displayMessage(MESSAGE_ENTER_TEXT);
        verify(mock, times(1)).getInput();
        verify(mock, times(1)).displayMessage(MESSAGE_NUMBER_OF_WORDS + 5);

//        TODO: replace wordCounter with mock and mock results

        verifyNoMoreInteractions(mock);
    }

    @Test
    void throwsNullpointerIfParameterIsNull() {
        assertThrows(NullPointerException.class, () -> new Application(null, new WordCounter()));
    }

}