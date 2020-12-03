package com.wordcount;

import org.assertj.core.api.ThrowableAssert;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AssertionHelper {

    public static void assertThrowsNullPointerException(ThrowableAssert.ThrowingCallable throwingCallable) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(throwingCallable);
    }
}
