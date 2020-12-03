package com.wordcount.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static com.wordcount.AssertionHelper.assertThrowsNullPointerException;
import static com.wordcount.TestUIHelper.getTestConsoleOutputRecorder;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleWriterTest {

    @Test
    void writesMessageToConsole() {
        ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();

        new ConsoleWriter().write("message");

        assertThat(testConsoleOutputRecorder.toString()).isEqualTo("message");
    }

    @Test
    void thowsNullpointerExceptionIfFirstParameterIsNull() {
        assertThrowsNullPointerException(() -> new ConsoleWriter().write(null));
    }

}