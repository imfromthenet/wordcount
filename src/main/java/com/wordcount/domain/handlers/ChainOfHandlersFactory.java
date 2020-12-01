package com.wordcount.domain.handlers;

import java.util.Arrays;

public class ChainOfHandlersFactory {

    public static ChainOfHandlers construct(String[] args) {
        if (Arrays.asList(args).contains("-index")) {
            return new ChainOfHandlersWithIndex();
        }
        return new ChainOfHandlers.Core();
    }
}
