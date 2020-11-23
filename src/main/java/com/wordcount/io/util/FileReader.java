package com.wordcount.io.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class FileReader implements FileReaderInterfaceRENAME {

    private static FileReaderInterfaceRENAME instance;

    private FileReader() {}

    public static synchronized FileReaderInterfaceRENAME getInstance() {
        if (instance == null) {
            instance = new FileReader();
        }
        return instance;
    }

    @Override
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