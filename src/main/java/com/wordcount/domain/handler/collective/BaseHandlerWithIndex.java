package com.wordcount.domain.handler.collective;

import com.wordcount.domain.handler.Handler;
import com.wordcount.domain.handler.individual.WordIndexHandler;

import java.util.List;

public class BaseHandlerWithIndex implements Handler {

    private Handler delegate = new Handler.Core();

    @Override
    public String handle(List<String> words) {
        String baseSolution = delegate.handle(words);
        String indexPartOfSolution = new WordIndexHandler().handle(words);
        return baseSolution + indexPartOfSolution;
    }

}
