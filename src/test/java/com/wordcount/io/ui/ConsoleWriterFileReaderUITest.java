package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.ConsoleWriter;
import com.wordcount.io.FileReader;
import com.wordcount.io.Reader;
import com.wordcount.io.Writer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ConsoleWriterFileReaderUITest {


    public static final String TEST_TXT = "test.txt";
    private final String MESSAGE = "message";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void readsFileAndReturnsContentAsString() {
        final UI sut = new ConsoleWriterFileReaderUI(mock(Writer.class), new FileReader(TEST_TXT));

        final String input = sut.getInput();

        assertEquals("", outputStreamCaptor.toString());
        assertEquals("one two", input);
    }

    @Test
    void writesMessageToConsole() {
        final Reader mockReader = mock(Reader.class);
        final UI sut = new ConsoleUI(new ConsoleWriter(), mockReader);

        sut.write(MESSAGE);

        assertEquals(MESSAGE, outputStreamCaptor.toString());
    }

    @Test
    void readsFileAndReturnsAsList() {
        final Writer mockWriter = mock(Writer.class);
        final FileReader spy = spy(new FileReader(TEST_TXT));
        final UI sut = new ConsoleUI(mockWriter, spy);

        final List<String> actual = sut.readAsList();

        assertEquals(asList("one", "two"), actual);
        verify(spy, times(1)).readAsList();
        verifyNoMoreInteractions(spy);
    }
}