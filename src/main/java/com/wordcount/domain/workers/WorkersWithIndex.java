package com.wordcount.domain.workers;

import java.util.List;

public class WorkersWithIndex implements Workers {
    private final Workers delegate = new Workers.Core();

    @Override
    public String work(final List<String> words) {
        final String baseSolution = delegate.work(words);
        final String indexPart = new Index().process(words);
        return String.format("%s%s", baseSolution, indexPart);
    }
}
