package it.com.wordcount;

import com.wordcount.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sharedTool.TestFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import static it.com.wordcount.TestUIHelper.getTestConsoleOutputRecorder;
import static org.assertj.core.api.Assertions.assertThat;
import static sharedTool.AssertionHelper.assertThrowsNullPointerException;

public class MainIT {

    @TempDir
    File tempDirectory;
    private TestFile testFile;

    @BeforeEach
    void setUp() {
        testFile = new TestFile(tempDirectory);
    }

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
        prepareTestFileContaining("Mary had a little lamb");
        Main.main(new String[]{testFile.getPathAsString()});

        assertThat(testConsoleOutputRecorder.toString()).isEqualTo("Number of words: 4");
    }

    @Test
    public void throwsAnErrorIfNonexistingFilenameGiven() {
        assertThrowsNullPointerException(() -> Main.main(new String[]{"nonexistentFile.txt"}));
    }

    private void prepareTestFileContaining(String contents) {
        testFile.prepare("fileName.txt", contents);
    }
}