package com.wordcount.domain.workers;

import java.util.Arrays;

import static com.wordcount.domain.WordCounterApp.INDEX_FLAG;

public class WorkersFactory {

    public Workers getWorkers(final String[] args){
        if (Arrays.asList(args).contains(INDEX_FLAG)) {
            return new WorkersWithIndex();
        } else {
            return new Workers.Core();
        }
    }
}
