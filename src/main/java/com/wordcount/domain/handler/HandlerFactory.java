package com.wordcount.domain.handler;

import com.wordcount.domain.handler.collective.BaseHandler;
import com.wordcount.domain.handler.collective.BaseHandlerWithIndex;

import java.util.List;

public class HandlerFactory {

    public static Handler construct(List<String> params) {
        if (params.contains("-index")) {
            return new BaseHandlerWithIndex();
        }
        return new BaseHandler();
    }

}
