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
        }  catch (NullPointerException | IOException e) {
            throw new NullPointerException();
        }
    }

    private Path getPath(String filePath) {
        try {
            URI uri = ClassLoader.getSystemResource(filePath).toURI();
            return Paths.get(Objects.requireNonNull(uri));
        } catch (NullPointerException | URISyntaxException e) {
            throw new NullPointerException("error while getting the path to the file reading the file: "+ filePath);
        }
    }
}