package it.com.wordcount.io;

import com.wordcount.domain.UI;
import com.wordcount.io.ConsoleUI;
import org.junit.jupiter.api.Test;
import sharedTool.TestUIHelper;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static sharedTool.AssertionHelper.assertThrowsNullPointerException;

class ConsoleUIIT {
    private static final String MESSAGE = "message";

    ByteArrayOutputStream testConsoleOutputRecorder = TestUIHelper.getTestConsoleOutputRecorder();
    UI sut = new ConsoleUI();

    @Test
    void requestsUserInputViaConsole() {
        TestUIHelper.simulateUserConsoleInputOf(MESSAGE);
        String input = sut.getInput();

        assertThat(input).isEqualTo(MESSAGE);
    }

    @Test
    void writesMessageToConsole() {
        sut.show(MESSAGE);

        assertThat(messageDisplayedInConsole()).isEqualTo(MESSAGE);
    }

    @Test
    void throwsNullPointerIfShowMethodIsPassedANull() {
        assertThrowsNullPointerException(() -> new ConsoleUI().show(null));
    }

    private String messageDisplayedInConsole() {
        return testConsoleOutputRecorder.toString();
    }
}
