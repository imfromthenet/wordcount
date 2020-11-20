package com.wordcount.domain.processors;

import java.util.List;

public interface Processor {

    String process(final List<String> words);
}
