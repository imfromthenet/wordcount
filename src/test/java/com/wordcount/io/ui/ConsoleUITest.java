package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static com.wordcount.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleUITest {

    @Test
    void requestsUserInputViaConsole() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        simulateUserConsoleInputOf("message");
        UI sut = new ConsoleUI();

        String input = sut.getUserInput();

        assertThat(outputRecorder.toString()).startsWith("Enter text");
        assertThat(input).isEqualTo("message");
    }

    @Test
    void writesMessageToConsole() {
        ByteArrayOutputStream outputRecorder = getOutputRecorder();
        UI sut = new ConsoleUI();

        sut.show("message");

        assertThat(outputRecorder.toString()).isEqualTo("message");
    }

    @Test
    void throwsNullPointerIfShowMethodIsPassedANull() {
        throwsNullPointerException(() -> new ConsoleUI().show(null));
    }
}
