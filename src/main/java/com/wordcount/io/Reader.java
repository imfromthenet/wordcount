package com.wordcount.io;

import java.util.List;

public interface Reader {
    String read();
    List<String> readAsList();
}
