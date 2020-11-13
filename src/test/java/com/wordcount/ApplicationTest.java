package com.wordcount;

import com.wordcount.domain.Answer;
import com.wordcount.domain.InputPreparer;
import com.wordcount.domain.Processor;
import com.wordcount.domain.WordCounter;
import com.wordcount.io.console.Writer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationTest {
    private static InputPreparer mockInputPreparer;
    private static Processor mockProcessor;
    private static WordCounter mockCounter;
    private static Writer mockWriter;

    @BeforeAll
    static void initialize() {
        mockInputPreparer = mock(InputPreparer.class);
        mockProcessor = mock(Processor.class);
        mockCounter = mock(WordCounter.class);
        mockWriter = mock(Writer.class);
    }

//    needs to be duplicated for a case with an argument and without
    @Test
    void callsAllNeededMethodsOfCollaboratorsWhenCorrectlySetup() {
        final String input = "Mary had a little lamb";
        String[] emptyArray = {};
        when(mockInputPreparer.getInput(emptyArray)).thenReturn(input);
        when(mockCounter.getAnswer()).thenReturn(new Answer(4));
        final Application sut = new Application(mockInputPreparer, mockProcessor, mockCounter, emptyArray, mockWriter);

        sut.run();

//        InOrder inOrder = inOrder(mockUI);
//        inOrder.verify(mockUI, times(1)).displayMessage(MESSAGE_ENTER_TEXT);
//        verify(mockUI, times(1)).getInput();
//        verify(mockProcessor, times(1)).process(input);
//        inOrder.verify(mockUI, times(1)).displayMessage("Number of words: 4");
//
//        verifyNoMoreInteractions(mockUI, mockProcessor);
    }

//    @Test
//    void initializesOnlyWhenAllConstructorParametersArePresent() {
//        assertThrows(NullPointerException.class, () -> new Application(null, mockCounter, mockCollector, args, ));
//        assertThrows(NullPointerException.class, () -> new Application(mockUI, null, mockCollector, args));
//        assertThrows(NullPointerException.class, () -> new Application(mockUI, mockCounter, null, args));
//    }

}