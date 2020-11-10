package com.wordcount.io;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileReader implements Readable {

    @Override
    public List<String> readAsLines(final String filePath) {
        try {
            Path path = getPath(filePath);
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private Path getPath(String filePath){
        URI uri = null;
        try {
            uri = ClassLoader.getSystemResource(filePath).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Paths.get(Objects.requireNonNull(uri));
    }
}