package com.wordcount.domain.handler;

import com.wordcount.domain.handler.individual.WordAverageLengthHandler;
import com.wordcount.domain.handler.individual.WordSizeHandler;
import com.wordcount.domain.handler.individual.WordUniqueCountHandler;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public interface Handler {
    String handle(List<String> words);

    class Core implements Handler {
        List<Handler> handlers = asList(new WordSizeHandler(), new WordUniqueCountHandler(), new WordAverageLengthHandler());

        @Override
        public String handle(List<String> words) {
            return handlers.stream()
                    .map(worker -> worker.handle(words))
                    .collect(joining());
        }
    }
}
