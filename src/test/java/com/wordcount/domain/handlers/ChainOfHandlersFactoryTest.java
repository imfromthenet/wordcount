package com.wordcount.domain.handlers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChainOfHandlersFactoryTest {

    @Test
    void constructsChainOfHandlesWithIndexIfIndexFlagIsProvided() {
        ChainOfHandlers chainOfHandlers = ChainOfHandlersFactory.construct(new String[]{"-index"});

        assertThat(chainOfHandlers).isExactlyInstanceOf(ChainOfHandlersWithIndex.class);
    }

    @Test
    void constructsChainOfHandlesWithoutIndexIfIndexFlagIsNotProvided() {
        ChainOfHandlers chainOfHandlers = ChainOfHandlersFactory.construct(new String[]{});

        assertThat(chainOfHandlers).isNotInstanceOf(ChainOfHandlersWithIndex.class);
    }
}