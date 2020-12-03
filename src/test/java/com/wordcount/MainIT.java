package com.wordcount;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static com.wordcount.AssertionHelper.assertThrowsNullPointerException;
import static com.wordcount.TestUIHelper.getTestConsoleOutputRecorder;
import static org.assertj.core.api.Assertions.assertThat;

public class MainIT {

    @Test
    public void applicationProcessesInputCorrectlyAndReturnsCorrectResult() {
        ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();
        System.setIn(new ByteArrayInputStream(("Mary had a little lamb").getBytes()));

        Main.main(new String[]{});

        assertThat(testConsoleOutputRecorder.toString()).isEqualTo("Enter text: Number of words: 4");
    }

    @Test
    public void canUseCommandLineArgumentsToGetTheInputData() {
        ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();
        Main.main(new String[]{"mytext.txt"});

        assertThat(testConsoleOutputRecorder.toString()).isEqualTo("Number of words: 4");
    }

    @Test
    public void throwsAnErrorIfNonexistingFilenameGiven() {
        assertThrowsNullPointerException(() -> Main.main(new String[]{"nonexistentFile.txt"}));
    }
}