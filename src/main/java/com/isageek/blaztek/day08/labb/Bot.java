package com.isageek.blaztek.day08.labb;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Bot {
    private final BufferedReader reader;
    private boolean parsed;
    private PrintStream log;
    private int line;

    private static final List<String> wirtyDords = Arrays.asList(new String[] {"damn", "wtf", "fu"});  // Keeping it clean for school
    private static final List<String> roses = Arrays.asList("Roses are red.", "Violets are blue.", "I don't have a heart.", "How can I love you?");

    public Bot() {
        super();
        reader = new BufferedReader(new InputStreamReader(System.in));
        parsed = false;
        log = System.out;
        line = 0;
    }

    public String getInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public String parseInput(String message) throws NaughtyWordException {
        if (message == null) {
            parsed = true;
            return null;
        }

        String parsedMsg;

        // Get rid of multiple spaces, get rid of spaces at beginning and end, and change to lower case.
        parsedMsg = message.replaceAll(" +", " ").trim().replaceAll("[?.!;,]$", "").toLowerCase();

        // Loop through each word in message
        for (String word : parsedMsg.split(" ")) {
            // Keep it clean folks
            if (wirtyDords.contains(word)) {
                throw new NaughtyWordException();
            }
        }

        parsed = true;

        return parsedMsg;
    }

    public void chat(String message) throws MessageNotParsedException {
        // only use parsed messages
        if (! parsed) {
            throw new MessageNotParsedException();
        } else {
            parsed = false;
        }

        // Very limited sentence recognition. Hello 1980's!
        if (message == null) {
            log.println("Goodbye!");    // This does work - just typically not inside the IDE's terminal window
        } else if (message.equals("how are you")) {
            log.println("I am doing well. How are you?");
        } else if (message.equals("good") || message.equals("well") || message.equals("fine")) {
            log.println("That's good.");
        } else if (message.equals("who are you")) {
            log.println("My name is Bot. Who are you?");
        } else if (message.equals("what is your name")) {
            log.println("My name is Bot. What is your name?");
        } else if (message.startsWith("i am") || message.startsWith("my name is")) {
            log.println("Nice ot meet you!");
        } else if (message.equals("sad")) {
            log.println("Indeed");
        } else if (message.equals("you can't") || message.equals("you can not")) {
            log.println("So true.");
        } else {
            sing();
        }
    }

    public void done() {
        try {
            reader.close();
        } catch (IOException ignored) {
        }
    }

    private void sing() {
        log.println(roses.get(line++));

        if (line >= 4) {
            line = 0;
        }
    }
}
