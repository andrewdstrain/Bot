# Bot

The lab text says:

> Create your own exceptions and test them. **Add to Github**

Feel free to _talk_ to the Bot. It has a very limited amount of phrases. If you give it a phrase that it doesn't
understand, it recites poetry to you. Check out the [Bot.java](src/main/java/com/isageek/blaztek/day08/labb/Bot.java)
file in the `chat` method for the list of phrases that it understands.

To exit, press the `EOF` character on your keyboard. On macOS/Linux it is CTRL-D. On Windows, it is CTRL-Z followed by
the Enter key.

__Note:__ IDE terminals, such as IntelliJ IDEA and Eclipse, do not parse END-OF_FILE (`EOF`) properly, or they just screw up for
no apparent reason. Please run via cmd (Windows) or terminal (macOS/Linux).

----

## Quick Install and Run

1. Get the JAR file from the [Releases](https://github.com/andrewdstrain/WozU-Infosys/releases/tag/Bot-1.0) section.
2. Run it:

   ```
   java -jar labB-1.0-week2-day08.jar
   ```

----

## Command Line Instructions

Be sure you have Maven installed to follow these instructions.

1. Clone this repo. Unfortunately, it has everything in one repository.
2. From the base (root) folder, type:

   ```
   cd week2/day08/labB
   ```
3. To create the JAR file, type:

   ```
   mvn package
   ```
4. Then run it by typing:

   ```
   java -jar target/labB-1.0-week2-day08.jar
   ```
