package com.wordcount.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleUITest {

    private final UIable sut = new ConsoleUI();
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
    void displaysMessageToConsole() {
        sut.displayMessage("message");

        assertEquals("message", outputStreamCaptor.toString());
    }

    @Test
    void thowsNullpointerExceptionIfMessageIsNull() {
        assertThrows(NullPointerException.class, () -> sut.displayMessage(null));
    }

    @Test
    void getsTypedUserInputFromConsole() {
        String expected = "word w2rd";
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        final String actual = sut.getInput();

        assertEquals(actual, expected);
    }
}