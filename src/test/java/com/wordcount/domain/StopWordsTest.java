package com.wordcount.domain;

import com.wordcount.io.util.FileReader;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StopWordsTest {

    @Test
    void tellsIfAWordIsContainedInTheStopWordsList() {
        FileReader readerMock = mock(FileReader.class);
        when(readerMock.read(anyString())).thenReturn(singletonList("a"));
        StopWords sut = new StopWords(readerMock);

        sut.fillFrom(anyString());

        assertTrue(sut.contain("a"));
    }

    @Test
    void throwsNullpointerIfReaderIsNull() {
        assertThrows(NullPointerException.class, () -> new StopWords(null));
    }
}