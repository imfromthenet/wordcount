package com.wordcount.io.console;

import com.wordcount.io.util.ConsoleWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleWriterTest {

    private final ConsoleWriter sut = ConsoleWriter.getInstance();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void writesMessageToConsole() {
        sut.write("message");

        assertEquals("message", outputStreamCaptor.toString());
    }
}