package com.wordcount.io;

import org.junit.jupiter.api.Test;

import static com.wordcount.TestUtils.simulateUserConsoleInputOf;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleReaderTest {

    @Test
    void readsFromConsoleAsString() {
        simulateUserConsoleInputOf("message");
        String actual = new ConsoleReader().read();

        assertThat(actual).isEqualTo("message");
    }
}