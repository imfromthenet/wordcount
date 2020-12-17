package com.wordcount.io;

import com.wordcount.domain.UI;

import java.util.Arrays;
import java.util.Optional;

public class UIFactory {

    public static UI construct(String[] consoleParameters) {
        Optional<String> firstNonFlagArg = getNonFlagArgumentFrom(consoleParameters);
        if (firstNonFlagArg.isPresent()) {
            return new UIImpl(new ConsoleUI(), new FileInputUI(firstNonFlagArg.get()));
        }
        return new ConsoleUI();
    }

    private static Optional<String> getNonFlagArgumentFrom(String[] consoleParameters) {
        return Arrays.stream(consoleParameters)
                .filter(p -> !p.startsWith("-"))
                .findFirst();
    }

}
