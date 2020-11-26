package com.wordcount;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static com.wordcount.domain.Result.MESSAGE_NUMBER_OF_WORDS;
import static com.wordcount.domain.Result.MESSAGE_UNIQUE_WORDS;
import static com.wordcount.io.ui.ConsoleUI.MESSAGE_ENTER_TEXT;
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
    public void returnsRegularCountAndUniqueWordCountWhenReadingFromConsole() {
        System.setIn(new ByteArrayInputStream(("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getBytes()));

        Main.main(new String[]{});

        String actual = outputStreamCaptor.toString();
        assertEquals(MESSAGE_ENTER_TEXT + MESSAGE_NUMBER_OF_WORDS + "9" + MESSAGE_UNIQUE_WORDS + "7", actual);
    }

    @Test
    public void returnsRegularCountAndUniqueWordCountWhenReadingFromFile() {
        Main.main(new String[]{"mytext.txt"});

        String actual = outputStreamCaptor.toString();
        assertEquals(MESSAGE_NUMBER_OF_WORDS + "4" + MESSAGE_UNIQUE_WORDS + "4", actual);
    }

    @Test
    public void throwsAnErrorIfNonexistingFilenameGiven() {
        assertThrows(RuntimeException.class, () -> Main.main(new String[]{"nonexistentFile.txt"}));
    }
}
