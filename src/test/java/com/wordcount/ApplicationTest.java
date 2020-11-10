package com.wordcount;

import com.wordcount.io.ConsoleUI;
import com.wordcount.io.UIable;
import com.wordcount.domain.WordCounter;
import org.junit.jupiter.api.Test;

import static com.wordcount.Application.MESSAGE_ENTER_TEXT;
import static com.wordcount.Application.MESSAGE_NUMBER_OF_WORDS;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ApplicationTest {

    @Test
    void callsAllNeededMethodsOfCollaboratorsWhenCorrectlySetup() {
        UIable uiMock = mock(UIable.class);
        final String input = "Mary had a little lamb";
        when(uiMock.getInput()).thenReturn(input);

        WordCounter counterMock = mock(WordCounter.class);
        when(counterMock.count(input)).thenReturn(4);
        Application sut = new Application(uiMock, counterMock);

        sut.run();

        verify(uiMock, times(1)).displayMessage(MESSAGE_ENTER_TEXT);
        verify(uiMock, times(1)).getInput();
        verify(counterMock, times(1)).count(input);
        verify(uiMock, times(1)).displayMessage(MESSAGE_NUMBER_OF_WORDS + 4);

        verifyNoMoreInteractions(uiMock, counterMock);
    }

    @Test
    void throwsNullpointerIfParameterIsNull() {
        assertThrows(NullPointerException.class, () -> new Application(null, new WordCounter(emptyList())));
        assertThrows(NullPointerException.class, () -> new Application(new ConsoleUI(), null));
    }

}