package com.wordcount.io.file;

import com.wordcount.io.UIable;

public class FileUI extends FileReader implements UIable {

    String filename;

    public FileUI(final String filename) {
        this.filename = filename;
    }

    @Override
    public String getInput() {
        return String.join(" ", super.read(filename));
    }
}
