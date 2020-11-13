package com.wordcount.io.file;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.wordcount.Main.STOP_WORDS_FILE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileNoIFileReaderTest {

    public final FileReader sut = new FileReader();

    @Test
    void readsAllTheStopWords() {
        final List<String> expected = Arrays.asList("the", "a", "on", "off");

        final List<String> actual = sut.read(STOP_WORDS_FILE);

        assertEquals(expected, actual);
    }

    @Test
    void throwsAnExceptionIfFileNotFound() {
        assertThrows(RuntimeException.class, () -> sut.read("nonExistingFile"));
    }
}