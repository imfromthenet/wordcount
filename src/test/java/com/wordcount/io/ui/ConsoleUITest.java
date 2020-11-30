package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.ConsoleReader;
import com.wordcount.io.ConsoleWriter;
import com.wordcount.io.Reader;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static com.wordcount.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class ConsoleUITest {

    @Test
    void requestsUserInputViaConsoleAndAfterReceivingItReturnsItAsString() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        simulateUserConsoleInputOf("message");
        UI sut = new ConsoleUI(new ConsoleWriter(), new ConsoleReader());

        String input = sut.getUserInput();

        assertThat(outputRecorder.toString()).startsWith("Enter text");
        assertThat(input).isEqualTo("message");
    }

    @Test
    void writesMessageToConsole() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        Reader ignore = mock(Reader.class);
        UI sut = new ConsoleUI(new ConsoleWriter(), ignore);

        sut.show("message");

        assertThat(outputRecorder.toString()).isEqualTo("message");
    }

    @Test
    void thowsNullpointerExceptionIfBothParametersAreNull() {
        throwsNullPointerException(() -> new ConsoleUI(null, null));
    }

    @Test
    void thowsNullpointerExceptionIfFirstParameterIsNull() {
        throwsNullPointerException(() -> new ConsoleUI(null, new ConsoleReader()));
    }

    @Test
    void thowsNullpointerExceptionIfSecondParameterIsNull() {
        throwsNullPointerException(() -> new ConsoleUI(new ConsoleWriter(), null));
    }
}
