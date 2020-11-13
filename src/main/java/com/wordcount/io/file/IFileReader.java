package com.wordcount.io.file;

import java.util.List;

public interface IFileReader {
    List<String> read(final String filePath);
}
