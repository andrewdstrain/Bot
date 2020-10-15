package com.isageek.blaztek.bot;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Bot {
    private final PrintStream log;
    private String parsedMessage;
    private int line;

    private static final List<String> wirtyDords = Arrays.asList("damn", "wtf", "fu");  // Keeping it clean for school
    private static final List<String> roses = Arrays.asList("Roses are red.", "Violets are blue.", "I don't have a heart.", "How can I love you?");

    public Bot() {
        super();
        log = System.out;
        parsedMessage = null;
        line = 0;
    }

    public String getInput() {
        return System.console().readLine();
    }

    public String parseInput(String message) throws NaughtyWordException {
        if (message == null) {
            parsedMessage = null;
            return null;
        }

        // Get rid of multiple spaces, get rid of spaces at beginning and end, and change to lower case.
        parsedMessage = message.replaceAll("[?.!;,] *$", "").replaceAll(" +", " ").trim().toLowerCase();

        // Loop through each word in message
        for (String word : parsedMessage.split(" ")) {
            // Keep it clean folks
            if (wirtyDords.contains(word)) {
                throw new NaughtyWordException();
            }
        }

        return parsedMessage;
    }

    public void chat(String message) throws MessageNotParsedException {
        // only use parsed messages
        if (parsedMessage == null) {
            if (message != null) {
                throw new MessageNotParsedException();
            }
        } else if (! parsedMessage.equals(message)) {
            throw new MessageNotParsedException();
        }

        parsedMessage = null;

        // Very limited sentence recognition. Hello 1980's!
        if (message == null) {
            log.println();
            log.println("Goodbye!");    // This does work - just typically not inside the IDE's terminal window
        } else if (message.equals("hi") || message.equals("hello")) {
            log.println("Hello there!");
        } else if (message.equals("how are you")) {
            log.println("I am doing well. How are you?");
        } else if (message.equals("good") || message.equals("well") || message.equals("fine")) {
            log.println("That's good.");
        } else if (message.equals("who are you")) {
            log.println("My name is Bot. Who are you?");
        } else if (message.equals("what is your name")) {
            log.println("My name is Bot. What is your name?");
        } else if (message.startsWith("i am")) {
            if (message.length() > 5) {
                String name = message.substring(5, 6).toUpperCase() + message.substring(6);
                log.println("Is that really you, " + name + "?");
            } else {
                recite();
            }
        } else if (message.startsWith("my name is")) {
            if (message.length() > 11) {
                String name = message.substring(11, 12).toUpperCase() + message.substring(12);
                log.println("Nice ot meet you " + name + "!");
            } else {
                recite();
            }
        } else if (message.equals("sad")) {
            log.println("Indeed");
        } else if (message.equals("you can't") || message.equals("you can not")) {
            log.println("So true.");
        } else if (message.equals("no")) {
            log.println("Yes!");
        } else if (message.equals("yes")) {
            log.println("No!");
        } else if (message.equals("what are you doing")) {
            log.println("I'm talking to you.");
        } else if (message.contains("it is")) {
            log.println("Okay.");
        } else if (message.contains("feeling")) {
            log.println("I am feeling well.");
        } else if (message.equals("violets are blue")) {
            log.println("Hey! I'm the poet.");
        } else {
            recite();
        }
    }


    private void recite() {
        log.println(roses.get(line++));

        if (line >= 4) {
            line = 0;
        }
    }
}
