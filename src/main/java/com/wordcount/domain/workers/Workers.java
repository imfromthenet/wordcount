package com.wordcount.domain.workers;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public interface Workers {

    String work(final List<String> words);

    class Core implements Workers {
        final List<Worker> workers = Arrays.asList(new Count(), new UniqueCount(), new AverageLength());

        @Override
        public String work(final List<String> words) {
            return workers.stream()
                    .map(worker -> worker.process(words))
                    .collect(joining());
        }
    }
}
