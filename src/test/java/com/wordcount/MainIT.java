package com.wordcount;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static com.wordcount.AssertionHelper.throwsNullPointerException;
import static com.wordcount.TestUIHelper.getOutputRecorder;
import static org.assertj.core.api.Assertions.assertThat;

public class MainIT {

    @Test
    public void applicationProcessesInputCorrectlyAndReturnsCorrectResult() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        System.setIn(new ByteArrayInputStream(("Mary had a little lamb").getBytes()));

        Main.main(new String[]{});

        assertThat(outputRecorder.toString()).isEqualTo("Enter text: Number of words: 4");
    }

    @Test
    public void canUseCommandLineArgumentsToGetTheInputData() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        Main.main(new String[]{"mytext.txt"});

        assertThat(outputRecorder.toString()).isEqualTo("Number of words: 4");
    }

    @Test
    public void throwsAnErrorIfNonexistingFilenameGiven() {
        throwsNullPointerException(() -> Main.main(new String[]{"nonexistentFile.txt"}));
    }
}