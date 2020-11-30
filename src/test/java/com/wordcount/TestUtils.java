package com.wordcount;

import org.assertj.core.api.ThrowableAssert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TestUtils {

    public static ByteArrayOutputStream getOutputRecorder() {
        ByteArrayOutputStream outputRecorder = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputRecorder));
        return outputRecorder;
    }

    public static void simulateUserConsoleInputOf(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
    }

    public static void throwsNullPointerException(ThrowableAssert.ThrowingCallable throwingCallable) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(throwingCallable);
    }
}
