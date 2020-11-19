package com.wordcount.domain.workers;

import java.util.List;

public interface Worker {

    String process(final List<String> words);
}
