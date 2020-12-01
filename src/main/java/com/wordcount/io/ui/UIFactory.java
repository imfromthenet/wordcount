package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.ConsoleReader;
import com.wordcount.io.ConsoleWriter;
import com.wordcount.io.FileReader;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class UIFactory {

    public static UI construct(String[] consoleParameter) {
        List<String> nonFlagParams = getNonFlagParams(consoleParameter);

        if (nonFlagParams.size() == 1) {
            return new ConsoleWriterFileReaderUI(new ConsoleWriter(), new FileReader(nonFlagParams.get(0)));
        }
        return new ConsoleUI(new ConsoleWriter(), new ConsoleReader());
    }

    private static List<String> getNonFlagParams(String[] consoleParameter) {
        return Arrays.stream(consoleParameter).filter(param -> !param.equals("-index")).collect(toList());
    }
}
