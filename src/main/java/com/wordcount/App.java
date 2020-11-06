package com.wordcount;

public class App {
    public static void main(String[] args) {
        final UIable interactable = new ConsoleUI();
        WordCounter wordCounter = new WordCounter(new ConsoleUI());
    }
}