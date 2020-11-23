package com.wordcount.io.file;

import com.wordcount.io.UI;

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
