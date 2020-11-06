package com.wordcount;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class UserInteractorTest {

    @Test
    void displayMessage() {
        PrintStream outSpy = spy(new PrintStream(System.out));
        UserInteractable userInteractor = new UserInteractor(outSpy);

        userInteractor.displayMessage("message");

        verify(outSpy, times(1)).println(anyString());
        verifyNoMoreInteractions(outSpy);
    }

    //    private final PrintStream standardOut = System.out;
//    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//
//    @BeforeEach
//    public void setUp() {
//        System.setOut(new PrintStream(outputStreamCaptor));
//    }
//
//    @AfterEach
//    public void tearDown() {
//        System.setOut(standardOut);
//    }
//
//    @Test
//    void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
//        System.out.print("Hello Baeldung Readers!!");
//
//        assertEquals("Hello Baeldung Readers!!", outputStreamCaptor.toString().trim());
//    }

}