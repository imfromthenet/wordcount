package com.wordcount.io;

import java.util.List;

public interface Readable {

    List<String> readAsLines(final String path);
}
