package it.com.wordcount.io;

import com.wordcount.io.FileInputUI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sharedTool.TestFile;

import java.io.ByteArrayOutputStream;
import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static sharedTool.TestUIHelper.getTestConsoleOutputRecorder;

class FileInputUITest {

    private static final String CONTENT_OF_FILE = "input from file";

    @TempDir
    File tempDirectory;

    @Test
    void readsFromFileAsString() {
        FileInputUI sut = getFileInputUIWith(CONTENT_OF_FILE);

        String actual = sut.getInput();

        assertThat(actual).isEqualTo(CONTENT_OF_FILE);
    }

    @Test
    void whenPassedFileNameIsNotFoundReturnsEmptyStringAndLogsAnErrorMessageToUser() {
        ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();
        String input = new FileInputUI("nonexistingFilename").getInput();

        assertSoftly(softly -> {
            softly.assertThat(testConsoleOutputRecorder.toString()).contains("(nonexistingFilename)");
            softly.assertThat(input).isEqualTo("");
        });
    }

    @Test
    void whenPassedNullReturnsEmptyStringAndLogsAnErrorMessageToUser() {
        ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();
        String input = new FileInputUI(null).getInput();

        assertSoftly(softly -> {
            softly.assertThat(testConsoleOutputRecorder.toString()).contains("(null)");
            softly.assertThat(input).isEqualTo("");
        });
    }

    @Test
    void whenFileIsLockedReturnsAnEmptyStringAndLogsAnErrorMessageToUser() {
        ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();

        TestFile testFile = createTestFile(CONTENT_OF_FILE);
        final String pathAsString = testFile.getPathAsString();
        lock(pathAsString);
        final String input = new FileInputUI(pathAsString).getInput();

        assertSoftly(softly -> {
            softly.assertThat(testConsoleOutputRecorder.toString()).contains(String.format("(%s)", pathAsString));
            softly.assertThat(input).isEqualTo("");
        });
        unlock(pathAsString);
    }

    private FileInputUI getFileInputUIWith(String content) {
        TestFile file = createTestFile(content);
        return new FileInputUI(file.getPathAsString());
    }

    private TestFile createTestFile(String content) {
        TestFile file = new TestFile(tempDirectory);
        file.prepare("fileName.txt", content);
        return file;
    }

    private void lock(String filePath) {
        new File(filePath).setReadable(false);
    }

    private void unlock(String filePath) {
        new File(filePath).setReadable(true);
    }

}
