package com.wordcount.io;

import org.junit.jupiter.api.Test;

import static com.wordcount.TestUtils.simulateUserConsoleInputOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleReaderTest {

    @Test
    void readsFromConsoleAsString() {
        simulateUserConsoleInputOf("message");
        String actual = new ConsoleReader().read();

        assertEquals("message", actual);
    }
}