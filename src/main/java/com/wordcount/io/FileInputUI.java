package com.wordcount.io;

import com.wordcount.domain.InputUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class FileInputUI implements InputUI {
    private String pathName;
    private Logger logger = LoggerFactory.getLogger(FileInputUI.class);

    public FileInputUI(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public String getInput() {
        Path p = PathMapper.toPath(pathName);
        if (p == null) {
            String messageToUser = String.format("The path (%s) was not able to be read. Instead, an empty string is passed instead.", pathName);
            logger.warn(messageToUser);
            return "";
        }
        try (final Stream<String> lines = Files.lines(p)) {
            return lines
                    .filter(string -> !string.isEmpty())
                    .collect(joining(" "));
        } catch (IOException e) {
            logger.warn(String.format("There was a problem opening a file (%s). Instead, an empty string is passed further.", pathName));
            return "";
        }
    }

    private static class PathMapper {
        private static Path toPath(String pathName) {
            if (pathName == null) {
                return null;
            }
            if (pathName.contains("/")) return getPathFromFileSystem(pathName);
            return getPathFromClasspath(pathName);
        }

        private static Path getPathFromFileSystem(String pathName) {
            try {
                return Paths.get(pathName);
            } catch (InvalidPathException e) {
                return null;
            }
        }

        private static Path getPathFromClasspath(String pathName) {
            URL url = ClassLoader.getSystemResource(pathName);
            if (url == null) {
                return null;
            }
            return new File(url.getFile()).toPath();
        }
    }
}