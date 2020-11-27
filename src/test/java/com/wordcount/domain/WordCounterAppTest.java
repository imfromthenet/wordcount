package com.wordcount.domain;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class WordCounterAppTest {

    @Test
    void delegatesWorkToCollaboratorsAndThoseWorkAsTheyShould() {
        UI mockUI = mock(UI.class);
        when(mockUI.getUserInput()).thenReturn("a t2st");
        StopWords mockStopWords = mock(StopWords.class);
        when(mockStopWords.contain("a")).thenReturn(true);
        WordCounterApp sut = new WordCounterApp(mockUI, mockStopWords);

        sut.countWords();

        verify(mockUI, times(1)).show("Number of words: 2");
    }
}
