import com.isageek.blaztek.bot.Bot;
import com.isageek.blaztek.bot.MessageNotParsedException;
import com.isageek.blaztek.bot.NaughtyWordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bot Test")
public class BotTest {
    @Test
    void mrRoboto() {
        Bot bot = new Bot();
        String message = "   How   are  you  ?   ";

        Assertions.assertDoesNotThrow(() -> {
            String parsedMessage = bot.parseInput(message);
            Assertions.assertEquals("how are you", parsedMessage);
            Assertions.assertDoesNotThrow(() -> bot.chat(parsedMessage));

            String pm = bot.parseInput("Who do you love?");
            Assertions.assertEquals("who do you love", pm);
            Assertions.assertDoesNotThrow(() -> bot.chat(pm));
        });

        Assertions.assertThrows(NaughtyWordException.class, () -> bot.parseInput("WTF?"));
        Assertions.assertThrows(MessageNotParsedException.class, () -> bot.chat("not parsed"));

    }
}
