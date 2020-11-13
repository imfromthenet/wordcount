package com.wordcount;

import com.wordcount.domain.Answer;
import com.wordcount.domain.InputPreparer;
import com.wordcount.domain.Processor;
import com.wordcount.domain.WordCounter;
import com.wordcount.io.console.Writer;

import java.util.Objects;

public class Application {

    private final InputPreparer inputPreparer;
    private final Processor processor;
    private final WordCounter wordCounter;
    private final String[] parameter;
    private final Writer writer;

    public Application(final InputPreparer inputPreparer, final Processor processor, final WordCounter wordCounter, final String[] parameter, Writer writer) {
        this.inputPreparer = Objects.requireNonNull(inputPreparer);
        this.processor = Objects.requireNonNull(processor);
        this.wordCounter = Objects.requireNonNull(wordCounter);
        this.parameter = parameter;
        this.writer = writer;
    }

    public void run() {
        String input = inputPreparer.getInput(parameter);
        processor.process(input);
        final Answer answer = wordCounter.getAnswer();
        writer.write(answer.toString());
    }

}
