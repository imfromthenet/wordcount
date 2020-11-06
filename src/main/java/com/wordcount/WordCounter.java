package com.wordcount;

public class WordCounter {

    public int count(String input) {
//        TODO add guard clauses?
        return prepare(input);
    }

    private int prepare(String input) {
//        TODO: replace with better counter
        return input.split(" ").length;
    }

}
