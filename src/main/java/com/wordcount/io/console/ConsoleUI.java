package com.wordcount.io.console;

public class ConsoleUI {

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

}
