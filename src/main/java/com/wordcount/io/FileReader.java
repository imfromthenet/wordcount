package com.wordcount.io;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileReader implements Reader {
    private String filename;

    public FileReader(String filename) {
        this.filename = filename;
    }

    @Override
    public String read() {
        try {
            Path path = getPath(filename);
            return Files.readAllLines(path).stream()
                    .filter(string -> !string.isEmpty())
                    .reduce("", (m, n) -> m.trim() + " " + n.trim());
        } catch (IOException e) {
            throw new RuntimeException("error while reading the file", e);
        }
    }

    private Path getPath(String filePath) {
        try {
            URI uri = ClassLoader.getSystemResource(filePath).toURI();
            return Paths.get(Objects.requireNonNull(uri));
        } catch (URISyntaxException e) {
            throw new RuntimeException("error while getting the path to the file reading the file", e);
        }
    }
}