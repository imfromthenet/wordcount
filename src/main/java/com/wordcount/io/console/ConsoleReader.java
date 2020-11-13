package com.wordcount.io.console;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    public String read() {
        return new Scanner(System.in).nextLine();
    }

}