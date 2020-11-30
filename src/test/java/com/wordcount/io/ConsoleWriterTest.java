package com.wordcount.io;

import com.wordcount.TestUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleWriterTest {

    @Test
    void writesMessageToConsole() {
        ByteArrayOutputStream outputRecorder = TestUtils.getOutputRecorder();

        new ConsoleWriter().write("message");

        assertEquals("message", outputRecorder.toString());
    }

    @Test
    void thowsNullpointerExceptionIfFirstParameterIsNull() {
        assertThrows(NullPointerException.class, () -> new ConsoleWriter().write(null));
    }

}