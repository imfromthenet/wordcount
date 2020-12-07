package com.wordcount.io;

import org.junit.jupiter.api.Test;

import static com.wordcount.AssertionHelper.assertThrowsNullPointerException;
import static org.assertj.core.api.Assertions.assertThat;

class FileInputUITest {

    @Test
    void readsFromFileAsString() {
        String expected = "one two";
        FileInputUI sut = new FileInputUI("test.txt");

        String actual = sut.getInput();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void throwsNullPointerIfFileNotFoundWhenReadAsString() {
        assertThrowsNullPointerException(() -> new FileInputUI("nonExistingFile").getInput());
    }
}