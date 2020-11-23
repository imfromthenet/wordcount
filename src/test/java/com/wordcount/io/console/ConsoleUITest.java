package com.wordcount.io.console;

import com.wordcount.io.ui.ConsoleUI;
import com.wordcount.util.ConsoleReader;
import com.wordcount.util.ConsoleWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUITest {

    private final String MESSAGE = "message";

    private final ConsoleUI sut = new ConsoleUI(ConsoleWriter.getInstance(), ConsoleReader.getInstance());

    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;
    private final ByteArrayInputStream inputStreamCaptor = new ByteArrayInputStream(MESSAGE.getBytes());
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(inputStreamCaptor);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    void requestsAndGetsInputViaConsole() {
        assertEquals(MESSAGE, sut.getInput());
    }
}