package com.wordcount;

public class Main {
    public static void main(String[] args) {
        Application application = new Application(new ConsoleUI());
        application.run();
    }
}