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
    private String path;

    public FileInputUI(String path) {
        this.path = path;
    }

    @Override
    public String getInput() {
        try {
            Path p = PathMapper.toPath(path);
            return Files.lines(p)
                    .filter(string -> !string.isEmpty())
                    .collect(joining(" "));
        } catch (NullPointerException | IOException e) {
            throw new NullPointerException();
        }
    }

   private static class PathMapper {
        private static Path toPath(String path) {
            if (path.startsWith("/")) return getPathFromFileSystem(path);
            return getPathFromClasspath(path);
        }

        private static Path getPathFromFileSystem(String path) {
            return Paths.get(path);
        }

        private static Path getPathFromClasspath(String path) {
            try {
                URI uri = ClassLoader.getSystemResource(path).toURI();
                return Paths.get(Objects.requireNonNull(uri));
            } catch (URISyntaxException e) {
                throw new NullPointerException("error while getting the path to the file reading the file: " + path);
            }
        }
    }
}