package com.wordcount.io;

import com.wordcount.domain.InputUI;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class FileInputUI implements InputUI {
    private String fileNameOrPath;

    public FileInputUI(String fileNameOrPath) {
        this.fileNameOrPath = fileNameOrPath;
    }

    @Override
    public String getInput() {
        try {
            Path path = PathFactory.buildFrom(fileNameOrPath);
            return Files.lines(path)
                    .filter(string -> !string.isEmpty())
                    .collect(joining(" "));
        } catch (NullPointerException | IOException e) {
            throw new NullPointerException();
        }
    }

    private static class PathFactory {
        private static Path buildFrom(String fileNameOrPathName) {
            if (fileNameOrPathName.startsWith("/")) return getFilePathForTest(fileNameOrPathName);
            return getFilePath(fileNameOrPathName);
        }

        private static Path getFilePathForTest(String fileNameOrPathName) {
            return Paths.get(fileNameOrPathName);
        }

        private static Path getFilePath(String fileNameOrPathName) {
            try {
                URI uri = ClassLoader.getSystemResource(fileNameOrPathName).toURI();
                return Paths.get(Objects.requireNonNull(uri));
            } catch (NullPointerException | URISyntaxException e) {
                throw new NullPointerException("error while getting the path to the file reading the file: " + fileNameOrPathName);
            }
        }
    }
}