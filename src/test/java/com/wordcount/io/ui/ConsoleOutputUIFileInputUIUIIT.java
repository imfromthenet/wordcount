package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.FileInputUI;
import com.wordcount.io.InputUI;
import com.wordcount.io.OutputUI;
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

class ConsoleOutputUIFileInputUIUIIT {
    ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();
    OutputUI ignoreOutputUI = mock(OutputUI.class);
    InputUI ignoreInputUI = mock(InputUI.class);

    @TempDir
    File temporaryDirectory;

    @Test
    void readsFileAndReturnsContentAsString() {
        UI sut = prepareUI();

        String userInput = sut.getInput();

        assertThat(prompt()).isEmpty();
        assertThat(userInput).isEqualTo("one two");
    }

    @Test
    void thowsNullpointerExceptionIfAllParametersAreNull() {
        assertThrowsNullPointerException(() -> new ConsoleOutputFileInputUI(null, null));
    }

    @Test
    void thowsNullpointerExceptionIfFirstParameterIsNull() {
        assertThrowsNullPointerException(() -> new ConsoleOutputFileInputUI(null, ignoreInputUI));
    }

    @Test
    void thowsNullpointerExceptionIfSecondParameterIsNull() {
        assertThrowsNullPointerException(() -> new ConsoleOutputFileInputUI(ignoreOutputUI, null));
    }

    private ConsoleOutputFileInputUI prepareUI() {
        String fileName = "test.txt";
        prepareTestFile(fileName, Arrays.asList("one", "two"));
        return new ConsoleOutputFileInputUI(ignoreOutputUI, new FileInputUI(fileName));
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
