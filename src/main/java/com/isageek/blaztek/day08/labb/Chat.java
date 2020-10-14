package com.isageek.blaztek.day08.labb;

public class Chat implements Runnable {
    public static void main(String[] args) {
        new Chat().run();
    }

    public void run() {
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
                }

            try {
                bot.chat(text);
            } catch (MessageNotParsedException e) {
                e.printStackTrace();
                bot.done();
                System.exit(-1);
            }

            if (text == null) {
                bot.done();
                break;
            }
        }
    }

    private void prompt() {
        System.out.println();
        System.out.print("> ");
    }
}
