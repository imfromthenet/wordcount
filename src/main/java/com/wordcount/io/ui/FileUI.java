package com.wordcount.io.ui;

import com.wordcount.util.FileReader;

public class FileUI implements UI {

    String filename;

    public FileUI(final String filename) {
        this.filename = filename;
    }

    @Override
    public String getInput() {
        return String.join(" ", FileReader.getInstance().read(filename));
    }
}
