package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static com.wordcount.AssertionHelper.assertThrowsNullPointerException;
import static com.wordcount.TestUIHelper.getTestConsoleOutputRecorder;
import static com.wordcount.TestUIHelper.simulateUserConsoleInputOf;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleUIIT {
    ByteArrayOutputStream testConsoleOutputRecorder = getTestConsoleOutputRecorder();
    UI sut = new ConsoleUI();

    @Test
    void requestsUserInputViaConsole() {
        simulateUserConsoleInputOf("message");
        String input = sut.getUserInput();

        assertThat(prompt()).startsWith("Enter text");
        assertThat(input).isEqualTo("message");
    }

    @Test
    void writesMessageToConsole() {
        sut.show("message");

        assertThat(messageDisplayedInConsole()).isEqualTo("message");
    }

    @Test
    void throwsNullPointerIfShowMethodIsPassedANull() {
        assertThrowsNullPointerException(() -> new ConsoleUI().show(null));
    }

    private String prompt() {
        return testConsoleOutputRecorder.toString();
    }

    private String messageDisplayedInConsole() {
        return prompt();
    }
}
