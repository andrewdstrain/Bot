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
        String message = "   Hello   there  !   ";

        Assertions.assertDoesNotThrow(() -> {
            String parsedMessage = bot.parseInput(message);
            Assertions.assertEquals("hello there", parsedMessage);
            Assertions.assertDoesNotThrow(() -> bot.chat(parsedMessage));
        });

        Assertions.assertThrows(NaughtyWordException.class, () -> bot.parseInput("WTF?"));
        Assertions.assertThrows(MessageNotParsedException.class, () -> bot.chat("not parsed"));

    }
}
