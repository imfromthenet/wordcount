package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.FileReader;
import com.wordcount.io.Reader;
import com.wordcount.io.Writer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static com.wordcount.AssertionHelper.assertThrowsNullPointerException;
import static com.wordcount.TestUIHelper.getTestConsoleOutputRecorder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class ConsoleWriterFileReaderUIIT {
    ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();
    Writer ignoreWriter = mock(Writer.class);
    Reader ignoreReader = mock(Reader.class);

    @TempDir
    File temporaryDirectory;

    @Test
    void readsFileAndReturnsContentAsString() {
        UI sut = prepareUI();

        String userInput = sut.getUserInput();

        assertThat(prompt()).isEmpty();
        assertThat(userInput).isEqualTo("one two");
    }

    @Test
    void thowsNullpointerExceptionIfAllParametersAreNull() {
        assertThrowsNullPointerException(() -> new ConsoleWriterFileReaderUI(null, null));
    }

    @Test
    void thowsNullpointerExceptionIfFirstParameterIsNull() {
        assertThrowsNullPointerException(() -> new ConsoleWriterFileReaderUI(null, ignoreReader));
    }

    @Test
    void thowsNullpointerExceptionIfSecondParameterIsNull() {
        assertThrowsNullPointerException(() -> new ConsoleWriterFileReaderUI(ignoreWriter, null));
    }

    private ConsoleWriterFileReaderUI prepareUI() {
        String fileName = "test.txt";
        prepareTestFile(fileName, Arrays.asList("one", "two"));
        return new ConsoleWriterFileReaderUI(ignoreWriter, new FileReader(fileName));
    }

    private void prepareTestFile(String fileName, List<String> contents) {
        try {
            File myFile = new File(temporaryDirectory, fileName);
            Files.write(myFile.toPath(), contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String prompt() {
        return testConsoleOutputRecorder.toString();
    }
}
