package com.wordcount;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestUIHelper {

    public static ByteArrayOutputStream getOutputRecorder() {
        ByteArrayOutputStream outputRecorder = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputRecorder));
        return outputRecorder;
    }

    public static void simulateUserConsoleInputOf(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
    }
}
