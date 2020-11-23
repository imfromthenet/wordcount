package com.wordcount.io.ui;

import com.wordcount.io.util.FileReaderInterfaceRENAME;

public class FileUI implements UI {

    private final FileReaderInterfaceRENAME reader;
    private final String filename;

    public FileUI(final FileReaderInterfaceRENAME reader, final String filename) {
        this.reader = reader;
        this.filename = filename;
    }

    @Override
    public String getInput() {
        return String.join(" ", reader.read(filename));
    }
}
