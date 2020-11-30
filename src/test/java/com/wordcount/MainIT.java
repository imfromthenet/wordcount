package com.wordcount;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainIT {

    @Test
    public void applicationProcessesInputCorrectlyAndReturnsCorrectResult() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        System.setIn(new ByteArrayInputStream(("Mary had a little lamb").getBytes()));

        Main.main(new String[]{});

        assertEquals("Enter text: Number of words: 4", outputRecorder.toString());
    }

    @Test
    public void canUseCommandLineArgumentsToGetTheInputData() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        Main.main(new String[]{"mytext.txt"});

        assertEquals("Number of words: 4", outputRecorder.toString());
    }

    @Test
    public void throwsAnErrorIfNonexistingFilenameGiven() {
        assertThrows(RuntimeException.class, () -> Main.main(new String[]{"nonexistentFile.txt"}));
    }

    private ByteArrayOutputStream getOutputRecorder() {
        ByteArrayOutputStream outputRecorder = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputRecorder));
        return outputRecorder;
    }
}
