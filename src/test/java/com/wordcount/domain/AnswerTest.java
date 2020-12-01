package com.wordcount.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @Test
    void answerProvidesCorrectMessage() {
        final Answer sut = new Answer(3, 2);

        assertThat(sut.getFormatted()).startsWith("Number of words:")
                .contains("3")
                .contains("unique")
                .contains("2");
    }
}