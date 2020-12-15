package com.wordcount.io;

import com.wordcount.domain.InputUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.stream.Collectors.joining;

public class FileInputUI implements InputUI {
    private String path;

    public FileInputUI(String path) {
        this.path = path;
    }

    @Override
    public String getInput() {
        Path p = PathMapper.toPath(path);
        if (p == null) {
            System.out.printf("The path (%s) was not able to be read. Instead, an empty string is passed as input.", path);
            return "";
        }
        try {
            return Files.lines(p)
                    .filter(string -> !string.isEmpty())
                    .collect(joining(" "));
        } catch (IOException e) {
            System.out.printf("There was a problem opening a file (%s). Instead, an empty string is passed as input.", path);
            return "";
        }
    }

    private static class PathMapper {
        private static Path toPath(String path) {
            if (path == null) {
                return null;
            }
            if (path.contains("/")) return getPathFromFileSystem(path);
            return getPathFromClasspath(path);
        }

        private static Path getPathFromFileSystem(String path) {
            try {
                return Paths.get(path);
            } catch (InvalidPathException e) {
                return null;
            }
        }

        private static Path getPathFromClasspath(String path) {
            URL url = ClassLoader.getSystemResource(path);
            if (url == null) {
                return null;
            }
            return new File(url.getFile()).toPath();
        }
    }
}