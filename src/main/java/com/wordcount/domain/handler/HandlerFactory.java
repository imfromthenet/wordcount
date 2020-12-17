package com.wordcount.domain.handler;

import com.wordcount.domain.handler.collective.BaseHandler;
import com.wordcount.domain.handler.collective.BaseHandlerWithIndex;

import java.util.Arrays;

public class HandlerFactory {

    public static Handler construct(String[] params) {
        if (hasIndexFlag(params)) {
            return new BaseHandlerWithIndex();
        }
        return new BaseHandler();
    }

    private static boolean hasIndexFlag(String[] params) {
        return Arrays.asList(params).contains("-index");
    }

}
