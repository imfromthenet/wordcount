package it.com.wordcount.io;

import com.wordcount.domain.UI;
import com.wordcount.io.FileInputUI;
import com.wordcount.io.InputUI;
import com.wordcount.io.OutputUI;
import com.wordcount.io.UIImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sharedTool.TestFile;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static sharedTool.AssertionHelper.assertThrowsNullPointerException;

class UIImplIT {
    OutputUI ignoreOutputUI = mock(OutputUI.class);
    InputUI ignoreInputUI = mock(InputUI.class);

    @TempDir
    File tempDirectory;

    @Test
    void requestsUserInputViaFile() {
        UI sut = prepareUI();

        String userInput = sut.getInput();

        assertThat(userInput).isEqualTo("one two");
    }

    @Test
    void thowsNullpointerExceptionIfAllParametersAreNull() {
        assertThrowsNullPointerException(() -> new UIImpl(null, null));
    }

    @Test
    void thowsNullpointerExceptionIfFirstParameterIsNull() {
        assertThrowsNullPointerException(() -> new UIImpl(null, ignoreInputUI));
    }

    @Test
    void thowsNullpointerExceptionIfSecondParameterIsNull() {
        assertThrowsNullPointerException(() -> new UIImpl(ignoreOutputUI, null));
    }

    private UIImpl prepareUI() {
        TestFile testFile = prepareTestFileContaining("one two");
        return new UIImpl(ignoreOutputUI, new FileInputUI(testFile.getPathAsString()));
    }

    private TestFile prepareTestFileContaining(String contents) {
        TestFile file = new TestFile(tempDirectory);
        file.prepare("fileName.txt", contents);
        return file;
    }
}
