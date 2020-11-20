package com.wordcount.domain.processors;

import java.util.List;

public class ProcessorsWithIndex implements Processors {
    private final Processors delegate = new Processors.Core();

    @Override
    public String process(final List<String> words) {
        final String baseSolution = delegate.process(words);
        final String indexPart = new Index().process(words);
        return String.format("%s%s", baseSolution, indexPart);
    }
}
