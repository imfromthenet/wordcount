package ut.com.wordcount.io;

import com.wordcount.io.FileInputUI;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sharedTool.AssertionHelper.assertThrowsNullPointerException;

class FileInputUITest {

    @Test
    void readsFromFileAsString() {
        String expected = "one two";
        FileInputUI sut = new FileInputUI("test.txt");

        String actual = sut.getInput();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void throwsNullPointerIfFileNotFoundWhenReadAsString() {
        assertThrowsNullPointerException(() -> new FileInputUI("nonExistingFile").getInput());
    }
}