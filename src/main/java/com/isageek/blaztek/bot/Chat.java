package com.isageek.blaztek.bot;

public class Chat implements Runnable {
    public static void main(String[] args) {
        new Chat().run();
    }

    public void run() {
        if (System.console() == null) {
            System.err.println("Error: Run in console, not IDE");
            System.exit(2);
        }
        Bot bot = new Bot();

        System.out.println("Welcome!");

        // Looping will stop at end of file
        while (true) {
            prompt();
            String text = bot.getInput();

                try {
                    text = bot.parseInput(text);
                } catch (NaughtyWordException ex) {
                    System.err.println(ex.getMessage());
                    continue;
                }

            try {
                bot.chat(text);
            } catch (MessageNotParsedException e) {
                e.printStackTrace();
                System.exit(4);
            }

            if (text == null) {
                break;
            }
        }
    }

    private void prompt() {
        System.out.println();
        System.out.print("> ");
    }
}
