package com.wordcount.domain;

import com.wordcount.io.console.Writer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class WordCounterAppTest {

    @Test
    void delegatesWorkToCollaboratorsAndThoseWorkAsTheyShould() {
        final String input = "test2test toast taste a";
        final Writer mockWriter = mock(Writer.class);
        final StopWords mockStopWords = mock(StopWords.class);
        when(mockStopWords.contain("a")).thenReturn(true);
        final WordCounterApp sut = new WordCounterApp(input, mockWriter, mockStopWords);

        sut.countWords();

        verify(mockWriter, times(1)).write("Number of words: 4, unique: 3");
    }
}
