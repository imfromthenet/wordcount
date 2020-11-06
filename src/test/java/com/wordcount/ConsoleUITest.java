package com.wordcount;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleUITest {

    private UIable sut;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        sut = new ConsoleUI();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void displayMessageToConsole() {
        sut.displayMessage("message");

        assertEquals("message", outputStreamCaptor.toString());
    }

    @Test
    void thowsNullpointerExceptionIfMessageIsNull() {
        assertThrows(NullPointerException.class, () -> sut.displayMessage(null));
    }

}