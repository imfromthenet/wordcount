package com.wordcount.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static com.wordcount.TestUtils.getOutputRecorder;
import static com.wordcount.TestUtils.throwsNullPointerException;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleWriterTest {

    @Test
    void writesMessageToConsole() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();

        new ConsoleWriter().write("message");

        assertThat(outputRecorder.toString()).isEqualTo("message");
    }

    @Test
    void requiresParameterToBeNonNull() {
        throwsNullPointerException(() -> new ConsoleWriter().write(null));
    }
}