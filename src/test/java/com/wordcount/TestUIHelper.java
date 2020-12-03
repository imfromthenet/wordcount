package com.wordcount;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestUIHelper {

    public static ByteArrayOutputStream getTestConsoleOutputRecorder() {
        ByteArrayOutputStream testConsoleOutputRecorder = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testConsoleOutputRecorder));
        return testConsoleOutputRecorder;
    }

    public static void simulateUserConsoleInputOf(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
    }
}
