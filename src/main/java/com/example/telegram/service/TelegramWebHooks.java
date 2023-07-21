package com.example.telegram.service;

import com.example.telegram.service.interfaces.TelegramMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramWebHooks extends TelegramWebhookBot {
    @Autowired
    private TelegramMethodService telegramMethodService;

    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.bot.webhookPath}")
    private String webhookPath;

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotPath() {
        return webhookPath;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }


    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        SendPhoto sendPhoto = new SendPhoto();

        if (update.hasMessage()) {
            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

//    update.getChatMember().

            Chat senderChat = update.getMessage().getSenderChat();

             if (null != update.getMessage().getGame() && update.getMessage().getGame().getTitle().equals("wonder games")){
                String link = "https://www.youtube.com/";
                sendMessage.setChatId(chatId);
                sendMessage.setText(link);
            }

            // command based functionalities
            if (null != text && text.equals("/command1")) {
                sendMessage.setChatId(String.valueOf(chatId));
                sendMessage.setText("This is Command 1");
                try {
                    execute(sendMessage);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (null != text && text.equals("/command2")) {
                sendMessage.setChatId(String.valueOf(chatId));
                sendMessage.setText("This is Command 2");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (null != text && text.equals("Categories")) {
                SendMessage message = telegramMethodService.sendMessageWithCategoriesKeyboard(chatId, telegramMethodService.category());
                try {
                    execute(message);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (null != text && text.equals("hi")) {
                String htmlMessage = "<b>Game Rules:</b>\n"
                        + "<i>These are the rules of the game...</i>\n"
                        + "<a href=\"https://www.youtube.com/\">Click here for more details</a>";
                sendMessage.setChatId(String.valueOf(chatId));
                sendMessage.setText(htmlMessage);
                sendMessage.setParseMode("HTML");

                InlineKeyboardMarkup res = telegramMethodService.inlineKeyboardButton();
                sendMessage.setReplyMarkup(res);

                sendPhoto.setChatId(String.valueOf(chatId));
                sendPhoto.setPhoto(telegramMethodService.sendPhoto());

                try {
                    execute(sendPhoto);
                    execute(sendMessage);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

                sendMessage.setChatId(String.valueOf(chatId));
                sendMessage.setText("Choose one");
                sendMessage.setReplyMarkup(telegramMethodService.mainCategory());
                try {
                    execute(sendMessage);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }


            }


            System.out.println("Ari " + text);
        } else if (update.hasCallbackQuery()) {  // callback Query for button functionality
            Message message = update.getCallbackQuery().getMessage();
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            String callBackQueryID = callbackQuery.getId();
            Long chatId = callbackQuery.getMessage().getChatId();
            Integer messageId = callbackQuery.getMessage().getMessageId();

            SendMessage sendMessage1 = new SendMessage();

            if (data.equals("button1")) {
                sendMessage1.setText("Button 1 start");
                sendMessage1.setChatId(String.valueOf(message.getChatId()));
                try {
                    execute(sendMessage1);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (data.equals("button2")) {
                EditMessageText new_message = new EditMessageText();
                new_message.setChatId(String.valueOf(message.getChatId()));
                new_message.setMessageId(message.getMessageId());
                new_message.setText("updated the text");
                new_message.setReplyMarkup(callbackQuery.getMessage().getReplyMarkup());

                try {
                    execute(new_message);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (data.equals("button3")) { // for popup message
                AnswerCallbackQuery popupAlert = new AnswerCallbackQuery();
                popupAlert.setCallbackQueryId(callBackQueryID);
                popupAlert.setText("Message");
                popupAlert.setShowAlert(true);
                try {
                    execute(popupAlert);

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
