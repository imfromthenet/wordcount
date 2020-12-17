package com.wordcount.domain.handler;

import java.util.List;

public interface Handler {
    String handle(List<String> words);
}
