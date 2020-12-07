package com.wordcount.io.ui;

import com.wordcount.domain.UI;
import com.wordcount.io.InputUI;
import com.wordcount.io.OutputUI;

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
