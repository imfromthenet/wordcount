package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.Reader;
import com.wordcount.io.Writer;

import java.util.List;

public class ConsoleUI implements UI {

    public static final String MESSAGE_ENTER_TEXT = "Enter text: ";
    private final Writer writer;
    private final Reader reader;

    public ConsoleUI(final Writer writer, final Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public String getInput() {
        writer.write(MESSAGE_ENTER_TEXT);
        return reader.read();
    }

    @Override
    public void write(final String message) {
        writer.write(message);
    }

    @Override
    public List<String> readAsList() {
        return reader.readAsList();
    }
}
