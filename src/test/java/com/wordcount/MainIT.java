package com.wordcount;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainIT {

    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    public void applicationProcessesInputCorrectlyAndReturnsCorrectResult() {
        System.setIn(new ByteArrayInputStream(("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getBytes()));

        Main.main(new String[]{});

        String actual = outputStreamCaptor.toString();
        assertEquals("Enter text: Number of words: 7, unique: 6; average word length: 6.43 characters", actual);
    }

    @Test
    public void canUseCommandLineArgumentsToGetTheInputData() {
        Main.main(new String[]{"mytext.txt"});

        String actual = outputStreamCaptor.toString();
        assertEquals("Number of words: 4, unique: 4; average word length: 4.25 characters", actual);
    }

    @Test
    public void throwsAnErrorIfNonexistingFilenameGiven() {
        assertThrows(RuntimeException.class, () -> Main.main(new String[]{"nonexistentFile.txt"}));
    }
}
