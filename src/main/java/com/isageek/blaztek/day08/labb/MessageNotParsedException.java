package com.isageek.blaztek.day08.labb;

public class MessageNotParsedException extends Exception {
    public MessageNotParsedException() {
        super("Must parse message first.");
    }

    public MessageNotParsedException(String message) {
        super(message);
    }
}
