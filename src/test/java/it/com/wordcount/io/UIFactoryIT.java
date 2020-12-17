package it.com.wordcount.io;

import com.wordcount.io.ConsoleUI;
import com.wordcount.io.UIFactory;
import com.wordcount.io.UIImpl;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

class UIFactoryIT {

    @Test
    void buildsConsoleUIIfNoParametersAreProvided() {
        assertThat(UIFactory.construct(emptyList()))
                .isExactlyInstanceOf(ConsoleUI.class);
    }

    @Test
    void buildsConsoleOutputFileInputUIIfAFileNameIsProvided() {
        assertThat(UIFactory.construct(singletonList("nonExistingFile")))
                .isExactlyInstanceOf(UIImpl.class);
    }

    @Test
    void ignoresIndexFlagAndBuildsConsoleUI() {
        assertThat(UIFactory.construct(singletonList("-index")))
                .isExactlyInstanceOf(ConsoleUI.class);
    }

    @Test
    void ignoresIndexFlagAndBuildsConsoleOutputFileInputUI() {
        assertThat(UIFactory.construct(asList("nonExistingFile", "-index")))
                .isExactlyInstanceOf(UIImpl.class);
    }

}