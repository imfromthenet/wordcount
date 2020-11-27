package com.wordcount.domain;

import java.util.List;

public interface UI {
    String getInput();
    void write(final String message);

    List<String> readAsList();
}
