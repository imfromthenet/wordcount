package com.wordcount.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleReaderTest {

    @Test
    void readsFromConsoleAsString() {
        simulateUserConsoleInputOf("message");
        String actual = new ConsoleReader().read();

        assertEquals("message", actual);
    }

    private void simulateUserConsoleInputOf(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
    }
}