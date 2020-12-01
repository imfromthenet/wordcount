package com.wordcount.domain.handlers;

import java.util.List;

public class ChainOfHandlersWithIndex implements ChainOfHandlers {
    private ChainOfHandlers delegate =  new ChainOfHandlers.Core();

    @Override
    public String handle(List<String> words) {
        String coreSolution = delegate.handle(words);
        String indexPartOfSolution = new IndexHandler().handle(words);
        return String.format("%s%s", coreSolution, indexPartOfSolution);
    }
}
