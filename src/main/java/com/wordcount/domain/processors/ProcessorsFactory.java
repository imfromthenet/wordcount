package com.wordcount.domain.processors;

import com.wordcount.domain.MyDictionary;

import java.util.Arrays;
import java.util.function.Predicate;

import static com.wordcount.domain.WordCounterApp.DICTIONARY_FLAG;
import static com.wordcount.domain.WordCounterApp.INDEX_FLAG;

public class ProcessorsFactory {

    public Processors getProcessors(final String[] args, final MyDictionary knownWords) {
        if (hasIndexAndDictionaryParam(args)) {
            return new ProcessorsWithIndexAndDictionary(knownWords);
        } else if (Arrays.asList(args).contains(INDEX_FLAG)) {
            return new ProcessorsWithIndex();
        }
        return new Processors.Core();
    }
    
    private boolean hasIndexAndDictionaryParam(final String[] consoleParameters) {
        final Predicate<String> dictionaryFlagPredicate = word -> word.startsWith(DICTIONARY_FLAG);
        final Predicate<String> indexFlagPredicate = word -> word.equals(INDEX_FLAG);
        return hasFlag(consoleParameters, dictionaryFlagPredicate) &&
                hasFlag(consoleParameters, indexFlagPredicate);
    }

    private boolean hasFlag(final String[] consoleParameters, final Predicate<String> flagPredicate) {
        return Arrays.stream(consoleParameters).anyMatch(flagPredicate);
    }
}
