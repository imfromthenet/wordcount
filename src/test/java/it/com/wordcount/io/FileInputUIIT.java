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

class FileInputUIIT {

    private static final String CONTENT_OF_FILE = "input from file";

    @TempDir
    File tempDirectory;
    private ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();

    @Test
    void readsFromFileAsString() {
        FileInputUI sut = getFileInputUIWith(CONTENT_OF_FILE);

        String actual = sut.getInput();

        assertThat(actual).isEqualTo(CONTENT_OF_FILE);
    }

    @Test
    void whenPassedFileNameIsNotFoundReturnsEmptyStringAndLogsAnErrorMessageToUser() {
        String input = new FileInputUI("nonexistingFilename").getInput();

        assertSoftly(softly -> {
            softly.assertThat(messageDisplayedInConsole()).contains("nonexistingFilename");
            softly.assertThat(input).isEqualTo("");
        });
    }

    @Test
    void whenPassedNullReturnsEmptyStringAndLogsAnErrorMessageToUser() {
        String input = new FileInputUI(null).getInput();

        assertSoftly(softly -> {
            softly.assertThat(messageDisplayedInConsole()).contains("null");
            softly.assertThat(input).isEqualTo("");
        });
    }

    @Test
    void whenFileIsLockedReturnsAnEmptyStringAndLogsAnErrorMessageToUser() {
        TestFile testFile = createTestFile(CONTENT_OF_FILE);
        String pathAsString = testFile.getPathAsString();
        lock(pathAsString);
        String input = new FileInputUI(pathAsString).getInput();

        assertSoftly(softly -> {
            softly.assertThat(messageDisplayedInConsole()).contains(pathAsString);
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

    private String messageDisplayedInConsole() {
        return testConsoleOutputRecorder.toString();
    }

    private void lock(String filePath) {
        new File(filePath).setReadable(false);
    }

    private void unlock(String filePath) {
        new File(filePath).setReadable(true);
    }

}
