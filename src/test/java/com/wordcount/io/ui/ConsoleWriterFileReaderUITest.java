package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.ConsoleWriter;
import com.wordcount.io.FileReader;
import com.wordcount.io.Reader;
import com.wordcount.io.Writer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static com.wordcount.TestUtils.getOutputRecorder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class ConsoleWriterFileReaderUITest {

    @Test
    void readsFileAndReturnsContentAsString() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        Writer ignore = mock(Writer.class);
        UI sut = new ConsoleWriterFileReaderUI(ignore, new FileReader("test.txt"));

        String userInput = sut.getUserInput();

        assertEquals("", outputRecorder.toString());
        assertEquals("one two", userInput);
    }

    @Test
    void writesMessageToConsole() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        Reader ignore = mock(Reader.class);
        UI sut = new ConsoleWriterFileReaderUI(new ConsoleWriter(), ignore);

        sut.show("message");

        assertEquals("message", outputRecorder.toString());
    }

    @Test
    void thowsNullpointerExceptionIfBothParametersAreNull() {
        assertThrows(NullPointerException.class, () -> new ConsoleWriterFileReaderUI(null, null));
    }

    @Test
    void thowsNullpointerExceptionIfFirstParametersAreNull() {
        assertThrows(NullPointerException.class, () -> new ConsoleWriterFileReaderUI(null, mock(FileReader.class)));
    }

    @Test
    void thowsNullpointerExceptionIfSecondParametersAreNull() {
        assertThrows(NullPointerException.class, () -> new ConsoleWriterFileReaderUI(mock(ConsoleWriter.class), null));
    }

}