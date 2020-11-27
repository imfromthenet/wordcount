package com.wordcount.domain;

import java.util.List;

public interface UI {
    String getUserInput();
    void show(String message);

    List<String> readAsList();
}
