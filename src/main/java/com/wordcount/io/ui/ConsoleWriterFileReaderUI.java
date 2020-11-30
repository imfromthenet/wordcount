package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.Reader;
import com.wordcount.io.Writer;

import java.util.Objects;

public class ConsoleWriterFileReaderUI implements UI {

    private Writer writer;
    private Reader reader;

    public ConsoleWriterFileReaderUI(Writer writer, Reader reader) {
        Objects.requireNonNull(this.writer = writer);
        Objects.requireNonNull(this.reader = reader);
    }

    @Override
    public String getUserInput() {
        return reader.read();
    }

    @Override
    public void show(String result) {
        writer.write(result);
    }
}
