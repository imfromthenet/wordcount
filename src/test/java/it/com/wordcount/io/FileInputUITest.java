package it.com.wordcount.io;

import com.wordcount.io.FileInputUI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sharedTool.TestFile;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static sharedTool.AssertionHelper.assertThrowsNullPointerException;

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
    void throwsNullPointerIfFileNotFoundWhenReadAsString() {
        assertThrowsNullPointerException(() -> new FileInputUI("nonExistingFile").getInput());
    }

    private FileInputUI getFileInputUIWith(String content) {
        TestFile file = new TestFile(tempDirectory);
        file.prepare("fileName.txt", content);
        return new FileInputUI(file.getPathAsString());
    }

}