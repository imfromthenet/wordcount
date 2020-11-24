package com.wordcount.domain.processors;

import com.wordcount.domain.MyDictionary;

import java.util.List;

public class ProcessorsWithIndexAndDictionary implements Processors {
    private final MyDictionary knownWords;
    private final Processors delegate = new Processors.Core();

    public ProcessorsWithIndexAndDictionary(final MyDictionary knownWords) {
        this.knownWords = knownWords;
    }

    @Override
    public String process(final List<String> words) {
        final String baseSolution = delegate.process(words);
        final String indexPart = new DictionaryProcessor(knownWords).process(words);
        return String.format("%s%s", baseSolution, indexPart);
    }
}
