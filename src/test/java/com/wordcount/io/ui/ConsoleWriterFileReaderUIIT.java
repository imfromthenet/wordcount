package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.FileReader;
import com.wordcount.io.Reader;
import com.wordcount.io.Writer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static com.wordcount.AssertionHelper.assertThrowsNullPointerException;
import static com.wordcount.TestUIHelper.getTestConsoleOutputRecorder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class ConsoleWriterFileReaderUIIT {
    ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();
    Writer ignoreWriter = mock(Writer.class);
    Reader ignoreReader = mock(Reader.class);

    @Test
    void readsFileAndReturnsContentAsString() {
        UI sut = getSut();

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

    private ConsoleWriterFileReaderUI getSut() {
        return new ConsoleWriterFileReaderUI(ignoreWriter, new FileReader("test.txt"));
    }

    private String prompt() {
        return testConsoleOutputRecorder.toString();
    }
}
