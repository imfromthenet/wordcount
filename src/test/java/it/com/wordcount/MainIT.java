package it.com.wordcount;

import com.wordcount.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sharedTool.TestFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static sharedTool.TestUIHelper.getTestConsoleOutputRecorder;

class MainIT {

    TestFile testFile;
    ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();

    @TempDir
    File tempDirectory;

    @BeforeEach
    void setUp() {
        testFile = new TestFile(tempDirectory);
    }

    @Test
    void applicationProcessesInputCorrectlyAndReturnsCorrectResult() {
        System.setIn(new ByteArrayInputStream(("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getBytes()));

        Main.main(new String[]{});

        assertThat(messageDisplayedInConsole()).isEqualTo("Enter text: Number of words: 9, unique: 7");
    }

    @Test
    void canUseCommandLineArgumentsToGetTheInputData() {
        prepareTestFileContaining("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        Main.main(new String[]{testFile.getPathAsString()});

        assertThat(messageDisplayedInConsole()).isEqualTo("Number of words: 9, unique: 7");
    }

    @Test
    void whenThereAreProblemsReadingAFileReturnsAndEmptyStringInsteadOfTheContentsOfTheFileAndDisplaysAnErrorMessageToUser() {
        Main.main(new String[]{"nonexistentFile.txt"});

        assertThat(messageDisplayedInConsole())
                .contains("The path (nonexistentFile.txt) was not able to be read. Instead, an empty string is passed as input.")
                .contains("Number of words: 0");
    }

    private String messageDisplayedInConsole() {
        return testConsoleOutputRecorder.toString();
    }

    private void prepareTestFileContaining(String contents) {
        testFile.prepare("fileName.txt", contents);
    }
}