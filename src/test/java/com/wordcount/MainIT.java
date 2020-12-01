package com.wordcount;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static com.wordcount.TestUtils.getOutputRecorder;
import static com.wordcount.TestUtils.throwsNullPointerException;
import static org.assertj.core.api.Assertions.assertThat;

public class MainIT {

    @Test
    public void applicationProcessesInputCorrectlyAndReturnsCorrectResult() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        System.setIn(new ByteArrayInputStream(("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getBytes()));

        Main.main(new String[]{});

        assertThat(outputRecorder.toString()).isEqualTo("Enter text: Number of words: 7, unique: 6; average word length: 6.43 characters");
    }

    @Test
    public void canUseCommandLineArgumentsToGetTheInputData() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        Main.main(new String[]{"test_longer.txt"});

        assertThat(outputRecorder.toString()).isEqualTo("Number of words: 16, unique: 14; average word length: 4.38 characters");
    }

    @Test
    public void showsWordIndexAfterReceivingIndexFlagAndUserInputViaConsole() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        System.setIn(new ByteArrayInputStream(("Mary had a little lamb").getBytes()));

        Main.main(new String[]{"-index"});

        assertThat(outputRecorder.toString()).isEqualTo(
                "Enter text: Number of words: 4, unique: 4; average word length: 4.25 characters\n" +
                " \n" +
                "Index:\n" +
                " \n" +
                "had\n" +
                " \n" +
                "lamb\n" +
                " \n" +
                "little\n" +
                " \n" +
                "Mary");
    }

    @Test
    public void showsWordIndexAfterReceivingIndexFlagAndUserInputViaFile() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        Main.main(new String[]{"-index", "mytext.txt"});

        assertThat(outputRecorder.toString()).isEqualTo(
                "Number of words: 4, unique: 4; average word length: 4.25 characters\n" +
                " \n" +
                "Index:\n" +
                " \n" +
                "had\n" +
                " \n" +
                "lamb\n" +
                " \n" +
                "little\n" +
                " \n" +
                "Mary");
    }

    @Test
    public void throwsAnErrorIfNonexistingFilenameGiven() {
        throwsNullPointerException(() -> Main.main(new String[]{"nonexistentFile.txt"}));
    }
}