package com.wordcount.io;

import com.wordcount.io.console.ConsoleUI;
import com.wordcount.io.console.ConsoleWriter;
import com.wordcount.io.file.FileUI;
import com.wordcount.util.ConsoleReader;

import java.util.Arrays;
import java.util.List;

import static com.wordcount.domain.WordCounterApp.INDEX_FLAG;
import static java.util.stream.Collectors.toList;

public class UIFactory {

    public UI create(final String[] consoleParameters) {
        List<String> nonFlagParameters = getNonFlagParams(consoleParameters);
        if (nonFlagParameters.size() == 0) {
            return new ConsoleUI(new ConsoleWriter(), ConsoleReader.getInstance());
        }
        return new FileUI(nonFlagParameters.get(0));
    }

    private List<String> getNonFlagParams(final String[] consoleParameters) {
        return Arrays.stream(consoleParameters)
                .filter(param -> !INDEX_FLAG.equals(param))
                .collect(toList());
    }
}
