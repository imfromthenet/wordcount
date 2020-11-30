package com.wordcount.io;

import org.junit.jupiter.api.Test;

import static com.wordcount.Main.STOP_WORDS_FILE;
import static com.wordcount.TestUtils.throwsNullPointerException;
import static org.assertj.core.api.Assertions.assertThat;

class FileReaderTest {

    @Test
    void readsFromFileAsString() {
        String expected = "the a on off";
        FileReader sut = new FileReader(STOP_WORDS_FILE);

        String actual = sut.read();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void throwsAnExceptionIfFileNotFoundWhenReadAsString() {
        throwsNullPointerException(() -> new FileReader("nonExistingFile").read());
    }
}