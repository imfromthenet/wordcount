package com.wordcount.io;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    @Override
    public String read() {
        return new Scanner(System.in).nextLine();
    }
}