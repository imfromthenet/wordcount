package it.com.wordcount.io;

import com.wordcount.domain.UI;
import com.wordcount.io.ConsoleUI;
import it.com.wordcount.TestUIHelper;
import org.junit.jupiter.api.Test;

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
