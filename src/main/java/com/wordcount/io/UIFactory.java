package com.wordcount.io;

import com.wordcount.io.console.ConsoleReader;
import com.wordcount.io.console.ConsoleUI;
import com.wordcount.io.console.ConsoleWriter;
import com.wordcount.io.file.FileUI;

import java.util.Arrays;
import java.util.List;

import static com.wordcount.domain.WordCounterApp.DICT_FLAG;
import static com.wordcount.domain.WordCounterApp.INDEX_FLAG;
import static java.util.stream.Collectors.toList;

public class UIFactory {

    public UIable getFactory(final String[] consoleParameters) {
        List<String> nonFlagParameters = getNonFlagParams(consoleParameters);
        if (nonFlagParameters.size() == 0) {
            return new ConsoleUI(new ConsoleWriter(), new ConsoleReader());
        } else {
            return new FileUI(nonFlagParameters.get(0));
        }
    }

    private List<String> getNonFlagParams(final String[] consoleParameters) {
        return Arrays.stream(consoleParameters)
                .filter(param -> !INDEX_FLAG.equals(param) && !param.startsWith(DICT_FLAG))
                .collect(toList());
    }
}
