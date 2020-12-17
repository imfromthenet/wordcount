package com.wordcount.domain.handler.collective;

import com.wordcount.domain.handler.Handler;
import com.wordcount.domain.handler.individual.WordAverageLengthHandler;
import com.wordcount.domain.handler.individual.WordSizeHandler;
import com.wordcount.domain.handler.individual.WordUniqueCountHandler;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class BaseHandler implements Handler {
    @Override
    public String handle(List<String> words) {
        return new Core().handle(words);
    }

    static class Core implements Handler {
        List<Handler> handlers = Arrays.asList(new WordSizeHandler(), new WordUniqueCountHandler(), new WordAverageLengthHandler());

        @Override
        public String handle(List<String> words) {
            return handlers.stream()
                    .map(worker -> worker.handle(words))
                    .collect(joining());
        }
    }

}
