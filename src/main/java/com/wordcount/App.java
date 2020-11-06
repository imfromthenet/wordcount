package com.wordcount;

public class App {
    public static void main(String[] args) {
        final UserInteractable interactable = new UserInteractor(System.out);
        interactable.displayMessage("Enter text: ");
    }
}