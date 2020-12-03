package com.wordcount;

import org.assertj.core.api.ThrowableAssert;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AssertionHelper {

    public static void throwsNullPointerException(ThrowableAssert.ThrowingCallable throwingCallable) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(throwingCallable);
    }
}
