package com.wordcount;

import com.wordcount.domain.Answer;
import com.wordcount.domain.WordCounter;
import com.wordcount.domain.Processor;
import com.wordcount.io.UIable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static com.wordcount.Application.MESSAGE_ENTER_TEXT;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ApplicationTest {

    private static UIable mockUI;
    private static Processor mockCounter;
    private static WordCounter mockCollector;

    @BeforeAll
    static void initialize() {
        mockUI = mock(UIable.class);
        mockCollector = mock(WordCounter.class);
        mockCounter = mock(Processor.class);
    }

    @Test
    void callsAllNeededMethodsOfCollaboratorsWhenCorrectlySetup() {
        final String input = "Mary had a little lamb";
        when(mockUI.getInput()).thenReturn(input);
        when(mockCollector.getAnswer()).thenReturn(new Answer(4));
        final Application sut = new Application(mockUI, mockCounter, mockCollector);

        sut.run();

        InOrder inOrder = inOrder(mockUI);
        inOrder.verify(mockUI, times(1)).displayMessage(MESSAGE_ENTER_TEXT);
        verify(mockUI, times(1)).getInput();
        verify(mockCounter, times(1)).process(input);
        inOrder.verify(mockUI, times(1)).displayMessage("Number of words: 4");

        verifyNoMoreInteractions(mockUI, mockCounter);
    }

    @Test
    void initializesOnlyWhenAllConstructorParametersArePresent() {
        assertThrows(NullPointerException.class, () -> new Application(null, mockCounter, mockCollector));
        assertThrows(NullPointerException.class, () -> new Application(mockUI, null, mockCollector));
        assertThrows(NullPointerException.class, () -> new Application(mockUI, mockCounter, null));
    }

}