package com.wordcount.io.file;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class FileReader {

    public List<String> read(final String filePath) {
        try {
            Path path = getPath(filePath);
            return Files.readAllLines(path);
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