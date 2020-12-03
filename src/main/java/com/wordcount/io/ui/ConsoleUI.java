package com.wordcount.io.ui;

import com.wordcount.domain.UI;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements UI {

    private static final String PROMPT_FOR_INPUT = "Enter text: ";

    public String getUserInput() {
        this.show(PROMPT_FOR_INPUT);
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void show(String result) {
        Objects.requireNonNull(result);
        System.out.print(result);
    }
}
