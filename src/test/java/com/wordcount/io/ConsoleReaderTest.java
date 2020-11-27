package com.wordcount.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleReaderTest {

    private Reader sut = new ConsoleReader();
    private InputStream standardIn = System.in;
    private ByteArrayInputStream inputStreamCaptor = new ByteArrayInputStream("message".getBytes());

    @BeforeEach
    public void setUp() {
        System.setIn(inputStreamCaptor);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(standardIn);
    }

    @Test
    void readsFromConsoleAsString() {
        String actual = sut.read();

        assertEquals("message", actual);
    }
}