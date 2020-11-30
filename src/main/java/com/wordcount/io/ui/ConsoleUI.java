package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.Reader;
import com.wordcount.io.Writer;

import java.util.Objects;

public class ConsoleUI implements UI {

    private static final String MESSAGE_ENTER_TEXT = "Enter text: ";
    private Writer writer;
    private Reader reader;

    public ConsoleUI(Writer writer, Reader reader) {
        this.writer = Objects.requireNonNull(writer);
        this.reader = Objects.requireNonNull(reader);
    }

    public String getUserInput() {
        this.show(MESSAGE_ENTER_TEXT);
        return reader.read();
    }

    @Override
    public void show(String result) {
        writer.write(result);
    }
}
