package com.wordcount.domain.handlers;

import java.util.List;

public interface Handler {
    String handle(List<String> words);
}
