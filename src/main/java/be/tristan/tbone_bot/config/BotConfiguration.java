package be.tristan.tbone_bot.config;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;

public class BotConfiguration {
    private BotConfiguration() {
        try {
            String botToken = System.getenv("BOT_TOKEN");

            JDABuilder.createLight(botToken, EnumSet.of(
                    GatewayIntent.GUILD_MESSAGES
            )).build().awaitReady();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static class BotHolder {
        private static final BotConfiguration INSTANCE = new BotConfiguration();
    }

    public static BotConfiguration getInstance() {
        return BotHolder.INSTANCE;
    }
}
