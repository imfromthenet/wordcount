package it.com.wordcount.io;

import com.wordcount.io.FileInputUI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sharedTool.TestFile;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static sharedTool.AssertionHelper.assertThrowsNullPointerException;

class FileInputUITest {

    @TempDir
    File tempDirectory;

    @Test
    void readsFromFileAsString() {
        FileInputUI sut = getFileInputUI();

        String actual = sut.getInput();

        assertThat(actual).isEqualTo("input from file");
    }

    @Test
    void throwsNullPointerIfFileNotFoundWhenReadAsString() {
        assertThrowsNullPointerException(() -> new FileInputUI("nonExistingFile").getInput());
    }

    private FileInputUI getFileInputUI() {
        TestFile testFile = prepareTestFile();
        return new FileInputUI(testFile.getPathAsString());
    }

    private TestFile prepareTestFile() {
        TestFile file = new TestFile(tempDirectory);
        file.prepare("fileName.txt", "input from file");
        return file;
    }
}