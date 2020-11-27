package com.wordcount.io;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class FileReader implements Reader {
    private String filename;

    public FileReader(String filename) {
        this.filename = filename;
    }

    @Override
    public String read() {
        return readAsList().stream()
                .reduce("", (m, n) -> m.trim() + " " + n.trim());
    }

    @Override
    public List<String> readAsList() {
        try {
            Path path = getPath(filename);
            return Files.readAllLines(path).stream()
                    .filter(string -> !string.isEmpty())
                    .collect(toList());
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