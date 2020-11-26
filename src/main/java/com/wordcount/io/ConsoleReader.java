package com.wordcount.io;

import java.util.List;
import java.util.Scanner;

import static java.util.Collections.singletonList;

public class ConsoleReader implements Reader {

    @Override
    public String read() {
        return new Scanner(System.in).nextLine();
    }

    @Override
    public List<String> readAsList() {
        return singletonList(read());
    }

}