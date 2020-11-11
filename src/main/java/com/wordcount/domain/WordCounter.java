package com.wordcount.domain;

public class WordCounter {
    private int count = 0;
    private Answer answer;
    private static volatile WordCounter collector;

    private WordCounter() {
        if (collector != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public synchronized static WordCounter getInstance() {
        if (collector == null) {
            collector = new WordCounter();
        }
        return collector;
    }

    public void collect(final String candidate) {
        count++;
    }

    public Answer getAnswer() {
        if (answer == null) {
            answer = new Answer(count);
            return answer;
        }
        return answer;
    }
}
