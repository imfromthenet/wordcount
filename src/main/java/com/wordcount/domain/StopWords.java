package com.wordcount.domain;

import com.wordcount.io.util.FileReaderInterfaceRENAME;

import java.util.List;
import java.util.Objects;

public class StopWords {
    private List<String> stopWords;

    private final FileReaderInterfaceRENAME fileReaderInterfaceRENAME;

    public StopWords(final FileReaderInterfaceRENAME fileReaderInterfaceRENAME) {
        this.fileReaderInterfaceRENAME = Objects.requireNonNull(fileReaderInterfaceRENAME);
    }

    public void fillFrom(final String path) {
        stopWords = fileReaderInterfaceRENAME.read(path);
    }

    public boolean contain(final String candidate) {
        return stopWords.contains(candidate);
    }
}
