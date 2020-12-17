package com.wordcount.io;

import com.wordcount.domain.UI;

import java.util.List;
import java.util.Optional;

public class UIFactory {

    public static UI construct(List<String> consoleParameters) {
        Optional<String> firstNonFlagArg = getNonFlagArgumentFrom(consoleParameters);
        if (firstNonFlagArg.isPresent()) {
            return new UIImpl(new ConsoleUI(), new FileInputUI(firstNonFlagArg.get()));
        }
        return new ConsoleUI();
    }

    private static Optional<String> getNonFlagArgumentFrom(List<String> consoleParameters) {
        return consoleParameters.stream()
                .filter(p -> !p.startsWith("-"))
                .findFirst();
    }

}
