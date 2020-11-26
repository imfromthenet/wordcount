package com.wordcount.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleReaderTest {

    private final Reader sut = new ConsoleReader();
    private final InputStream standardIn = System.in;
    private final ByteArrayInputStream inputStreamCaptor = new ByteArrayInputStream("message".getBytes());

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
        final String actual = sut.read();

        assertEquals("message", actual);
    }

    @Test
    void readsFromConsoleAsList() {
        final List<String> actual = sut.readAsList();

        assertEquals(singletonList("message"), actual);
    }
}