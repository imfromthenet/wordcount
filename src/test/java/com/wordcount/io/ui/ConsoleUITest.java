package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static com.wordcount.AssertionHelper.assertThrowsNullPointerException;
import static com.wordcount.TestUIHelper.getTestConsoleOutputRecorder;
import static com.wordcount.TestUIHelper.simulateUserConsoleInputOf;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleUITest {
    ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();

    @Test
    void requestsUserInputViaConsole() {
        UI sut = new ConsoleUI();
        simulateUserConsoleInputOf("message");

        String input = sut.getUserInput();

        assertThat(testConsoleOutputRecorder.toString()).startsWith("Enter text");
        assertThat(input).isEqualTo("message");
    }

    @Test
    void writesMessageToConsole() {
        UI sut = new ConsoleUI();

        sut.show("message");

        assertThat(testConsoleOutputRecorder.toString()).isEqualTo("message");
    }

    @Test
    void throwsNullPointerIfShowMethodIsPassedANull() {
        assertThrowsNullPointerException(() -> new ConsoleUI().show(null));
    }
}
