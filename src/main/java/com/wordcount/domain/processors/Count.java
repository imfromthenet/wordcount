package com.wordcount.domain.processors;

import java.util.List;

public class Count implements Processor {

    public static final String NUMBER_OF_WORDS_TEXT = "Number of words: %d";

    @Override
    public String process(final List<String> words) {
        return String.format(NUMBER_OF_WORDS_TEXT, words.size());
    }
}
