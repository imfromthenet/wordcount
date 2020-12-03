package com.wordcount.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static com.wordcount.AssertionHelper.throwsNullPointerException;
import static com.wordcount.TestUtils.getOutputRecorder;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleWriterTest {

    @Test
    void writesMessageToConsole() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();

        new ConsoleWriter().write("message");

        assertThat(outputRecorder.toString()).isEqualTo("message");
    }

    @Test
    void thowsNullpointerExceptionIfFirstParameterIsNull() {
        throwsNullPointerException(() -> new ConsoleWriter().write(null));
    }

}