package com.isageek.blaztek.bot;

public class MessageNotParsedException extends Exception {
    public MessageNotParsedException() {
        super("Must parse message first.");
    }

    public MessageNotParsedException(String message) {
        super(message);
    }
}
