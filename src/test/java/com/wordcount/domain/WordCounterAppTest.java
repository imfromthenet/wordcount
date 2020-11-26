package com.wordcount.domain;

import com.wordcount.io.ui.UI;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class WordCounterAppTest {

    @Test
    void delegatesWorkToCollaboratorsAndThoseWorkAsTheyShould() {
        final UI mockUI = mock(UI.class);
        when(mockUI.getInput()).thenReturn("test a t2st");
        final StopWords mockStopWords = mock(StopWords.class);
        when(mockStopWords.contain("a")).thenReturn(true);
        final WordCounterApp sut = new WordCounterApp(mockUI, mockStopWords);

        sut.countWords();

        verify(mockUI, times(1)).write("Number of words: 1");
    }
}
