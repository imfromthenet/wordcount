package com.wordcount.domain.handlers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChainOfHandlersFactoryTest {

    @Test
    void constructsChainOfHandlesWithIndex() {
        ChainOfHandlers chainOfHandlers = ChainOfHandlersFactory.construct(new String[]{"-index"});

        assertThat(chainOfHandlers).isExactlyInstanceOf(ChainOfHandlersWithIndex.class);
    }

    @Test
    void constructsChainOfHandlesWithoutIndex() {
        ChainOfHandlers chainOfHandlers = ChainOfHandlersFactory.construct(new String[]{});

        assertThat(chainOfHandlers).isExactlyInstanceOf(ChainOfHandlers.Core.class);
    }
}