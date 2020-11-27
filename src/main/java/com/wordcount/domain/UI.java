package com.wordcount.domain;

import java.util.List;

public interface UI {
    String getInput();
    void write(String message);

    List<String> readAsList();
}
