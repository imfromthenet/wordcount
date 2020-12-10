package it.com.wordcount.io;

import com.wordcount.io.ConsoleUI;
import com.wordcount.io.UIFactory;
import com.wordcount.io.UIImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UIFactoryTest {

    @Test
    void buildsConsoleUI() {
        assertThat(UIFactory.construct(new String[]{}))
                .isExactlyInstanceOf(ConsoleUI.class);
    }

    @Test
    void buildsConsoleOutputFileInputUI() {
        assertThat(UIFactory.construct(new String[]{"nonExistingFile"}))
                .isExactlyInstanceOf(UIImpl.class);
    }
}