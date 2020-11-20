package com.wordcount.domain.processors;

import java.util.Arrays;

import static com.wordcount.domain.WordCounterApp.INDEX_FLAG;

public class ProcessorsFactory {

    public Processors getProcessors(final String[] args){
        if (Arrays.asList(args).contains(INDEX_FLAG)) {
            return new ProcessorsWithIndex();
        } else {
            return new Processors.Core();
        }
    }
}
