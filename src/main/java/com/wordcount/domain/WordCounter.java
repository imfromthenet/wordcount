package com.wordcount.domain;

class WordCounter {
    private int count = 0;
    private Answer answer;

    void collect(final String candidate) {
        count++;
    }

    Answer getAnswer() {
        if (answer == null) {
            answer = new Answer(count);
            return answer;
        }
        return answer;
    }
}
