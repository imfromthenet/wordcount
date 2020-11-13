package com.wordcount.domain;

import com.wordcount.io.file.IFileReader;

import java.util.List;
import java.util.Objects;

public class StopWords {
    private List<String> stopWords;
    private final IFileReader fileReader;

    public StopWords(final IFileReader fileReader) {
        this.fileReader = Objects.requireNonNull(fileReader);
    }

    public void fillFrom(final String path) {
        stopWords = fileReader.read(path);
    }

    public boolean contain(final String candidate) {
        return stopWords.contains(candidate);
    }
}
