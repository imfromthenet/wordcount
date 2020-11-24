package com.wordcount.domain;

import com.wordcount.io.UI;
import com.wordcount.io.console.Writer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class WordCounterAppTest {

    @Test
    void delegatesWorkToCollaboratorsAndThoseWorkAsTheyShould() {
        final UI mockUI = mock(UI.class);
        when(mockUI.getInput()).thenReturn("test a t2st");
        final Writer mockWriter = mock(Writer.class);
        final StopWords mockStopWords = mock(StopWords.class);
        when(mockStopWords.contain("a")).thenReturn(true);
        final WordCounterApp sut = new WordCounterApp(mockUI, mockWriter, mockStopWords);

        sut.countWords();

        verify(mockWriter, times(1)).write("Number of words: 1");
    }
}
