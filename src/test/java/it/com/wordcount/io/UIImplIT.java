package it.com.wordcount.io;

import com.wordcount.domain.InputUI;
import com.wordcount.domain.OutputUI;
import com.wordcount.domain.UI;
import com.wordcount.io.FileInputUI;
import com.wordcount.io.UIImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sharedTool.TestFile;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static sharedTool.AssertionHelper.assertThrowsNullPointerException;

class UIImplIT {
    private static final String CONTENT_OF_FILE = "one two";

    OutputUI ignoreOutputUI = mock(OutputUI.class);
    InputUI ignoreInputUI = mock(InputUI.class);

    @TempDir
    File tempDirectory;

    @Test
    void requestsUserInputViaFile() {
        UI sut = prepareUIWith(CONTENT_OF_FILE);

        String userInput = sut.getInput();

        assertThat(userInput).isEqualTo(CONTENT_OF_FILE);
    }

    @Test
    void throwsNullPointerExceptionIfAllParametersAreNull() {
        assertThrowsNullPointerException(() -> new UIImpl(null, null));
    }

    @Test
    void throwsNullPointerExceptionIfFirstParameterIsNull() {
        assertThrowsNullPointerException(() -> new UIImpl(null, ignoreInputUI));
    }

    @Test
    void throwsNullPointerExceptionIfSecondParameterIsNull() {
        assertThrowsNullPointerException(() -> new UIImpl(ignoreOutputUI, null));
    }

    private UIImpl prepareUIWith(String content) {
        TestFile file = new TestFile(tempDirectory);
        file.prepare("fileName.txt", content);
        return new UIImpl(ignoreOutputUI, new FileInputUI(file.getPathAsString()));
    }

}
