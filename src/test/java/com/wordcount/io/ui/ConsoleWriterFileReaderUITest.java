package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.ConsoleWriter;
import com.wordcount.io.FileReader;
import com.wordcount.io.Reader;
import com.wordcount.io.Writer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static com.wordcount.AssertionHelper.assertThrowsNullPointerException;
import static com.wordcount.TestUIHelper.getOutputRecorder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class ConsoleWriterFileReaderUITest {

    @Test
    void readsFileAndReturnsContentAsString() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        Writer ignore = mock(Writer.class);
        UI sut = new ConsoleWriterFileReaderUI(ignore, new FileReader("test.txt"));

        String userInput = sut.getUserInput();

        assertThat(outputRecorder.toString()).isEmpty();
        assertThat(userInput).isEqualTo("one two");
    }

    @Test
    void writesMessageToConsole() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        Reader ignore = mock(Reader.class);
        UI sut = new ConsoleWriterFileReaderUI(new ConsoleWriter(), ignore);

        sut.show("message");

        assertThat(outputRecorder.toString()).isEqualTo("message");
    }

    @Test
    void thowsNullpointerExceptionIfBothParametersAreNull() {
        assertThrowsNullPointerException(() -> new ConsoleWriterFileReaderUI(null, null));
    }

    @Test
    void thowsNullpointerExceptionIfFirstParameterIsNull() {
        assertThrowsNullPointerException(() -> new ConsoleWriterFileReaderUI(null, mock(FileReader.class)));
    }

    @Test
    void thowsNullpointerExceptionIfSecondParameterIsNull() {
        assertThrowsNullPointerException(() -> new ConsoleWriterFileReaderUI(mock(ConsoleWriter.class), null));
    }
}