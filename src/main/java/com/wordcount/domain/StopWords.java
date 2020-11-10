package com.wordcount.domain;

import com.wordcount.io.Readable;

import java.util.List;
import java.util.Objects;

public class StopWords {
    private List<String> stopWords;
    private final Readable fileReader;

    public StopWords(final Readable fileReader) {
        this.fileReader = Objects.requireNonNull(fileReader);
    }

    public void fillFrom(final String path) {
        stopWords = fileReader.readAsLines(path);
    }

    public boolean contain(final String candidate) {
        return stopWords.contains(candidate);
    }
}
