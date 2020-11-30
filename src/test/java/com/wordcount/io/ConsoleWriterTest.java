package com.wordcount.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleWriterTest {

    @Test
    void writesMessageToConsole() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();

        new ConsoleWriter().write("message");

        assertEquals("message", outputRecorder.toString());
    }

    @Test
    void thowsNullpointerExceptionIfFirstParameterIsNull() {
        assertThrows(NullPointerException.class, () -> new ConsoleWriter().write(null));
    }

    private ByteArrayOutputStream getOutputRecorder() {
        ByteArrayOutputStream outputRecorder = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputRecorder));
        return outputRecorder;
    }
}