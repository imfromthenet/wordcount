package com.wordcount.io;

import org.junit.jupiter.api.Test;

import static com.wordcount.AssertionHelper.assertThrowsNullPointerException;
import static org.assertj.core.api.Assertions.assertThat;

class FileReaderTest {

    @Test
    void readsFromFileAsString() {
        String expected = "one two";
        FileReader sut = new FileReader("test.txt");

        String actual = sut.read();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void throwsNullPointerIfFileNotFoundWhenReadAsString() {
        assertThrowsNullPointerException(() -> new FileReader("nonExistingFile").read());
    }
}