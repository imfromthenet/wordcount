package com.wordcount.domain;

import com.wordcount.io.file.FileReader;

import java.util.List;
import java.util.Objects;

public class StopWords {
    private List<String> stopWords;
    private final FileReader fileReader;

    public StopWords(final FileReader fileReader) {
        this.fileReader = Objects.requireNonNull(fileReader);
    }

    public void fillFrom(final String path) {
        stopWords = fileReader.read(path);
    }

    public boolean contain(final String candidate) {
        return stopWords.contains(candidate);
    }
}
