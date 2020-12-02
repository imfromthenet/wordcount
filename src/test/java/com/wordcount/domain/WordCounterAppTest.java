package com.wordcount.domain;

import com.wordcount.domain.handlers.ChainOfHandlers;
import org.junit.jupiter.api.Test;

import static com.wordcount.TestUtils.throwsNullPointerException;
import static org.mockito.Mockito.mock;

class WordCounterAppTest {

    @Test
    void requiresAllParametersToBeNonNull() {
        throwsNullPointerException(() -> new WordCounterApp(null, null, null));
        throwsNullPointerException(() -> new WordCounterApp(null, mock(StopWords.class), mock(ChainOfHandlers.class)));
        throwsNullPointerException(() -> new WordCounterApp(mock(UI.class), null, mock(ChainOfHandlers.class)));
        throwsNullPointerException(() -> new WordCounterApp(mock(UI.class), mock(StopWords.class), null));
    }
}