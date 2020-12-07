package com.wordcount.io;

import com.wordcount.domain.UI;

import java.util.Objects;

public class ConsoleOutputFileInputUI implements UI {

    private OutputUI outputUI;
    private InputUI inputUI;

    public ConsoleOutputFileInputUI(OutputUI outputUI, InputUI inputUI) {
        Objects.requireNonNull(this.outputUI = outputUI);
        Objects.requireNonNull(this.inputUI = inputUI);
    }

    @Override
    public String getInput() {
        return inputUI.getInput();
    }

    @Override
    public void show(String result) {
        outputUI.show(result);
    }
}
