package com.wordcount.io.console;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    private static ConsoleReader instance;

    private ConsoleReader() {}

    public static synchronized ConsoleReader getInstance() {
        if (instance == null) {
            instance = new ConsoleReader();
        }
        return instance;
    }

    public String read() {
        return new Scanner(System.in).nextLine();
    }

}