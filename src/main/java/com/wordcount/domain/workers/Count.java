package com.wordcount.domain.workers;

import java.util.List;

public class Count implements Worker {

    public static final String NUMBER_OF_WORDS_TEXT = "Number of words: %d";

    @Override
    public String process(final List<String> words) {
        return String.format(NUMBER_OF_WORDS_TEXT, words.size());
    }
}
