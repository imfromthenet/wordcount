package com.wordcount.io.ui;

import com.wordcount.io.Reader;
import com.wordcount.io.Writer;

import java.util.List;

public class ConsoleWriterFileReaderUI implements UI {

    private final Writer writer;
    private final Reader reader;

    public ConsoleWriterFileReaderUI(final Writer writer, final Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public String getInput() {
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
