package it.com.wordcount.io;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.wordcount.io.FileInputUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.slf4j.LoggerFactory;
import sharedTool.TestFile;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class FileInputUIIT {

    private static final String CONTENT_OF_FILE = "input from file";
    private static final String NONEXISTENT_FILENAME = "nonexistentFilename";

    @TempDir
    File tempDirectory;
    private ListAppender<ILoggingEvent> listAppender;

    @BeforeEach
    public void setup() {
        Logger logger = (Logger) LoggerFactory.getLogger(FileInputUI.class);
        listAppender = new ListAppender<>();
        listAppender.setContext(logger.getLoggerContext());
        listAppender.start();
        logger.addAppender(listAppender);
    }

    @AfterEach
    public void cleanUp() {
        listAppender.stop();
    }

    @Test
    void readsFromFileAsString() {
        FileInputUI sut = getFileInputUIWith(CONTENT_OF_FILE);

        String actual = sut.getInput();

        assertThat(actual).isEqualTo(CONTENT_OF_FILE);
    }

    @Test
    void whenPassedFileNameIsNotFoundReturnsEmptyStringAndLogsWarningToUser() {
        String input = new FileInputUI(NONEXISTENT_FILENAME).getInput();
        ILoggingEvent logEntry = listAppender.list.get(0);

        assertSoftly(softly -> {
            softly.assertThat(logEntry.getMessage()).contains(NONEXISTENT_FILENAME);
            softly.assertThat(logEntry.getLevel()).isEqualTo(Level.WARN);

            softly.assertThat(input).isEmpty();
            softly.assertAll();
        });
    }

    @Test
    void whenPassedNullReturnsEmptyStringAndLogsWarningToUser() {
        String input = new FileInputUI(null).getInput();
        ILoggingEvent logEntry = listAppender.list.get(0);

        assertSoftly(softly -> {
            softly.assertThat(logEntry.getMessage()).contains("null");
            softly.assertThat(logEntry.getLevel()).isEqualTo(Level.WARN);

            softly.assertThat(input).isEqualTo("");
            softly.assertAll();
        });
    }

    @Test
    void whenFileIsLockedReturnsAnEmptyStringAndLogsWarningToUser() {
        TestFile testFile = createTestFile(CONTENT_OF_FILE);
        String pathAsString = testFile.getPathAsString();

        lock(pathAsString);
        String input = new FileInputUI(pathAsString).getInput();
        ILoggingEvent logEntry = listAppender.list.get(0);

        assertSoftly(softly -> {
            softly.assertThat(logEntry.getMessage()).contains(pathAsString);
            softly.assertThat(logEntry.getLevel()).isEqualTo(Level.WARN);

            softly.assertThat(input).isEqualTo("");
            softly.assertAll();
        });

        unlock(pathAsString);
    }

    private FileInputUI getFileInputUIWith(String content) {
        TestFile file = createTestFile(content);
        return new FileInputUI(file.getPathAsString());
    }

    private TestFile createTestFile(String content) {
        TestFile file = new TestFile(tempDirectory);
        file.prepare("fileName.txt", content);
        return file;
    }

    private void lock(String filePath) {
        new File(filePath).setReadable(false);
    }

    private void unlock(String filePath) {
        new File(filePath).setReadable(true);
    }

}
