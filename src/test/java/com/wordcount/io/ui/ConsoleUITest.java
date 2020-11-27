package com.wordcount.io.ui;

import com.wordcount.domain.UI;
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

    private String MESSAGE = "message";
    private InputStream standardIn = System.in;
    private PrintStream standardOut = System.out;
    private ByteArrayInputStream inputStreamCaptor = new ByteArrayInputStream(MESSAGE.getBytes());
    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

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
        UI sut = new ConsoleUI(new ConsoleWriter(), new ConsoleReader());

        String input = sut.getUserInput();

        assertEquals("Enter text: ", outputStreamCaptor.toString());
        assertEquals(MESSAGE, input);
    }

    @Test
    void writesMessageToConsole() {
        Reader mockReader = mock(Reader.class);
        UI sut = new ConsoleUI(new ConsoleWriter(), mockReader);

        sut.show(MESSAGE);

        assertEquals(MESSAGE, outputStreamCaptor.toString());
    }

    @Test
    void readsFromConsoleAndReturnsAsList() {
        Writer mockWriter = mock(Writer.class);
        UI sut = new ConsoleUI(mockWriter, new ConsoleReader());

        List<String> actual = sut.readAsList();

        assertEquals(singletonList(MESSAGE), actual);
    }
}