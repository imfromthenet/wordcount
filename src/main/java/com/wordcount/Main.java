package com.wordcount;

import com.wordcount.domain.KnownWords;
import com.wordcount.domain.MyDictionary;
import com.wordcount.domain.StopWords;
import com.wordcount.domain.WordCounterApp;
import com.wordcount.io.UIFactory;
import com.wordcount.io.UIable;
import com.wordcount.io.console.ConsoleWriter;
import com.wordcount.io.console.Writer;
import com.wordcount.io.file.FileReader;

import java.util.Arrays;

import static com.wordcount.domain.WordCounterApp.DICTIONARY_FLAG;
import static java.util.Collections.emptyList;

public class Main {
    public static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        final FileReader fileReader = new FileReader();
        final MyDictionary stopWords = getStopWords(fileReader);
        final MyDictionary knownWords = getKnownWords(fileReader, args);

        final Writer consoleWriter = new ConsoleWriter();

        final UIFactory uiFactory = new UIFactory();
        final UIable ui = uiFactory.getFactory(args);
        final String input = ui.getInput();

        final WordCounterApp wordCounterApp =
                new WordCounterApp(
                        input,
                        consoleWriter,
                        stopWords,
                        knownWords);
        wordCounterApp.countWords(args);
    }

    private static MyDictionary getKnownWords(final FileReader fileReader, final String[] args) {
        return Arrays.stream(args)
                .filter(arg -> arg.startsWith(DICTIONARY_FLAG))
                .map(arg -> arg.replace(DICTIONARY_FLAG, ""))
                .findAny()
                .map(fileName -> new KnownWords(fileReader.read(fileName)))
                .orElseGet(() -> new KnownWords(emptyList()));
    }

    private static MyDictionary getStopWords(final FileReader fileReader) {
        return new StopWords(fileReader.read(STOP_WORDS_FILE));
    }
}