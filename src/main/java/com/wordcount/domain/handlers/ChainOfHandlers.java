package com.wordcount.domain.handlers;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public interface ChainOfHandlers {
    String handle(List<String> words);

    class Core implements ChainOfHandlers {
        List<Handler> handlers = Arrays.asList(new WordCountHandler(), new UniqueWordsCountHandler(), new AverageLengthHandler());

        @Override
        public String handle(List<String> words) {
            return handlers.stream()
                    .map(worker -> worker.handle(words))
                    .collect(joining());
        }
    }
}
