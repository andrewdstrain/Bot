package com.isageek.blaztek.bot;

public class NaughtyWordException extends Exception {
    public NaughtyWordException() {
        super("That type of language is not allowed here.");
    }

    public NaughtyWordException(String message) {
        super(message);
    }
}
