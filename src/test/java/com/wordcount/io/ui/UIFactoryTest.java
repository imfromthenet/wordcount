package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UIFactoryTest {

    @Test
    void constructsConsoleWriterFileReaderUI() {
        UI sut = UIFactory.construct(new String[]{"mytext.txt"});

        assertThat(sut).isExactlyInstanceOf(ConsoleWriterFileReaderUI.class);
    }

    @Test
    void constructsConsoleUI() {
        UI sut = UIFactory.construct(new String[]{"-index"});

        assertThat(sut).isExactlyInstanceOf(ConsoleUI.class);
    }
}