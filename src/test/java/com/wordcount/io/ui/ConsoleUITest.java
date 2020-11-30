package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.ConsoleReader;
import com.wordcount.io.ConsoleWriter;
import com.wordcount.io.Reader;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class ConsoleUITest {

    @Test
    void requestsUserInputViaConsoleAndAfterReceivingItReturnsItAsString() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        simulateUserConsoleInputOf("message");
        UI sut = new ConsoleUI(new ConsoleWriter(), new ConsoleReader());

        String input = sut.getUserInput();

        assertEquals("Enter text: ", outputRecorder.toString());
        assertEquals("message", input);
    }

    @Test
    void writesMessageToConsole() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        Reader ignore = mock(Reader.class);
        UI sut = new ConsoleUI(new ConsoleWriter(), ignore);

        sut.show("message");

        assertEquals("message", outputRecorder.toString());
    }

    @Test
    void thowsNullpointerExceptionIfBothParametersAreNull() {
        assertThrows(NullPointerException.class, () -> new ConsoleUI(null, null));
    }

    @Test
    void thowsNullpointerExceptionIfFirstParameterIsNull() {
        assertThrows(NullPointerException.class, () -> new ConsoleUI(null, new ConsoleReader()));
    }

    @Test
    void thowsNullpointerExceptionIfSecondParameterIsNull() {
        assertThrows(NullPointerException.class, () -> new ConsoleUI(new ConsoleWriter(), null));
    }

    private ByteArrayOutputStream getOutputRecorder() {
        ByteArrayOutputStream outputRecorder = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputRecorder));
        return outputRecorder;
    }

    private void simulateUserConsoleInputOf(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
    }
}
