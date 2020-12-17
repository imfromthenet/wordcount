package com.wordcount.domain.handler.collective;

import com.wordcount.domain.handler.Handler;

import java.util.List;

public class BaseHandler implements Handler {
    private Handler delegate = new Handler.Core();

    @Override
    public String handle(List<String> words) {
        return delegate.handle(words);
    }

}
