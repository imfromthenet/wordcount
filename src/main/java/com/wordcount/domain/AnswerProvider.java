package com.wordcount.domain;

import com.wordcount.domain.workers.Worker;

import java.util.List;

import static java.util.stream.Collectors.joining;

class AnswerProvider {
    private final List<String> words;
    private final List<Worker> workers;

    AnswerProvider(final List<String> words, List<Worker> workers) {
        this.words = words;
        this.workers = workers;
    }

    String getAnswer() {
        return workers.stream()
                .map(worker -> worker.process(words))
                .collect(joining());
    }
}
