package com.example.telegram.config;
import com.example.telegram.service.TelegramWebHooks;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotInitializer implements ApplicationRunner {
    @Value("${telegram.bot.webhookPath}")
    private String webhookPath;
    private final TelegramWebHooks telegramBot;  // Component: constructor Autowired
    @Autowired
    public BotInitializer(TelegramWebHooks telegramBot) {
        this.telegramBot = telegramBot;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            // Create a SetWebhook object with your webhook URL
            SetWebhook setWebhook = new SetWebhook();
            setWebhook.setUrl(webhookPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
