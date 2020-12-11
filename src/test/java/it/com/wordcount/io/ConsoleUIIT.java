package it.com.wordcount.io;

import com.wordcount.domain.UI;
import com.wordcount.io.ConsoleUI;
import org.junit.jupiter.api.Test;
import sharedTool.TestUIHelper;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static sharedTool.AssertionHelper.assertThrowsNullPointerException;

class ConsoleUIIT {
    ByteArrayOutputStream testConsoleOutputRecorder = TestUIHelper.getTestConsoleOutputRecorder();
    UI sut = new ConsoleUI();

    @Test
    void requestsUserInputViaConsole() {
        TestUIHelper.simulateUserConsoleInputOf("message");
        String input = sut.getInput();

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

    private String messageDisplayedInConsole() {
        return testConsoleOutputRecorder.toString();
    }
}
