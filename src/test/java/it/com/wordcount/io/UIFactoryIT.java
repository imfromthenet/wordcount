package it.com.wordcount.io;

import com.wordcount.io.ConsoleUI;
import com.wordcount.io.UIFactory;
import com.wordcount.io.UIImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UIFactoryIT {

    @Test
    void buildsConsoleUIIfNoParametersAreProvided() {
        assertThat(UIFactory.construct(new String[]{}))
                .isExactlyInstanceOf(ConsoleUI.class);
    }

    @Test
    void buildsConsoleOutputFileInputUIIfAFileNameIsProvided() {
        assertThat(UIFactory.construct(new String[]{"nonExistingFile"}))
                .isExactlyInstanceOf(UIImpl.class);
    }

    @Test
    void ignoresIndexFlagAndBuildsConsoleUI() {
        assertThat(UIFactory.construct(new String[]{ "-index"}))
                .isExactlyInstanceOf(ConsoleUI.class);
    }

    @Test
    void ignoresIndexFlagAndBuildsConsoleOutputFileInputUI() {
        assertThat(UIFactory.construct(new String[]{"nonExistingFile", "-index"}))
                .isExactlyInstanceOf(UIImpl.class);
    }

}