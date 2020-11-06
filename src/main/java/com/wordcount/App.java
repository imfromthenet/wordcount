package com.wordcount;

public class App {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter(new ConsoleUI());
        wordCounter.run();
    }
}