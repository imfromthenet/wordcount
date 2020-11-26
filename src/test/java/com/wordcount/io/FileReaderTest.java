package com.wordcount.io;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.wordcount.Main.STOP_WORDS_FILE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {

    @Test
    void readsFromFileAsList() {
        final List<String> resultJoined = Arrays.asList("the", "a", "on", "off");
        final FileReader sut = new FileReader(STOP_WORDS_FILE);

        final List<String> actual = sut.readAsList();

        assertEquals(resultJoined, actual);
    }

    @Test
    void readsFromFileAsString() {
        final String expected = "the a on off";
        final FileReader sut = new FileReader(STOP_WORDS_FILE);

        final String actual = sut.read();

        assertEquals(expected, actual);
    }

    @Test
    void throwsAnExceptionIfFileNotFoundWhenReadAsList() {
        assertThrows(RuntimeException.class, () -> new FileReader("nonExistingFile").readAsList());
    }

    @Test
    void throwsAnExceptionIfFileNotFoundWhenReadAsString() {
        assertThrows(RuntimeException.class, () -> new FileReader("nonExistingFile").read());
    }
}