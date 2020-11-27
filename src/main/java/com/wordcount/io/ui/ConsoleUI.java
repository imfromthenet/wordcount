package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.Reader;
import com.wordcount.io.Writer;

import java.util.List;

public class ConsoleUI implements UI {

    public static final String MESSAGE_ENTER_TEXT = "Enter text: ";
    private Writer writer;
    private Reader reader;

    public ConsoleUI(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public String getUserInput() {
        this.show(MESSAGE_ENTER_TEXT);
        return reader.read();
    }

    @Override
    public void show(String message) {
        writer.write(message);
    }

    @Override
    public List<String> readAsList() {
        return reader.readAsList();
    }
}
