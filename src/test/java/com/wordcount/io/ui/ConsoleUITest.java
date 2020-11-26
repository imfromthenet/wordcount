package com.wordcount.io.ui;

import com.wordcount.io.ConsoleReader;
import com.wordcount.io.ConsoleWriter;
import com.wordcount.io.Reader;
import com.wordcount.io.Writer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ConsoleUITest {

    private final String MESSAGE = "message";
    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;
    private final ByteArrayInputStream inputStreamCaptor = new ByteArrayInputStream(MESSAGE.getBytes());
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(inputStreamCaptor);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    void requestsInputViaConsoleAndAfterReceivingItReturnsItAsString() {
        final UI sut = new ConsoleUI(new ConsoleWriter(), new ConsoleReader());

        final String input = sut.getInput();

        assertEquals("Enter text: ", outputStreamCaptor.toString());
        assertEquals(MESSAGE, input);
    }

    @Test
    void writesMessageToConsole() {
        final Reader mockReader = mock(Reader.class);
        final UI sut = new ConsoleUI(new ConsoleWriter(), mockReader);

        sut.write(MESSAGE);

        assertEquals(MESSAGE, outputStreamCaptor.toString());
    }

    @Test
    void readsFromConsoleAndReturnsAsList() {
        final Writer mockWriter = mock(Writer.class);
        final UI sut = new ConsoleUI(mockWriter, new ConsoleReader());

        final List<String> actual = sut.readAsList();

        assertEquals(singletonList(MESSAGE), actual);
    }
}