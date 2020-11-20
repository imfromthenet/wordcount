package com.wordcount.domain.processors;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public interface Processors {

    String process(final List<String> words);

    class Core implements Processors {
        final List<Processor> processors = Arrays.asList(new Count(), new UniqueCount(), new AverageLength());

        @Override
        public String process(final List<String> words) {
            return processors.stream()
                    .map(worker -> worker.process(words))
                    .collect(joining());
        }
    }
}
